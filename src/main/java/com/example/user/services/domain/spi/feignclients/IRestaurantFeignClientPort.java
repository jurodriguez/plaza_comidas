package com.example.user.services.domain.spi.feignclients;

import com.example.user.services.domain.model.Restaurant;

public interface IRestaurantFeignClientPort {

    Restaurant getRestaurantByOwnerId(Long ownerId);
}
