package co.com.taller.ca.movements;

import co.com.taller.ca.movements.gateway.AccountMovementsGateway;
import co.com.taller.ca.movements.usecase.DepositAccountMovementsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public DepositAccountMovementsUseCase depositAccountMovementsUseCase(AccountMovementsGateway accountMovementsGateway){
        return new DepositAccountMovementsUseCase(accountMovementsGateway);
    }
}
