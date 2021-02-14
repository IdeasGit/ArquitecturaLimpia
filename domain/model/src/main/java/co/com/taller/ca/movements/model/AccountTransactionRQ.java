package co.com.taller.ca.movements.model;

import lombok.Data;

@Data
public class AccountTransactionRQ {
    private Pagination pagination;
    private Account account;
    private Transaction transaction;
    private Office office;
}