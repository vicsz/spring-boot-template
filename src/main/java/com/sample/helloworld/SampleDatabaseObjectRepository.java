package com.sample.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SampleDatabaseObjectRepository extends JpaRepository<SampleDatabaseObject, Integer> {}
