package com.erkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import java.util.Date;

@Document ( indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class Person {

    @Id
    private String id;

    @Field(name="firstName")
    private String firstName;

    @Field(name="lastName")
    private String lastName;

    @Field(name="address")
    private String address;

    @Field(name="birthDay")
    private Date birthDay;
}
