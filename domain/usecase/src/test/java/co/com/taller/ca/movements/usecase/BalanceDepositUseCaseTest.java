package co.com.taller.ca.movements.usecase;

public class BalanceDepositUseCaseTest {
/*
	@Mock
	BalanceDepositGateway balanceDepositGateway;
	@Mock
	LogCommonUseCase logCommonUseCase;

	private BalanceHeader depositHeaders;
	private Account account;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		depositHeaders = getDepositHeadersMock();
		account = new Account();
		account.setNumber("40601659843");
		account.setType("CUENTA_DE_AHORRO");

		Mockito.when(logCommonUseCase.writeRequestToQueue(depositHeaders,
				BalancesUtilities.COD_TXN_CONSULT_BALANCE_DETAIL_DEPOSIT, account)).thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(logCommonUseCase.writeResponseToQueue(depositHeaders,
				BalancesUtilities.COD_TXN_CONSULT_BALANCE_DETAIL_DEPOSIT, account)).thenReturn(Mono.just(Boolean.TRUE));
	}

	@Test
	public void getBalanceDeposit() {
		BalanceDepositRQ data = new BalanceDepositRQ();
		BalanceDepositDataRQ balanceDepositDataRQ = new BalanceDepositDataRQ();
		data.setAccount(account);
		List<BalanceDepositRQ> balanceDepositRQ = new ArrayList<>();
		balanceDepositRQ.add(data);
		balanceDepositDataRQ.setData(balanceDepositRQ);
		BalanceDepositUseCase balanceDepositUseCase = new BalanceDepositUseCase(balanceDepositGateway,
				logCommonUseCase);

		when(balanceDepositGateway.consultBalanceDeposit(depositHeaders.getTransactionTracker(), balanceDepositDataRQ))
				.thenReturn(Mono.just(new ArrayList<>()));

		Mono<ResponseBalanceDepositAccount> responseBalanceDepositAccountMono = balanceDepositUseCase
				.getBalanceDeposit(depositHeaders, balanceDepositDataRQ);
		StepVerifier.create(responseBalanceDepositAccountMono).expectSubscription().thenConsumeWhile(x -> true)
				.verifyComplete();
	}

	private BalanceHeader getDepositHeadersMock() {
		BalanceHeader headers = new BalanceHeader();
		headers.setSessionTracker("79f87d34-e101-436a-8ef0-f76689c8428d");
		headers.setTransactionTracker("79f87d34-e101-436a-8ef0-f76689c8428d");
		headers.setChannel("APP");
		headers.setDate("2020/10/05");
		headers.setClientType(DocumentTypeEnum.CC.name());
		headers.setClientID("987654321");
		headers.setDateTime("19:05:56");
		headers.setAuthorization("aa3452342131326572144534534hjbasdasek234243");
		return headers;
	}

 */

}
