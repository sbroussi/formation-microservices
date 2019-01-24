package lu.ing.api;

import lu.ing.ClientDBRepository;
import lu.ing.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientsResource {

    @Autowired
    private ClientDBRepository clientDBRepository;

    @GetMapping
    public List<Client> getClients() {
        /*
        List<Client> list = new ArrayList<>();

        list.add(Client.builder()
                .id(123l)
                .firstname("John")
                .lastname("Doe")
                .build());
        list.add(Client.builder()
                .id(456l)
                .firstname("Paul")
                .lastname("Smith")
                .build());

        */
        List<Client> list = clientDBRepository.findAll();
        return list;
    }
}
