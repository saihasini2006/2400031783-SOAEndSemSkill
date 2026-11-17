package com.klu.springmvc;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Restaurants")
public class RestaurantController {
  @GetMapping
  public List<Map<String,Object>> getRestaurants(){
    List<Map<String,Object>> list=new ArrayList<>();
    Map<String,Object> r1=new HashMap<>();
    r1.put("id", 1);
    r1.put("Name", "Pizza Hunt");
    r1.put("location", "Vijayawada");
    Map<String,Object> r2=new HashMap<>();
    r2.put("id", 2);
    r2.put("Name", "Burger Hunt");
    r1.put("location", "Guntur");
    list.add(r1);
    list.add(r2);
    return list;
  }
  @GetMapping("/{id}")
  public Map<String, Object> getRestaurant (@PathVariable Integer id) {
    List<Map<String, Object>> restaurants=getRestaurants();
    for (Map<String, Object> restaurant: restaurants) {
      Integer restaurantid=(Integer) restaurant.get("id");
      if(restaurantid.equals(id)) {
        return restaurant;
      }
    }
    Map<String,Object> respose=new HashMap<>();
    respose.put("message", "restaurant ID not present");
    return respose;
  }
}