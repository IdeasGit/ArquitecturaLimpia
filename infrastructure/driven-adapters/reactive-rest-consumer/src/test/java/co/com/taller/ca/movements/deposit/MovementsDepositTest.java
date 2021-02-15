package co.com.taller.ca.movements.deposit;

import co.com.taller.ca.movements.model.Account;
import co.com.taller.ca.movements.model.AccountTransactionRQ;
import co.com.taller.ca.movements.model.AccountTransactions;
import co.com.taller.ca.movements.model.BalancesDeposit;
import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import co.com.taller.ca.movements.model.TransactionRs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class MovementsDepositTest {

    public static MockWebServer mockServer;
    public static Account account;

    @BeforeEach
    public void setUp() throws IOException {
        account = new Account();
        account.setNumber("12345678901");
        account.setType("CUANTA_CORRIENTE");
        mockServer = new MockWebServer();
        mockServer.start();
    }

    @AfterEach
    public void setDown() throws IOException {
        mockServer.shutdown();
    }

    @Test
    public void consultMovementDeposit() throws JsonProcessingException {
        //Se setea la inforacion al request
        AccountTransactionRQ accountTransactionRQ = new AccountTransactionRQ();
        accountTransactionRQ.setAccount(account);
        DataAccountTransactionRQ data = new DataAccountTransactionRQ();
        data.setData(accountTransactionRQ);

        //Se arma el response
        TransactionRs transactionRs = new TransactionRs();
        transactionRs.setAmount("2000");
        List<TransactionRs> transactionRsList = new ArrayList<>();
        transactionRsList.add(transactionRs);

        //Se simula la respuesta JSON
        AccountTransactions response = new AccountTransactions();
        response.setTransaction(transactionRsList);
        ObjectMapper mapper = new ObjectMapper();
        mockServer.enqueue(new MockResponse().setResponseCode(HttpStatus.OK.value())
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(response)));

        //Se setean propiedades para llamar al servicio simulado
        MovementsDeposit movementsDeposit = new MovementsDeposit();
        movementsDeposit.setUrlMovements(mockServer.url("/retrieveTransaction").toString());

        Mono<AccountTransactions> accountTransactionsMono = movementsDeposit.consultMovementDeposit(data);

        StepVerifier.create(accountTransactionsMono).verifyError();
    }

    @Test
    public void consultBalanceDepositTest() throws JsonProcessingException {

        BalancesDeposit response = new BalancesDeposit();
        response.setEffective(new BigDecimal(2000));
        ObjectMapper mapper = new ObjectMapper();
        mockServer.enqueue(new MockResponse().setResponseCode(HttpStatus.OK.value())
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(mapper.writeValueAsString(response)));

        MovementsDeposit movementsDeposit = new MovementsDeposit();
        movementsDeposit.setUrlBalances(mockServer.url("/retrieveBalance").toString());
        Mono<BalancesDeposit> balancesDepositMono = movementsDeposit.consultBalanceDeposit(account);

        StepVerifier.create(balancesDepositMono).expectNextMatches(b -> b.getEffective().intValue() == 2000).verifyComplete();

    }
}