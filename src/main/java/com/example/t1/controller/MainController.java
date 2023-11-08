package com.example.t1.controller;

import com.example.t1.dto.StringRequest;
import com.example.t1.dto.StringResponse;
import com.example.t1.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController implements IMainController {
    private final MainService mainService;

    @Override
    public StringResponse calculate(StringRequest stringRequest) {
        return new StringResponse(mainService.calculate(stringRequest.getOutputString()));
    }
}

