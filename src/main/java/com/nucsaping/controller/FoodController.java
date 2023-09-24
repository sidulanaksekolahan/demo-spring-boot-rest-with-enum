package com.nucsaping.controller;

import com.nucsaping.model.Food;
import com.nucsaping.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Food> saveFood(@RequestBody Food food) {

        Food result = foodService.saveFood(food);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
