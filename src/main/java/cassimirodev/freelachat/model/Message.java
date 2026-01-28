package cassimirodev.freelachat.model;


import cassimirodev.freelachat.enums.SendTyper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Message {

    @Id
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Chat chat;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SendTyper SenderType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

}
