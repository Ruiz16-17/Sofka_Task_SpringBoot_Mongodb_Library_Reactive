package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveMaterial {
    public Mono<String> apply(MaterialDTO materialDTO);
}
