package lu.ing.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lu.ing.graphql.service.Client;
import lu.ing.graphql.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientResolver implements GraphQLQueryResolver {

    @Autowired
    ClientService clientService;

    public List<Client> clients() {
        return clientService.getClients();
    }

}
