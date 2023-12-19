package com.api.parkingcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.parkingcontrol.dtos.parkingspot.ParkingSpotDto;
import com.api.parkingcontrol.dtos.tenant.TenantDto;
import com.api.parkingcontrol.model.ParkingSpot;
import com.api.parkingcontrol.model.Tenant;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.repository.TenantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingControlApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	@Autowired
	private TenantRepository tenantRepository;

	@Test
	void contextLoads() throws JsonProcessingException, Exception {
		TenantDto tenantDto = TenantDto.builder()
				.address("null")
				.cnpj(12345678901L)
				.name("null")
				.build();
		mockMvc.perform(post("/tenant")
				.content("application/json")
				.content(objectMapper.writeValueAsString(tenantDto)))
				.andExpect(status().isOk());
		List<Tenant> tenantEntities = tenantRepository.findAll();
		assertEquals(1,tenantEntities.size());

		ParkingSpotDto parkingSpotDto = ParkingSpotDto.builder()
				.apartment("null")
				.block("null")
				.brandCar("null")
				.colorCar("null")
				.parkingSpotNumber("null")
				.responsibleName("null")
				.tenantId(tenantEntities.get(0).getId())
				.build();
						mockMvc.perform(post("/parkingspot")
				.content("application/json")
				.content(objectMapper.writeValueAsString(parkingSpotDto)))
				.andExpect(status().isOk());
		List<ParkingSpot> parkingSpotEntities = parkingSpotRepository.findAll();
		assertEquals(1,parkingSpotEntities.size());
	}

}
