package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class FilterByTypeMaterialUseCase implements Function<String, Flux<MaterialDTO>> {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public FilterByTypeMaterialUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public Flux<MaterialDTO> apply(String type) {
        return materialRepository.findAll()
                .map(materialMapper.mapMaterialToDTO())
                .filter(materialDTO -> type.equalsIgnoreCase(materialDTO.getTypeMaterial()));
    }
}
