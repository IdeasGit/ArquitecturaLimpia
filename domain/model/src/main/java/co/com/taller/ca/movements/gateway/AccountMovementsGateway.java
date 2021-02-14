package co.com.taller.ca.movements.gateway;

import co.com.taller.ca.movements.model.Account;
import co.com.taller.ca.movements.model.AccountTransactions;
import co.com.taller.ca.movements.model.BalancesDeposit;
import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import reactor.core.publisher.Mono;

public interface AccountMovementsGateway {
    public Mono<AccountTransactions> consultMovementDeposit(DataAccountTransactionRQ request);

    public Mono<BalancesDeposit> consultBalanceDeposit(Account request);

}
