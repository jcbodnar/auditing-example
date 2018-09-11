package com.example.demo.core.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ResourceRepository extends CrudRepository<ResourceEntity, UUID> {

}