package utn.edu.finalLabv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utn.edu.finalLabv.dto.HistoryResponseDTO;
import utn.edu.finalLabv.models.History;
import utn.edu.finalLabv.models.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    public HistoryService() {
    }

    public List<HistoryResponseDTO> getCovidData(String country){

        RestTemplate restTemplate =new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();

        headers.set("x-rapidapi-host", "covid-193.p.rapidapi.com");
        headers.set("x-rapidapi-key", "4ec601f266msh743454b3ef6bcbdp15f77fjsn7ba7f1a4d81f");

        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<Response> response = restTemplate.exchange("https://covid-193.p.rapidapi.com/history?country="+country+"&day=2020-06-02", HttpMethod.GET,entity,new ParameterizedTypeReference<Response>(){});

        List<HistoryResponseDTO> finalResponse = new ArrayList<HistoryResponseDTO>();

        for (History res: response.getBody().getResponse()) {
            finalResponse.add(new HistoryResponseDTO(res.getContinent(),res.getCases().getTotal(), res.getTime()));
        }

        return finalResponse;
    }
}
