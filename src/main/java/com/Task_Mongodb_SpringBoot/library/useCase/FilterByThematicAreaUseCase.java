package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Validated
public class FilterByThematicAreaUseCase implements Function<String, Flux<MaterialDTO>> {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public FilterByThematicAreaUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public Flux<MaterialDTO> apply(String thematic) {
        return materialRepository.findAll()
                .map(materialMapper.mapMaterialToDTO())
                .filter(materialDTO -> thematic.equalsIgnoreCase(materialDTO.getThematicArea()));
    }
}
