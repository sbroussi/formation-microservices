package lu.ing.api;

import lombok.extern.slf4j.Slf4j;
import lu.ing.ClientDBRepository;
import lu.ing.config.AppConfig;
import lu.ing.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
@Slf4j
public class ClientsResource {

    @Autowired
    private ClientDBRepository clientDBRepository;

    @Autowired
    private AppConfig appConfig;

    @GetMapping
    public List<Client> getClients() {

        log.info("call getClients");
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
        log.debug("getClients: return {}", list);
        return list;
    }

    @GetMapping(value = "/{id}/picture", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public Resource getPicture(@PathVariable("id") Long id) {
        String folder = appConfig.getPictures().getDirectory();
        FileSystemResource picture = new FileSystemResource(folder + "/" + id + ".png");
        if (!picture.exists()) {
            picture = new FileSystemResource(folder + "/" + id + ".jpg");
        }
        if (!picture.exists()) {
            throw new RuntimeException("no picture");
        }
        return picture;
    }
}
