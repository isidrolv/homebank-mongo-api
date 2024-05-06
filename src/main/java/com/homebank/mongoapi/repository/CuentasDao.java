package com.homebank.mongoapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class CuentasDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CuentasDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Double sumSaldoByClienteId(String clienteId) {

        Aggregation aggregation = newAggregation(
                match(Criteria.where("clienteid").is(clienteId)),
                group("clienteId")
                        .sum("saldoActual").as("total")
        );

        AggregationResults<Double> resultado = mongoTemplate
                .aggregate(aggregation, "cuentas", Double.class);
        mongoTemplate.aggregate(aggregation, "cuentas", Double.class);
        return resultado.getUniqueMappedResult();
    }

}
