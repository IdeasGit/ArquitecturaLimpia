package co.com.taller.ca.movements.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private String startDate;
    private String endDate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String type;
    private String checkNumber;
    private String group;
    private String description;
}
