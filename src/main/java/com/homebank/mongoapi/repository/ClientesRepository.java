package com.homebank.mongoapi.repository;

import com.homebank.mongoapi.model.ClienteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientesRepository extends MongoRepository<ClienteDTO, String> {
}
