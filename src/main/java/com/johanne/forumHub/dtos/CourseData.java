package com.johanne.forumHub.dtos;

import com.johanne.forumHub.domain.course.Category;
import com.johanne.forumHub.domain.course.Course;

public record CourseData(
        Long id,
        String name,
        Category category) {

    public CourseData(Course course){
        this(course.getId(), course.getName(), course.getCategory());
    }
}
