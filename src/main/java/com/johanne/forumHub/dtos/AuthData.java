package com.johanne.forumHub.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthData(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
