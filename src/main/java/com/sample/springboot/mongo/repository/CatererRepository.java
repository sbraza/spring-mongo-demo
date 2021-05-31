package com.sample.springboot.mongo.repository;

import com.sample.springboot.mongo.model.Caterer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@RestResource
@Validated
public interface CatererRepository extends MongoRepository<Caterer,String> {


    @Cacheable(value = "caterers")
    public Page<Caterer> findByName(@Param("name") String name, Pageable p);

    //@RestResource(exported = false)
    @Cacheable(value = "caterers")
    public Page<Caterer> findByLocationCityName(@Param("name") String name, Pageable p);
}
