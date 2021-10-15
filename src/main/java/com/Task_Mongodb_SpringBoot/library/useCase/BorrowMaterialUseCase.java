package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class BorrowMaterialUseCase implements SaveMaterial {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public BorrowMaterialUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    public Mono<String> borrowMaterial(String id) {
        Objects.requireNonNull(id, "Id is required");
        Mono<MaterialDTO> materialDTOMono = materialRepository.findById(id).map(materialMapper.mapMaterialToDTO());

        return materialDTOMono.flatMap(materialDTO ->
        {
            if (materialDTO.isAvailable()) {
                materialDTO.setBorrowDateMaterial(LocalDate.now());
                materialDTO.setAvailable(false);

                return apply(materialDTO);
            }

            return Mono.just("Not Available.");
        });

    }

    @Override
    public Mono<String> apply(MaterialDTO materialDTO) {

        return materialRepository
                .save(materialMapper.mapperToMaterial((materialDTO.getId()))
                .apply(materialDTO))
                .then(Mono.just("Available.Has been borrowed."));
    }

}
