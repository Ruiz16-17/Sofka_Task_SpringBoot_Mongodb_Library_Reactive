package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class DeleteMaterialByIdUseCase implements Function<String, Mono<Void>> {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public DeleteMaterialByIdUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public Mono<Void> apply(String id) {

        Objects.requireNonNull(id, "Id is required");
        return materialRepository.deleteById(id);
    }

}
