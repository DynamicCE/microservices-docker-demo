package com.erkan.dto;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;


@Data
public
class PersonDto {
    private Long id;

    private String firstName;

    private String lastName;

    Set<String> addresses = new HashSet<> ( );
}
