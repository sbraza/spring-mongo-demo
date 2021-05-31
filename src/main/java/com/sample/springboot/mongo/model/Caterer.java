package com.sample.springboot.mongo.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author syedbilalraza
 * @date 20/05/2021
 */

@Document(collection="caterer")

@Data
@Valid
public class Caterer {


    @Id
    private String id;


    private String name;

    @Valid
    private Location location;

    private Capacity capacity;

    private ContactInfo contactInfo;
}
