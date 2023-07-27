package com.example.user.services.infrastructure.output.feignclients.adapter;

import com.example.user.services.application.dto.RestaurantResponseDto;
import com.example.user.services.application.mapper.IRestaurantResponseMapper;
import com.example.user.services.domain.model.Restaurant;
import com.example.user.services.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.example.user.services.infrastructure.output.feignclients.RestaurantFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantFeignAdapter implements IRestaurantFeignClientPort {

    private final RestaurantFeignClient restaurantFeignClient;

    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public Restaurant getRestaurantByOwnerId(Long ownerId) {
        RestaurantResponseDto restaurantResponseDto = restaurantFeignClient.getRestaurantByOwnerId(ownerId);
        return restaurantResponseMapper.toRestaurantModel(restaurantResponseDto);
    }
}
