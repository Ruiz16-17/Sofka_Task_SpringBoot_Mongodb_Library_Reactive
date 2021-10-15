package com.Task_Mongodb_SpringBoot.library.router;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.useCase.FilterByThematicAreaUseCase;
import com.Task_Mongodb_SpringBoot.library.useCase.FilterByTypeMaterialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FilterByTypeMaterialRouter {

    @Bean
    public RouterFunction<ServerResponse> filterByTypeMaterial(FilterByTypeMaterialUseCase filterByTypeMaterialUseCase){
        return route(
                GET("/filterByTypeMaterial/{name}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(filterByTypeMaterialUseCase.apply(request.pathVariable("name")), MaterialDTO.class))

        );
    }

}
