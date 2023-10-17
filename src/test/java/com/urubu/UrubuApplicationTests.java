package com.urubu;

import com.urubu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class UrubuApplicationTests {

//	@Autowired
//	private WebTestClient webTestClient;

	@Test
	void testCreateUserSuccess() {
//		var user = new User("id", "username", 49.99);
//
//		webTestClient
//				.post()
//				.uri("/users")
//				.bodyValue(user)
//				.exchange()
//				.expectStatus().isCreated()
//				.expectBody()
//				.jsonPath("$").isArray()
//				.jsonPath("$.length()").isEqualTo(1)
//				.jsonPath("$[0].username").isEqualTo(user.getUsername())
//				.jsonPath("$[0].balance").isEqualTo(user.getBalance());
//
	}

}
