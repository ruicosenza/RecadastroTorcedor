package hello;

import entity.Socio;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*@RequestMapping(value = "/greeting", produces = (MediaType.APPLICATION_JSON_VALUE) )*/
    @GetMapping(path = "/greeting", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/greeting1", produces = (MediaType.APPLICATION_JSON_VALUE))
    public Greeting greeting1(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping( value = "/", produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<Socio[]> testando(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Socio[]> forEntity = restTemplate.getForEntity("http://localhost:8080/getSocio", Socio[].class);

        Socio[] socios = forEntity.getBody();

        for (int i = 0; i < socios.length; i++) {
            System.out.println(socios[i].getNomeSocio());
        }

        return forEntity;
    }
}