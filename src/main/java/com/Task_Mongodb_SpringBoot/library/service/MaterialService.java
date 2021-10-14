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
    @Autowired
    private MaterialRepository materialRepository;

    private MaterialMapper materialMapper = new MaterialMapper();
    private final MongoTemplate mongoTemplate;

    public MaterialService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<MaterialDTO> findAll() {
        List<Material> materialList = materialRepository.findAll();
        return materialMapper.fromCollectionList(materialList);
    }

    @Override
    public MaterialDTO findById(String id){

        Material material = materialRepository.findById(id)
                .orElseThrow(
                () ->  new RuntimeException("Material not found")

        );

        return materialMapper.fromCollection(material);
    }

    @Override
    public MaterialDTO save(MaterialDTO materialDTO) {
        materialDTO.setAvailable(true);
        Material material = materialMapper.fromDTO(materialDTO);
        return materialMapper.fromCollection(materialRepository.save(material));
    }

    @Override
    public MaterialDTO update(MaterialDTO materialDTO) {
        Material material = materialMapper.fromDTO(materialDTO);
        materialRepository.findById(material.getId()).orElseThrow(() -> new RuntimeException("Material not found"));
        return materialMapper.fromCollection(materialRepository.save(material));
    }

    @Override
    public void delete(String id) {
        materialRepository.deleteById(id);
    }

    private List<MaterialDTO> findAllMaterialByName(String name) {
        Query query = new Query()
                .addCriteria(Criteria.where("name").regex(name));
        List<Material> materialList = mongoTemplate.find(query, Material.class);

        return materialMapper.fromCollectionList(materialList);
    }

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

    private List<MaterialDTO> filterAvailableByName(List<MaterialDTO> materialDTOList) {
        ;
        List<MaterialDTO> materialDTOListAvailable = materialDTOList
                .stream()
                .filter((materialDTO -> materialDTO.isAvailable())).collect(Collectors.toList());

        return materialDTOListAvailable;
    }

    private LocalDate getLastDateNotAvailable(List<MaterialDTO> materialDTOList) {

        LocalDate localDate = materialDTOList.stream().map(materialDTO -> materialDTO.getBorrowDateMaterial()).max(LocalDate::compareTo).get();
        return localDate;
    }

    public String availableMaterial(String name) {
        List<MaterialDTO> materialDTOList = findAllMaterialByName(name);
        List<MaterialDTO> materialDTOListAvailable = filterAvailableByName(materialDTOList);
        if (materialDTOListAvailable.size() > 0) {
            return "Available.";
        }

        return "Not Available. \n" +
                "The last copy was borrowed on " + getLastDateNotAvailable(materialDTOList) + ".";
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
