package people.data.hadoop.service.impl;

import org.springframework.stereotype.Service;
import people.data.hadoop.model.City;
import people.data.hadoop.service.CityService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市业务逻辑实现类
 */
@Service
public class CityServiceImpl implements CityService {

    // 模拟数据库，存储 City 信息
    private static Map<Long, City> CITY_DB = new HashMap<>();

    public List<City> findAllCity() {
        return new ArrayList<>(CITY_DB.values());
    }

    public City findCityById(Long id) {
        return CITY_DB.get(id);
    }

    @Override
    public Long saveCity(City city) {
        //city.setId(CITY_DB.size() + 1L);
        CITY_DB.put(city.getId(), city);
        return city.getId();
    }

    @Override
    public Long updateCity(City city) {
        CITY_DB.put(city.getId(), city);
        return city.getId();
    }

    @Override
    public Long deleteCity(Long id) {
        CITY_DB.remove(id);
        return id;
    }

}
