package com.johanne.forumHub.dtos;

import com.johanne.forumHub.domain.course.Course;
import com.johanne.forumHub.domain.topic.Status;
import com.johanne.forumHub.domain.topic.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicDataWithReplies(
        Long id,
        String title,
        LocalDateTime creation_date,
        String message,
        Course course,
        Status status,
        List<ReplyData> replies
) {
    public TopicDataWithReplies(Topic topic) {
        this(topic.getId(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getMessage(),
                topic.getCourse(),
                topic.getStatus(),
                topic.getReplies().stream()
                        .map(ReplyData::new)
                        .collect(Collectors.toList())
        );
    }
}