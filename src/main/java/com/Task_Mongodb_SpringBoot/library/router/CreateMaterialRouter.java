package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.useCase.CreateMaterialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateMaterialRouter {
    @Bean
    public RouterFunction<ServerResponse> createMaterial(CreateMaterialUseCase createMaterialUseCase){
        return route(POST("/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(MaterialDTO.class)
                        .flatMap(questionDTO -> createMaterialUseCase.apply(questionDTO))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(result)));
    }

}
