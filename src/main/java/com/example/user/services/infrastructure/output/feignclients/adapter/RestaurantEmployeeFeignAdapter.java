package com.example.user.services.infrastructure.output.feignclients.adapter;

import com.example.user.services.application.dto.RestaurantEmployeeRequestDto;
import com.example.user.services.application.mapper.IRestaurantEmployeeRequestMapper;
import com.example.user.services.domain.model.RestaurantEmployee;
import com.example.user.services.domain.spi.feignclients.IRestaurantEmployeeFeignClientPort;
import com.example.user.services.infrastructure.output.feignclients.RestaurantEmployeeFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantEmployeeFeignAdapter implements IRestaurantEmployeeFeignClientPort {

    private final RestaurantEmployeeFeignClient restaurantEmployeeFeignClient;

    private final IRestaurantEmployeeRequestMapper restaurantEmployeeRequestMapper;

    @Override
    public void saveRestaurantEmployee(RestaurantEmployee restaurantEmployeeModel) {
        RestaurantEmployeeRequestDto restaurantEmployeeRequestDto = restaurantEmployeeRequestMapper.toRequest(restaurantEmployeeModel);
        restaurantEmployeeFeignClient.saveRestaurantEmployee(restaurantEmployeeRequestDto);
    }
}
