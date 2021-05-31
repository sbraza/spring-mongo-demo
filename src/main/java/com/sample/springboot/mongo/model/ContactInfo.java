package com.sample.springboot.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author syedbilalraza
 * @date 20/05/2021
 */
@Data
@Document
public class ContactInfo {

    private String phoneNo;

    private String mobileNo;

    private String emailAddress;
}
