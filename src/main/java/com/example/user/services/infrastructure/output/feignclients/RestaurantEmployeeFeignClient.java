package com.example.user.services.infrastructure.output.feignclients;

import com.example.user.services.application.dto.RestaurantEmployeeRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(contextId = "restaurantEmployee", name = "plazoleta", url = "localhost:8081")
public interface RestaurantEmployeeFeignClient {

    @PostMapping("/api/v1/restaurantEmployee/")
    void saveRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);
}
