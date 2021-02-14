package co.com.taller.ca.movements.model;

import lombok.Data;

@Data
public class TransactionRs {
    private String id;
    private String postedDate;
    private String description;
    private String amount;
    private String type;
    private String reference1;
    private String reference2;
    private String reference3;
    private String checkNumber;
}
