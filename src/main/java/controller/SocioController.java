package controller;

import entity.Socio;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SocioController {

    @RequestMapping( value = "/getSocio", produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<Socio[]> getSocio(@RequestParam(value="nome") String nome, @RequestParam(value="cpf") String cpf, @RequestParam(value="matricula") String matricula){
        RestTemplate restTemplate = new RestTemplate();

        String params = "nome=" + nome + "&cpf=" + cpf + "&matricula=" + matricula;

        ResponseEntity<Socio[]> forEntity = restTemplate.getForEntity("http://localhost:8080/getSocio?" + params, Socio[].class);

        return forEntity;
    }
}