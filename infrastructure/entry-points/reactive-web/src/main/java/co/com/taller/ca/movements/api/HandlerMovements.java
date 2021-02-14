package co.com.taller.ca.movements.api;

import co.com.taller.ca.movements.model.DataAccountTransactionRQ;
import co.com.taller.ca.movements.model.ResponseBalanceDepositAccount;
import co.com.taller.ca.movements.usecase.DepositAccountMovementsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@AllArgsConstructor
public class HandlerMovements {


    private final DepositAccountMovementsUseCase depositAccountMovementsUseCase;

	public Mono<ServerResponse> consultDepositMovements(ServerRequest request) {

	    return request.bodyToMono(DataAccountTransactionRQ.class)
                .flatMap(dataBody -> depositAccountMovementsUseCase.getAccountMovements(dataBody))
                .flatMap(r -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(r), ResponseBalanceDepositAccount.class));
	}
}
