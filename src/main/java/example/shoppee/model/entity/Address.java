package example.shoppee.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "text", nullable = false)
    private String fullAddress;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;

    @Column(nullable = false)
    private String receiveName;
}
