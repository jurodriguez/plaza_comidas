package com.example.user.services.infrastructure.input.rest;

import com.example.user.services.application.dto.UserRequest;
import com.example.user.services.application.dto.UserResponse;
import com.example.user.services.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Add a new owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Object invalid", content = @Content)
    })
    @PostMapping("/owner")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<String> saveUserOwner(@RequestBody UserRequest userRequest) {
        userHandler.saveUserInUsers(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Object invalid", content = @Content)
    })
    @PostMapping("/employee")
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity<String> saveUserEmployee(@RequestBody UserRequest userRequest) {
        userHandler.saveUserInUsers(userRequest);
        userHandler.saveRestaurantEmployee(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Client already exists", content = @Content)
    })
    @PostMapping("/customer")
    public ResponseEntity<Void> saveCustomer(@Valid @RequestBody UserRequest customer) {
        userHandler.saveUserInUsers(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }

    @Operation(summary = "Get a user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User returned", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok((userHandler.getUserByEmail(email)));
    }
}
