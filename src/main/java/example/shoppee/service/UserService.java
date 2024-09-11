package example.shoppee.service;

import example.shoppee.dto.request.UserInfoSignup;

public interface UserService {
    UserInfoSignup saveUser(UserInfoSignup user);
}
