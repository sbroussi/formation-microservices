package lu.ing.graphql.service;

import lombok.Data;

@Data
public class Client {


    private Long id;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
}
