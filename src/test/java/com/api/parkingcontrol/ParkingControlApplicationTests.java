package com.api.parkingcontrol;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ParkingControlApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/responsibleperson"))
				.andExpect(status().isOk());
		mockMvc.perform(get("/tenant"))
				.andExpect(status().isOk());
		mockMvc.perform(get("/tenantunit"))
				.andExpect(status().isOk());
		mockMvc.perform(get("/parkingspot"))
				.andExpect(status().isOk());
	}

}
