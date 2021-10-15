package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UseCaseUpdateMaterial implements SaveMaterial{

    private final MaterialRepository materialRepository;
    private  final MaterialMapper materialMapper;

    public UseCaseUpdateMaterial(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }
    
    @Override
    public Mono<String> apply(MaterialDTO materialDTO) {
        Objects.requireNonNull(materialDTO.getId(), "Id is required");
        return materialRepository
                .save(materialMapper.mapperToMaterial((materialDTO.getId()))
                        .apply(materialDTO))
                .map(Material::getId);
    }
}
