package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.useCase.BorrowMaterialUseCase;
import com.Task_Mongodb_SpringBoot.library.useCase.FindByIdMaterialUseCase;
import com.Task_Mongodb_SpringBoot.library.useCase.UpdateMaterialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BorrowMaterialRouter {

    @Bean
    public RouterFunction<ServerResponse> borrowMaterial(BorrowMaterialUseCase borrowMaterialUseCase) {
        return route(PUT("/borrowMaterial/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(MaterialDTO.class)
                        .flatMap(materialDTO -> borrowMaterialUseCase.borrowMaterial(request.pathVariable("id")))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(result))
        );

    }
}
