package example.shoppee.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String sku;

    @Column(length = 100, nullable = false,unique = true)
    private String productName;

    @Column(columnDefinition = "text")
    private String description;

    private BigDecimal unitPrice;

    @Min(0)
    private Integer stockQuantity;

    private String image;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @CreationTimestamp
    private LocalDate createAt;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @UpdateTimestamp
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShoppingCart> shoppingCarts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WishList> wishLists;


}
