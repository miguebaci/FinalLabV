package utn.edu.finalLabv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.edu.finalLabv.dto.HistoryResponseDTO;
import utn.edu.finalLabv.service.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class HistoryController {
    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/{country}")
    public List<HistoryResponseDTO> getCovidData(@PathVariable String country){
        return this.historyService.getCovidData(country);
    }
}
