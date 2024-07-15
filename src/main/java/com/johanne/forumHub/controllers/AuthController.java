package com.johanne.forumHub.controllers;

import com.johanne.forumHub.domain.user.User;
import com.johanne.forumHub.dtos.AuthData;
import com.johanne.forumHub.dtos.TokenDataJWT;
import com.johanne.forumHub.infra.security.TokenService;
import com.johanne.forumHub.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Operation(summary = "Logar", description = "Autenticar usuário previamente cadastrado")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthData dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(),dados.password());
        var authentication = manager.authenticate(authenticationToken);


        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDataJWT(tokenJWT));
    }


}
