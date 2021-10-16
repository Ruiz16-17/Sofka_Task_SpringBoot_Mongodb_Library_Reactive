package com.Task_Mongodb_SpringBoot.library.useCase;

import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class FindAllMaterialUseCaseTest {


    MaterialRepository materialRepository;
    FindAllMaterialUseCase listUseCase;


    @BeforeEach
    public void setup(){
        MaterialMapper materialMapper = new MaterialMapper();
        materialRepository = mock(MaterialRepository.class);
        listUseCase = new FindAllMaterialUseCase(materialRepository, materialMapper);
    }

    @Test
    void getValidationTest(){
        var material =  new Material();
        material.setId("xxxx-xxxx");
        material.setThematicArea("Tech");
        material.setTypeMaterial("Book");
        material.setName("¿Que es java?");
        when(materialRepository.findAll()).thenReturn(Flux.just(material ));

        StepVerifier.create(listUseCase.get())
                .expectNextMatches(materialDTO -> {
                    assert materialDTO.getId().equals("xxxx-xxxx");
                    assert materialDTO.getTypeMaterial().equals("Book");
                    assert materialDTO.getThematicArea().equals("Tech");
                    assert materialDTO.getName().equals("¿Que es java?");
                    return true;
                })
                .verifyComplete();

        verify(materialRepository).findAll();
    }

}