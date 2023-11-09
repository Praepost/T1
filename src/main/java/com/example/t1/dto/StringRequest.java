package com.example.t1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StringRequest {
    @ApiModelProperty(name = "String", value = "total line", notes = "final result")
    @NonNull
    private String InputString;
}
