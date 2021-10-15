package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.useCase.DeleteMaterialByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteMaterialByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteMaterialById(DeleteMaterialByIdUseCase deleteMaterialByIdUseCase) {

        return route(
                DELETE("/delete/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteMaterialByIdUseCase.apply(request.pathVariable("id")), Void.class))
                        .onErrorResume((error) -> ServerResponse.badRequest().build())
        );
    }
}
