package com.johanne.forumHub.dtos;

import com.johanne.forumHub.domain.user.User;
import com.johanne.forumHub.domain.user.UserRole;

public record UserDetails(
        String nome,
        String email,
        UserRole role
) {
    public UserDetails(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
