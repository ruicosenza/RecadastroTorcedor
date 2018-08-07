package hello;

import com.fasterxml.jackson.databind.util.JSONPObject;
import entity.Response;
import entity.Socio;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    public JSONObject testando(){
        /*RestTemplate restTemplate = new RestTemplate();
        Socio forObject = restTemplate.getForObject("http://localhost:8080/teste", Socio.class);

        System.out.println(forObject);*/
        JSONObject jsonObj = new JSONObject();
        BufferedReader br;
        try {
            URL url = new URL("http://localhost:8080/teste");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonObj = new JSONObject(output.replace("[", "").replace("]", ""));
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}