package com.johanne.forumHub.domain.reply;

import com.johanne.forumHub.domain.topic.Topic;
import com.johanne.forumHub.domain.user.User;
import com.johanne.forumHub.dtos.ReplyUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Reply")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String message;
    private LocalDateTime creationDate;
    private Boolean soluction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topic topic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
