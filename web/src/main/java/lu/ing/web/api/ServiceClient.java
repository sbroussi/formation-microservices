package lu.ing.web.api;

import lu.ing.web.model.ClientDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * This class defines the 'client' to call the server API.
 */
@FeignClient(name = "client", url = "${app.services.clients.url}")
public interface ServiceClient {

    @GetMapping("/api/clients")
    List<ClientDto> getClients();
}
