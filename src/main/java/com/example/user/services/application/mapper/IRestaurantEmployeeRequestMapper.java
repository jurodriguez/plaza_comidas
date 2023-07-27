package com.example.user.services.application.mapper;

import com.example.user.services.application.dto.RestaurantEmployeeRequestDto;
import com.example.user.services.domain.model.RestaurantEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeRequestMapper {
    RestaurantEmployee toRestaurantEmployeeModel(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);

    RestaurantEmployeeRequestDto toRequest(RestaurantEmployee restaurantEmployee);
}