package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Validated
public class ReturnMaterialUseCase implements SaveMaterial {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public ReturnMaterialUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    public Mono<String> returnMaterial(String id) {
        Objects.requireNonNull(id, "Id is required");
        Mono<MaterialDTO> materialDTOMono = materialRepository.findById(id).map(materialMapper.mapMaterialToDTO());

        return materialDTOMono.flatMap(materialDTO ->
        {
            if (!materialDTO.isAvailable()) {
                materialDTO.setBorrowDateMaterial(null);
                materialDTO.setAvailable(true);

                return apply(materialDTO);
            }

            return Mono.just("This material is not borrowed.");
        });

    }

    @Override
    public Mono<String> apply(MaterialDTO materialDTO) {

        return materialRepository
                .save(materialMapper.mapperToMaterial((materialDTO.getId()))
                .apply(materialDTO))
                .then(Mono.just("Has been returned."));
    }

}
