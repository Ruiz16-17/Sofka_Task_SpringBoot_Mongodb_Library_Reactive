package com.Task_Mongodb_SpringBoot.library.service;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class MaterialService  {
/*

    public List<MaterialDTO> findAllMaterialByThematicArea(String thematicArea) {
        Query query = new Query()
                .addCriteria(Criteria.where("thematicArea").regex(thematicArea));
        List<Material> materialList = mongoTemplate.find(query, Material.class);

        return materialMapper.fromCollectionList(materialList);
    }

    public List<MaterialDTO> findAllMaterialByTypeMaterial(String typeMaterial) {
        Query query = new Query()
                .addCriteria(Criteria.where("typeMaterial").regex(typeMaterial));
        List<Material> materialList = mongoTemplate.find(query, Material.class);

        return materialMapper.fromCollectionList(materialList);
    }

    public String borrowMaterial(String id) throws Exception {

        MaterialDTO materialDTO = findById(id);

        if (materialDTO.isAvailable()) {

            materialDTO.setAvailable(false);
            materialDTO.setBorrowDateMaterial(LocalDate.now());
            update(materialDTO);
            return "Has been borrowed.";
        }

        return "Not Available.";
    }

    public String returnMaterial(String id) {

        MaterialDTO materialDTO = findById(id);

        if (!materialDTO.isAvailable()) {

            materialDTO.setAvailable(true);
            materialDTO.setBorrowDateMaterial(null);
            update(materialDTO);
            return "Has been returned.";
        }

        return "This material is not borrowed.";

    }

*/
}
