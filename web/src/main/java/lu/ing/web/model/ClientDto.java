package lu.ing.web.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "firstanme", "lastname"})
public class ClientDto {

    private Long id;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
}

