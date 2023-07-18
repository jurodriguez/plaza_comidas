package com.example.plaza_comidas.infrastructure.output.mongodb.repository;

import com.example.plaza_comidas.infrastructure.output.mongodb.entity.TrazabilidadEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITrazabilidadRepository extends MongoRepository<TrazabilidadEntity, String> {
}
