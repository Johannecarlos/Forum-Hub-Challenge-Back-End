package com.johanne.forumHub.repositories;

import com.johanne.forumHub.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
}
