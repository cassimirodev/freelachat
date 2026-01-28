package cassimirodev.freelachat.model;

import cassimirodev.freelachat.enums.ChatStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "chats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private ChatStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false, insertable = false)
    private Persona persona;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Message> messages;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
