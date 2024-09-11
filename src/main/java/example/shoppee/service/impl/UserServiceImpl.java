package example.shoppee.service.impl;

import example.shoppee.dto.request.UserInfoSignup;
import example.shoppee.model.entity.Role;
import example.shoppee.model.entity.User;
import example.shoppee.repository.RoleRepository;
import example.shoppee.repository.UserRepository;
import example.shoppee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserInfoSignup saveUser(UserInfoSignup userInfoSignup) {
        User newUser = new User();
          newUser = User.builder()
                .firstName(userInfoSignup.getFirstName())
                .lastName(userInfoSignup.getLastName())
                .email(userInfoSignup.getEmail())
                .password(userInfoSignup.getPassword())
                .gender(userInfoSignup.getGender())
                .isDeleted(false)
                .userStatus(true).build();
        Role role = roleRepository.findByRoleName("ROLE_USER").orElseThrow(()-> new  NoSuchElementException("Role not fount"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        newUser.setRoles(roles);
        userRepository.save(newUser);

        return userInfoSignup;
    }
}
