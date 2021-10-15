package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class UseCaseFindByIdMaterial implements Function<String, Mono<MaterialDTO>> {
    private final MaterialRepository materialRepository;
    private  final MaterialMapper materialMapper;

    @Autowired
    public UseCaseFindByIdMaterial(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public Mono<MaterialDTO> apply(String id) {

        Objects.requireNonNull(id, "Id is required");

        return materialRepository.findById(id)
                .map(materialMapper.mapMaterialToDTO());
    }

}
