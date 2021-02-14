package co.com.taller.ca.movements.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalancesDeposit {

	private BigDecimal available;
    private BigDecimal effective;
    private BigDecimal current;
    private BigDecimal availableOverdraftBalance;
	private BigDecimal overdraftValue;
	private BigDecimal availableOverdraftQuota;
	private BigDecimal clearing;
	private BigDecimal receivable;
	private BigDecimal blocked;
	private BigDecimal clearingStartDay;
    private BigDecimal availableStartDay;
    private BigDecimal effectiveStartDay;
	private BigDecimal currentStartDay;
	private BigDecimal pockets;
	private BigDecimal remittanceQuota;
	private BigDecimal agreedRemittanceQuota;
	private BigDecimal remittanceQuotaUsage;
	private BigDecimal normalInterest;
	private BigDecimal suspensionInterest;

	
}
