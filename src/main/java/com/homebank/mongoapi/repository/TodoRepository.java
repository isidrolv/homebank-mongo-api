package com.homebank.mongoapi.repository;

import com.homebank.mongoapi.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository  extends MongoRepository<TodoDTO, String> {
}
