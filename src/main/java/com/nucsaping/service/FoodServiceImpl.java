package com.nucsaping.service;

import com.nucsaping.model.Food;
import com.nucsaping.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
}
