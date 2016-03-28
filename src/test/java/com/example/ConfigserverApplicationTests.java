package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfigserverApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class ConfigserverApplicationTests {
	@Value("${local.server.port}")
	private int port = 0;
	@Test
	public void contextLoads() {
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/DiscoveryServer/default", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		System.out.println(entity.getBody());
	}

}
