package com.todolist;

import com.todolist.domain.entities.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	@Test
	void testCreateSuccess() {
		var todo = new TodoEntity("todo 1", "desc todo 1", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizada").isEqualTo(todo.isRealizada())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}
	@Test
	void testCreateFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new TodoEntity("", "", false, 0))
				.exchange()
				.expectStatus()
				.isBadRequest();
	}

}
