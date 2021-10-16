package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class AvailableMaterialUseCaseTest {

    MaterialRepository materialRepository;
    AvailableMaterialUseCase availableMaterialUseCase;

    @BeforeEach
    public void setup(){
        MaterialMapper materialMapper = new MaterialMapper();
        materialRepository = mock(MaterialRepository.class);
        availableMaterialUseCase = new AvailableMaterialUseCase(materialRepository, materialMapper);
    }

    @Test
    void notAvailableMaterialTest(){
        var material =  new Material();
        material.setId("xxxx-xxxx");
        material.setThematicArea("Tech");
        material.setTypeMaterial("Book");
        material.setName("¿Que es java?");
        material.setAvailable(false);
        material.setBorrowDateMaterial(LocalDate.now());
        when(materialRepository.findAll()).thenReturn(Flux.just(material ));

        StepVerifier.create(availableMaterialUseCase.apply(material.getName()))
                .expectNextMatches(result -> {
                    assert result.equals("Not available. Was borrowed on " + LocalDate.now());
                    return true;
                })
                .verifyComplete();

    }

    @Test
    void availableMaterialTest(){
        var material =  new Material();
        material.setId("xxxx-xxxx");
        material.setThematicArea("Tech");
        material.setTypeMaterial("Book");
        material.setName("¿Que es java?");
        material.setAvailable(true);
        when(materialRepository.findAll()).thenReturn(Flux.just(material ));

        StepVerifier.create(availableMaterialUseCase.apply(material.getName()))
                .expectNextMatches(result -> {
                    assert result.equals("Available");
                    return true;
                })
                .verifyComplete();

        verify(materialRepository).findAll();
    }
}