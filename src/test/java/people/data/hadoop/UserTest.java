package people.data.hadoop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private WebTestClient webTestClient;
	@Test
	public void test() throws IOException {
		FluxExchangeResult<User> result = webTestClient.get().uri("/me/").accept(MediaType.APPLICATION_JSON)
				.exchange().returnResult(User.class);
		assert result.getStatus().value() == 200;
		List<User> users = result.getResponseBody().collectList().block();
		assert users.size() == 1;
		assert users.iterator().next().getUser().equals("me");
	}

	@Test
	public void test1() throws IOException {
		User user = webTestClient.get().uri("/user/123")
				.accept(MediaType.APPLICATION_JSON).exchange().returnResult(User.class).getResponseBody().blockFirst();
		assert user.getId().equals("123");
		assert user.getUser().equals("a");
	}

	@Test
	public void test2() throws IOException {
		webTestClient.get().uri("/user1/").accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
				.isNotFound();
	}
}
