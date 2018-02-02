package people.data.hadoop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import people.data.hadoop.model.City;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CityTest {
	@Autowired
	private WebTestClient webTestClient;

	private City newCity(Long id,Long provinceId,String cityName,String description){
		City city=new City();
		city.setId(id);
		city.setProvinceId(provinceId);
		city.setCityName(cityName);
		city.setDescription(description);
		return city;
	}
    private final String PATH="/city/";
	private final City GY=newCity(123L,522L,"guiyang","贵阳");
	private final City CD=newCity(123L,610L,"chengdu","成都");

    @Before
	public void post() throws IOException {
		webTestClient.post().uri(PATH)
				.contentType(MediaType.APPLICATION_JSON)
				//.body(Mono.just(GY), City.class)
				.body(fromPublisher(Mono.just(GY), City.class))
				.exchange()
				.expectStatus().isOk()
				.expectBody(Long.class).isEqualTo(GY.getId());
	}

	@Test
	public void getGY() throws IOException {
        webTestClient.get().uri(PATH+GY.getId())
				.accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(City.class).isEqualTo(GY);
                //.expectBody().jsonPath("$.id").isNotEmpty().jsonPath("$.id").isEqualTo(GY.getId());
                //.expectBody(City.class).returnResult().getResponseBody()
                //.returnResult(City.class).getResponseBody().blockFirst();
	}

	@Test
	public void putGYtoCD() throws IOException {
		webTestClient.put().uri(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(CD), City.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Long.class).isEqualTo(CD.getId());
	}

    @Test
    public void getALL() throws IOException {
       webTestClient.get().uri(PATH)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(City.class).contains(GY);
    }

    @Test
    public void deleteALL() throws IOException {
        webTestClient.delete().uri(PATH+GY.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Long.class).isEqualTo(GY.getId());
    }
}
