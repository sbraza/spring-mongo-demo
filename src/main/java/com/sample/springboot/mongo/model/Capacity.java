package com.sample.springboot.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author syedbilalraza
 * @date 20/05/2021
 */
@Data
@Document
public class Capacity {

    private Integer minCapacity;
    private Integer maxCapacity;
}
