package com.Task_Mongodb_SpringBoot.library.mapper;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

@Component
public class MaterialMapper {

    public Function<MaterialDTO, Material> mapperToMaterial(String id) {

        return updateData -> {
            var material = new Material();
            material.setId(id);
            material.setTypeMaterial(updateData.getTypeMaterial());
            material.setThematicArea(updateData.getThematicArea());
            material.setName(updateData.getName());
            material.setNumberCopyMaterial(updateData.getNumberCopyMaterial());
            material.setAvailable(updateData.isAvailable());
            material.setBorrowDateMaterial(updateData.getBorrowDateMaterial());
            return material;
        };

    }

    public Function<Material, MaterialDTO> mapMaterialToDTO() {
        return entity -> new MaterialDTO(
                entity.getId(),
                entity.getTypeMaterial(),
                entity.getThematicArea(),
                entity.getName(),
                entity.isAvailable(),
                entity.getNumberCopyMaterial(),
                entity.getBorrowDateMaterial()
        );
    }

}
