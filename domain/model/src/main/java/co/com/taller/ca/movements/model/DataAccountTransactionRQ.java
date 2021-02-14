package co.com.taller.ca.movements.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DataAccountTransactionRQ {
    private AccountTransactionRQ data;
}
