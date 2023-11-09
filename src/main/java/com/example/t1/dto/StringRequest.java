package com.example.t1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StringRequest {
    @ApiModelProperty(name = "String", value = "total line", notes = "final result")
    @Pattern(regexp = "[a-zA-Z0-9]")
    private String InputString;
}
