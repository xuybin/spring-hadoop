package people.data.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import people.data.hadoop.model.City;
import people.data.hadoop.service.CityService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 */
@RestController
@RequestMapping(value = "/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mono<City> findOneCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink ->{
                City city= cityService.findCityById(id);
                if(city==null){
                    cityMonoSink.error(new Exception("not find"+id));
                }else {
                    cityMonoSink.success(city);
                }

        });
    }

    @RequestMapping(method = RequestMethod.GET)
    public Flux<City> findAllCity() {
        return Flux.create(cityFluxSink -> {
            cityService.findAllCity().forEach(city -> {
                cityFluxSink.next(city);
            });
            cityFluxSink.complete();
        });
    }

    @RequestMapping(value = "/all/",method = RequestMethod.GET)
    public Flux<City> findAllCity1() {
        return Flux.just(cityService.findAllCity().toArray(new City[]{}));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Mono<Long> createCity(@RequestBody City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.saveCity(city)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Mono<Long> modifyCity(@RequestBody City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.updateCity(city)));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Mono<Long> modifyCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.deleteCity(id)));
    }
}
