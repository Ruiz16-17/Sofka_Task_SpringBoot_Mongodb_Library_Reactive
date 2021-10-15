package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.useCase.ReturnMaterialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ReturneMaterialRouter {

    @Bean
    public RouterFunction<ServerResponse> returnMaterial(ReturnMaterialUseCase returnMaterialUseCase) {
        return route(PUT("/returnMaterial/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(MaterialDTO.class)
                        .flatMap(materialDTO -> returnMaterialUseCase.returnMaterial(request.pathVariable("id")))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(result))
        );

    }
}
