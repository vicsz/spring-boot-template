package com.sample.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SampleDatabaseObjectRepository extends JpaRepository<SampleDatabaseObject, Integer> {

    //Add endpoint to search on salutation -- i.e. http://localhost:8080/sampleDatabaseObjects/search/findBySalutation?name=Greeting
    List<SampleDatabaseObject> findBySalutation(@Param("name") String salutation);
}
