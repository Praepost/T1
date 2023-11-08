package com.example.t1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StringRequest {
    @ApiModelProperty(name = "String", value = "итоговая строка", notes = "итоговый результат")
    @NonNull
    private String outputString;
}
