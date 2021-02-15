package co.com.taller.ca.movements.deposit;

import co.com.taller.ca.movements.gateway.AccountMovementsGateway;
import co.com.taller.ca.movements.model.Account;
import co.com.taller.ca.movements.model.AccountTransactions;
import co.com.taller.ca.movements.model.BalancesDeposit;
import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import co.com.taller.ca.movements.model.DataAccountTransactionsRS;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Setter
@Component
public class MovementsDeposit implements AccountMovementsGateway {
    @Value("${Servicio.urlMovements}")
    private String urlMovements;
    @Value("${Servicio.urlBalances}")
    private String urlBalances;

    @Override
    public Mono<AccountTransactions> consultMovementDeposit(DataAccountTransactionRQ request) {

        return WebClient.builder()
                .baseUrl(urlMovements).build().post()
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), DataAccountTransactionRQ.class).retrieve()
                .bodyToMono(DataAccountTransactionsRS.class).map(r -> r.getData());
    }

    @Override
    public Mono<BalancesDeposit> consultBalanceDeposit(Account request) {

        return WebClient.builder()
                .baseUrl(urlBalances).build().post()
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), Account.class).retrieve()
                .bodyToMono(BalancesDeposit.class);
    }
}