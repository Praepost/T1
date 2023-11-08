package com.example.t1.service;

import com.example.t1.dto.StringResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class MainService {
    public String calculate(String line) {

        InputStream stream = new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8));

        Map<Character, Integer> input = new HashMap<>();
        String output = "";
        AtomicReference<StringBuffer> result = new AtomicReference<>(new StringBuffer());

        int c = -1;
        while (true) {
            try {
                if (!((c = stream.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!input.containsKey((char) c)) {
                input.put((char) c, 1);
            } else {
                int number = input.get((char) c);
                input.put((char) c, number + 1);
            }
        }

        output = input.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).map(entry -> "\"" + entry.getKey() + "\"" + ": " + entry.getValue())
                .collect(Collectors.joining(", "));

        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return output;
    }
}