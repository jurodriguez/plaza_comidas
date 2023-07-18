package com.example.plaza_comidas.infrastructure.input.rest;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.application.dto.UsuarioResponse;
import com.example.plaza_comidas.application.handler.IUsuarioHandler;
import com.example.plaza_comidas.domain.exception.RequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final IUsuarioHandler usuarioHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Object invalid", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> saveUsuarioInUsuarios(@RequestBody UsuarioRequest usuarioRequest) {
        try {
            usuarioHandler.saveUsuarioInUsuarios(usuarioRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RequestException | ConstraintViolationException e) {
            log.info(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioResponse>> getAllUsuarioFromUsuarios() {
        return ResponseEntity.ok(usuarioHandler.getAllUsuarioFromUsuarios());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<UsuarioResponse> getUsuarioFromUsuarios(@PathVariable(name = "numero") String numeroDocumento) {
        return ResponseEntity.ok(usuarioHandler.getUsuarioFromUsuarios(numeroDocumento));
    }
}
