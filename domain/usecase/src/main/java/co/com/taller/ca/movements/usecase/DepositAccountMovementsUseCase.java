package co.com.taller.ca.movements.usecase;

import co.com.taller.ca.movements.model.AccountTransactions;
import co.com.taller.ca.movements.model.BalanceDepositAccount;
import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import co.com.taller.ca.movements.model.ResponseBalanceDepositAccount;
import co.com.taller.ca.movements.gateway.AccountMovementsGateway;
import co.com.taller.ca.movements.model.BalancesDeposit;
import co.com.taller.ca.movements.model.DataBalanceDepositAccount;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RequiredArgsConstructor
public class DepositAccountMovementsUseCase {
    private final AccountMovementsGateway accountMovementsGateway;

    public Mono<ResponseBalanceDepositAccount> getAccountMovements(DataAccountTransactionRQ request) {
        Mono<BalancesDeposit> balancesDeposit = accountMovementsGateway.consultBalanceDeposit(request.getData().getAccount());
        Mono<AccountTransactions> movementDeposit = accountMovementsGateway.consultMovementDeposit(request);
        return Mono.zip(balancesDeposit, movementDeposit).map(r -> this.createResponse(r.getT2(), r.getT1()));
    }

    public ResponseBalanceDepositAccount createResponse(AccountTransactions accountTransactions, BalancesDeposit balancesDeposit){

        ResponseBalanceDepositAccount response = new ResponseBalanceDepositAccount();
        DataBalanceDepositAccount dataBalanceDepositAccount = new DataBalanceDepositAccount();
        BalanceDepositAccount balanceDepositAccount = new BalanceDepositAccount();
        balanceDepositAccount.setTransaction(accountTransactions.getTransaction());
        balanceDepositAccount.setCustomer(accountTransactions.getCustomer());
        balanceDepositAccount.setOffice(accountTransactions.getOffice());
        balanceDepositAccount.setFlagMoreRecords(accountTransactions.getFlagMoreRecords());
        balanceDepositAccount.setResponseSize(accountTransactions.getResponseSize());
        balanceDepositAccount.setRelatedTransferAccount(accountTransactions.getRelatedTransferAccount());
        balanceDepositAccount.setBalances(balancesDeposit);
        dataBalanceDepositAccount.setAccount(balanceDepositAccount);
        ArrayList<DataBalanceDepositAccount> list = new ArrayList<>();
        list.add(dataBalanceDepositAccount);
        response.setData(list);

        return response;
    }
}
