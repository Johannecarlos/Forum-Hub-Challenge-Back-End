package com.johanne.forumHub.dtos;

import jakarta.validation.constraints.NotBlank;

public record ReplyCreationData(
        @NotBlank
        String message
) {
}
