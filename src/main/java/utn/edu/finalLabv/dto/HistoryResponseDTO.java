package utn.edu.finalLabv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryResponseDTO {
    private String continent;
    private int total;
    private String time;

}
