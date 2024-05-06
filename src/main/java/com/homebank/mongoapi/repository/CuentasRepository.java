package com.homebank.mongoapi.repository;

import com.homebank.mongoapi.model.CuentaDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentasRepository extends MongoRepository<CuentaDTO, String> {


    Long countById(String id);
}
