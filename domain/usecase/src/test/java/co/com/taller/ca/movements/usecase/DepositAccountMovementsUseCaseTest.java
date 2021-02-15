package co.com.taller.ca.movements.usecase;

import co.com.taller.ca.movements.gateway.AccountMovementsGateway;
import co.com.taller.ca.movements.model.Account;
import co.com.taller.ca.movements.model.AccountTransactionRQ;
import co.com.taller.ca.movements.model.BalanceDepositAccount;
import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import co.com.taller.ca.movements.model.DataBalanceDepositAccount;
import co.com.taller.ca.movements.model.ResponseBalanceDepositAccount;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class DepositAccountMovementsUseCaseTest {

    @Mock
    private AccountMovementsGateway accountMovementsGateway;

    @Test
    public void getAccountMovementsTest() {
        //Se setea el request
        Account account = new Account();
        account.setNumber("12345678901");
        account.setType("CUANTA_CORRIENTE");

        AccountTransactionRQ accountTransactionRQ = new AccountTransactionRQ();
        accountTransactionRQ.setAccount(account);
        DataAccountTransactionRQ dataAccountTransactionRQ = DataAccountTransactionRQ.builder().data(accountTransactionRQ).build();

        //Se setea el response
        DataBalanceDepositAccount dataBalanceDepositAccount = DataBalanceDepositAccount.builder()
                .account(BalanceDepositAccount.builder().flagMoreRecords(true).build()).build();
        List<DataBalanceDepositAccount> dataBalanceDepositAccountList = new ArrayList<>();
        dataBalanceDepositAccountList.add(dataBalanceDepositAccount);
        ResponseBalanceDepositAccount responseBalanceDepositAccount = new ResponseBalanceDepositAccount();
        responseBalanceDepositAccount.setData(dataBalanceDepositAccountList);
    }

    @Test
    public void createResponseTest() {
    }
}