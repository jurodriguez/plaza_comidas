package com.example.user.services.application.mapper;

import com.example.user.services.application.dto.RestaurantResponseDto;
import com.example.user.services.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurantModel);

    Restaurant toRestaurantModel(RestaurantResponseDto restaurantResponseDto);
}
