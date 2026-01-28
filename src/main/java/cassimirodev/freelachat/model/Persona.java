package cassimirodev.freelachat.model;

import cassimirodev.freelachat.enums.PersonaType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long Id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotNull
    private String systemPrompt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private PersonaType type;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
