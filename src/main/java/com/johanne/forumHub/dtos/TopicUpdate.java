package com.johanne.forumHub.dtos;

import com.johanne.forumHub.domain.topic.Status;

public record TopicUpdate(
        String title,
        String message,
        Status status,
        Long course_id
) {}