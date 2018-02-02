package people.data.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import people.data.hadoop.model.City;
import people.data.hadoop.model.PersonInfo;
import people.data.hadoop.service.CityService;
import people.data.hadoop.service.PersonInfoService;
import reactor.core.publisher.Mono;

/**
 * HBase内Person信息Restful暴露
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonInfoService personInfoService;

    @RequestMapping(value = "/{rowkey}", method = RequestMethod.GET)
    public Mono<PersonInfo> findOneCity(@PathVariable("rowkey") String rowkey) {
        return Mono.create(cityMonoSink ->{
            PersonInfo personInfo= personInfoService.findPersonInfoByRowKey(rowkey);
            if(rowkey==null){
                cityMonoSink.error(new Exception("not find"+rowkey));
            }else {
                cityMonoSink.success(personInfo);
            }
        });
    }
}
