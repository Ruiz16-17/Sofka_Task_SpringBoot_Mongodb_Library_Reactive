package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.useCase.UpdateMaterialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateMaterialRouter {

    @Bean
    public RouterFunction<ServerResponse> updateMaterial(UpdateMaterialUseCase updateMaterialUseCase){
        return route(PUT("/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(MaterialDTO.class)
                        .flatMap(materialDTO -> updateMaterialUseCase.apply(materialDTO))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(result)));
    }
}
