package com.johanne.forumHub.dtos;

import com.johanne.forumHub.domain.user.UserRole;

public record UserUpdate(
        String name,
        String email,
        String password,
        String role
) {
}
