package com.nucsaping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucsaping.model.Food;
import com.nucsaping.model.Level;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DemoSpringBootRestWithEnumApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String CONTENT_TYPE = "text/plain;charset=UTF-8";

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void whenPassingLowerCaseEnumConstant_thenConvert() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/enummapping/get?level=medium"))
				.andExpect(status().isOk())
				.andExpect(content().string(Level.MEDIUM.name()))
				.andExpect(content().contentType(CONTENT_TYPE));
	}

	@Test
	public void saveFoodTest() throws Exception {

		Food food = new Food("Rendang", Level.MEDIUM);

		mockMvc.perform(MockMvcRequestBuilders.post("/food")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(food)))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("$.id").value(1));
	}

}
