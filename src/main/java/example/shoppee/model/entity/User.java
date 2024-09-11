package example.shoppee.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar(255)", nullable = false, unique = true)
    private String email;

    private Boolean userStatus;

    @Column(columnDefinition = "text", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(255)")
    private String avatar;

    @Column(columnDefinition = "varchar(15)", unique = true)
    private String phoneNumber;

    private Integer gender;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @CreationTimestamp
    private LocalDate createAt;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @UpdateTimestamp
    private LocalDate updateAt;

    private Boolean isDeleted = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WishList> wishLists = new HashSet<>();


}
