package lu.ing.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "firstanme", "lastname"})
public class Client {

    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
}

