package com.Task_Mongodb_SpringBoot.library.repository;

import com.Task_Mongodb_SpringBoot.library.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MaterialRepository extends ReactiveMongoRepository<Material, String> {
}
