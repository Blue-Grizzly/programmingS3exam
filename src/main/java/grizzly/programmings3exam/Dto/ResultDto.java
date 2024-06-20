package grizzly.programmings3exam.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    private int id;
    private String resultType;
    private String resultValue;
    private String date;
    private int athleteId;
    private int disciplineId;
}
