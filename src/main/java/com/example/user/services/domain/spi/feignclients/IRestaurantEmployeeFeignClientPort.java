package com.example.user.services.domain.spi.feignclients;

import com.example.user.services.domain.model.RestaurantEmployee;

public interface IRestaurantEmployeeFeignClientPort {
    void saveRestaurantEmployee(RestaurantEmployee restaurantEmployee);
}
