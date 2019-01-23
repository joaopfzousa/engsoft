package ufp.pt.engsoft.ws2.Controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/clinica")
public class ClinicaController {

    Map<String, String> map = new HashMap<>();


    private void listClinicas() {
        map.put("clinica1", "http://localhost:8080/clinica");
    }

    private void mapaClinicas(){
        map.put("clinica1", "https://www.google.com/maps/place/Centro+Hospitalar+de+Entre+Douro+e+Vouga/@40.9302125,-8.5474706,15z/data=!4m5!3m4!1s0x0:0x6a7466d3f7b1a95a!8m2!3d40.9302125!4d-8.5474706");
    }


    @GetMapping(value = "/{nomeClinica}")
    public @ResponseBody Iterable getAllConsultas(@PathVariable("nomeClinica") String nomeClinica) {
        listClinicas();
        String path = map.get(nomeClinica);
        path=path+"consultaPeim/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/{nomeClinica}/mapa", method = RequestMethod.GET)
    public ModelAndView method(@PathVariable("nomeClinica") String nomeClinica) {
        mapaClinicas();
        String path= map.get(nomeClinica);
        return new ModelAndView("redirect:" + path);
    }




    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
