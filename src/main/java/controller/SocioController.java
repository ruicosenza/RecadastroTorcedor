package controller;

import models.Socio;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SocioController {

    @RequestMapping( value = "/getSocio", method = RequestMethod.POST)
    public ResponseEntity<Socio[]> getSocio(@RequestBody Socio socio){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Socio> entity = new HttpEntity<>(socio, headers);

        return restTemplate.postForEntity("http://localhost:8090/getSocio", entity, Socio[].class);
    }
}