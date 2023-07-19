package com.example.plaza_comidas.infrastructure.input.rest;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.application.handler.IUsuarioHandler;
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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final IUsuarioHandler usuarioHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Object invalid", content = @Content)
    })
    @PostMapping("/user")
    public ResponseEntity<String> saveUsuarioInUsuarios(@RequestBody UsuarioRequest usuarioRequest) {
        usuarioHandler.saveUsuarioInUsuarios(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
