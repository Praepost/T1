package com.example.t1.controller;

import com.example.t1.dto.StringRequest;
import com.example.t1.dto.StringResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMainController {
    @PostMapping("/calculate")
    @ApiOperation(value = "calculate line")
    @ApiResponses({
            @ApiResponse(code = 200, response = StringResponse.class, message =
                            "- calculated. \n"),
            @ApiResponse(code = 400, message =
                    "Error codes: general")

    })
    public StringResponse calculate(@RequestBody StringRequest stringRequest);
}
