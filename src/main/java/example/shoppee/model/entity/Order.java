package example.shoppee.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private BigDecimal totalPrice;

    private String status;

    @Column(length = 100)
    private String note;

    @Column(length = 100)
    private String receiveName;

    @Column(length = 15)
    private String receivePhone;

    @Column(columnDefinition = "text")
    private String receiveAddress;

    @CreationTimestamp
    private LocalDate createdAt;


    private LocalDate receivedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails;
}
