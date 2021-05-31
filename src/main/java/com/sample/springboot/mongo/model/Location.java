package com.sample.springboot.mongo.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author syedbilalraza
 * @date 20/05/2021
 */
@Data
@Document
public class Location {



  //  @Pattern(message = "Invalid email id", regexp = "^[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}$")
    private String cityName;

    @NotNull
    private String  streetNameAndNumber;

    private String postalCode;

}
