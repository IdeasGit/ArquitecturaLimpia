package co.com.taller.ca.movements.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AccountTransactions {
    private List<TransactionRs> transaction;
    private Office office;
    private Account relatedTransferAccount;
    private Customer customer;
    @JsonProperty(value = "_responseSize")
    private Integer responseSize;
    @JsonProperty(value = "_flagMoreRecords")
    private Boolean flagMoreRecords;
}