package com.example.plaza_comidas.infrastructure.input.rest;

import com.example.plaza_comidas.application.dto.UserRequest;
import com.example.plaza_comidas.application.dto.UserResponse;
import com.example.plaza_comidas.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Object invalid", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> saveUserInUsers(@RequestBody UserRequest userRequest) {
        userHandler.saveUserInUsers(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }
}
