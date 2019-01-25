package lu.ing.graphql.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "client", url = "${app.services.clients.url}")
@FeignClient(name = "${app.services.clients.name}")
public interface ClientService {

    @GetMapping("/api/clients")
    List<Client> getClients();

}
