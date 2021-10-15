package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class FindAllMaterialUseCase implements Supplier<Flux<MaterialDTO>> {

    private final MaterialRepository materialRepository;
    private  final MaterialMapper materialMapper;

    @Autowired
    public FindAllMaterialUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public Flux<MaterialDTO> get() {
        return materialRepository.findAll().map(materialMapper.mapMaterialToDTO());
    }

}
