package com.erkan.repository;

import com.erkan.model.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface PersonRepo extends ElasticsearchRepository<Person,String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"firstName\": \"?0\"}}]}}")
    List<Person> getByCustomQuery ( String search );
}
