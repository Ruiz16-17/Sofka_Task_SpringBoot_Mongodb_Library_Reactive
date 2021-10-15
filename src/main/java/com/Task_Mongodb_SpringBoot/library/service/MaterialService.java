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
