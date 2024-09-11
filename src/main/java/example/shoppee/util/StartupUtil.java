package example.shoppee.util;

import example.shoppee.model.entity.Role;
import example.shoppee.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupUtil {
    private static Boolean isInitialized = false;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void creatRole() {
        if (!isInitialized) {
            Role role = getRoleByName("ROLE_USER");
            if (role == null) {
                role = new Role();
                role.setRoleName("ROLE_USER");
                roleRepository.save(role);
            }
            role = getRoleByName("ROLE_ADMIN");
            if (role == null) {
                role = new Role();
                role.setRoleName("ROLE_ADMIN");
                roleRepository.save(role);
            }
        }
        System.out.println("Role created");
        isInitialized = true;
    }

    private Role getRoleByName(String name) {
        Role role = roleRepository.findByRoleName(name).orElse(null);
        return role;
    }
}
