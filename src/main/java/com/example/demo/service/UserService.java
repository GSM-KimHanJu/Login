package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // BCrypt: 비밀번호와 같은 중요 정보들을 안전하게 해싱시키는 해싱 함수
    // 해싱: 특정 데이터를 해싱화하여 보안이 강력하게 만들어 줌.
    // 허나 비밀번호를 잃어버렸을 시 복구가 불가 -> 새로운 비밀번호로 재설정하여 해결
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail("admin@gmail.com");
        userRepository.save(user);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
