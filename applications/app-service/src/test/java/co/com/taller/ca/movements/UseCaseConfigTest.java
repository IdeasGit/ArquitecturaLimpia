package co.com.taller.ca.movements;

import co.com.taller.ca.movements.gateway.AccountMovementsGateway;
import co.com.taller.ca.movements.usecase.DepositAccountMovementsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
public class UseCaseConfigTest {

    private UseCaseConfig useCaseConfig;

    @Mock
    AccountMovementsGateway accountMovementsGateway;
    @Mock
    DepositAccountMovementsUseCase depositAccountMovementsUseCase;

    @BeforeEach
    public void setUp() {
        useCaseConfig = new UseCaseConfig();
    }

    @Test
    public void depositAccountMovementsUseCaseTest() {
        assertNotNull(useCaseConfig.depositAccountMovementsUseCase(accountMovementsGateway));
    }
}