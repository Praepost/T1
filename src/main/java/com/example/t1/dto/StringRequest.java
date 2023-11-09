package com.example.t1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StringRequest {
    @ApiModelProperty(name = "String", value = "total line", notes = "final result")
    @Pattern(regexp = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$")
    private String InputString;
}
