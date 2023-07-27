package com.example.user.services.infrastructure.output.feignclients;

import com.example.user.services.application.dto.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "restaurant", name = "plazoleta", url = "localhost:8081")
public interface RestaurantFeignClient {

    @GetMapping("/api/v1/restaurant/restaurantByOwnerId/{id}")
    RestaurantResponseDto getRestaurantByOwnerId(@PathVariable(value = "id") Long ownerId);
}
