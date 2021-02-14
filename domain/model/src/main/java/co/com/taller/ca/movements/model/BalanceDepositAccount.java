package co.com.taller.ca.movements.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceDepositAccount {
    private BalancesDeposit balances;
    private List<TransactionRs> transaction;
    private Office office;
    private Account relatedTransferAccount;
    private Customer customer;
    private Integer responseSize;
    private Boolean flagMoreRecords;
}