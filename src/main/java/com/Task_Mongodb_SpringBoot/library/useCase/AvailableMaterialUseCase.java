package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Validated
public class AvailableMaterialUseCase implements Function<String, Mono<String>> {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public AvailableMaterialUseCase(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    public Mono<String> getLastBorrowDateByName(String name){

        return materialRepository.findAll()
                .map(materialMapper.mapMaterialToDTO())
                .filter(materialDTO -> name.equalsIgnoreCase(materialDTO.getName()))
                .collectList()
                .flatMap(materialDTOList -> Mono.just("Not avalable. Was borrowed on "+materialDTOList
                        .stream()
                        .map(MaterialDTO::getBorrowDateMaterial)
                        .max(LocalDate::compareTo)
                        .get()));

    }

    @Override
    public Mono<String> apply(String name) {

        return materialRepository.findAll()
                .map(materialMapper.mapMaterialToDTO())
                .filter(materialDTO -> name.equalsIgnoreCase(materialDTO.getName()) && materialDTO.isAvailable())
                .collectList()
                .flatMap(materialDTOList -> {
                    if (materialDTOList.isEmpty()) {

                        return getLastBorrowDateByName(name);
                    }

                    return Mono.just("Available");
                });
    }

}
