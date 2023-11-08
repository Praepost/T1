package com.example.t1;

import com.example.t1.dto.StringRequest;
import com.example.t1.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class T1ApplicationTests {

	@Autowired
	private MainService mainService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Test
	void FirstTest() throws Exception {
		StringRequest  stringRequest= new StringRequest("aaaaabcccc");
		mockMvc.perform(post("/calculate")
				.content(objectMapper.writeValueAsString(stringRequest.getOutputString()))
				.contentType(MediaType.APPLICATION_JSON)
		);

		assertEquals(mainService.calculate(stringRequest.getOutputString()), "\"a\": 5, \"c\": 4, \"b\": 1");

	}
	@Test
	void SecondTest() throws Exception {
		StringRequest  stringRequest= new StringRequest("aaafaffffffffffbcffcc");
		mockMvc.perform(post("/calculate")
				.content(objectMapper.writeValueAsString(stringRequest.getOutputString()))
				.contentType(MediaType.APPLICATION_JSON)
		);

		assertEquals(mainService.calculate(stringRequest.getOutputString()), "\"f\": 13, \"a\": 4, \"c\": 3, \"b\": 1");

	}

	@Test
	void ThirdTest() throws Exception {
		StringRequest  stringRequest= new StringRequest("adfaafaffljffffjgkljffffbjhgjfbcffcc");
		mockMvc.perform(post("/calculate")
				.content(objectMapper.writeValueAsString(stringRequest.getOutputString()))
				.contentType(MediaType.APPLICATION_JSON)
		);

		assertEquals(mainService.calculate(stringRequest.getOutputString()), "\"f\": 15, \"j\": 5, \"a\": 4, \"c\": 3, \"b\": 2, \"g\": 2, \"l\": 2, \"d\": 1, \"h\": 1, \"k\": 1");

	}

	@Test
	void FourthTest() throws Exception {
		StringRequest  stringRequest= new StringRequest("dsfrttgdfsdfgggdg");
		mockMvc.perform(post("/calculate")
				.content(objectMapper.writeValueAsString(stringRequest.getOutputString()))
				.contentType(MediaType.APPLICATION_JSON)
		);

		assertEquals(mainService.calculate(stringRequest.getOutputString()), "\"g\": 5, \"d\": 4, \"f\": 3, \"s\": 2, \"t\": 2, \"r\": 1");

	}

	@Test
	void FifthTest() throws Exception {
		StringRequest  stringRequest= new StringRequest("fddgghjkkyuykyukuyjg");
		mockMvc.perform(post("/calculate")
				.content(objectMapper.writeValueAsString(stringRequest.getOutputString()))
				.contentType(MediaType.APPLICATION_JSON)
		);

		assertEquals(mainService.calculate(stringRequest.getOutputString()), "\"y\": 4, \"k\": 4, \"u\": 3, \"g\": 3, \"d\": 2, \"j\": 2, \"f\": 1, \"h\": 1");

	}


}
