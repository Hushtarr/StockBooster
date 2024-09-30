package com.stockbooster.service.impl;

import com.stockbooster.dto.UserDTO;
import com.stockbooster.entity.User;
import com.stockbooster.exception.UserNotFoundException;
import com.stockbooster.repository.UserRepository;
import com.stockbooster.service.UserService;
import com.stockbooster.util.MapperTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperTool mapper;

    @Override
    public UserDTO findUserByEmail(String email) {
        return mapper.convert(userRepository.findByEmail(email), UserDTO.class);
    }

    @Override
    public UserDTO findUserById(Long id) {
        return mapper.convert(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAllByIsDeletedFalse().stream()
                .map(user->mapper.convert(user,UserDTO.class))
                .toList();
    }

    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(mapper.convert(userDTO, User.class));
    }

    @Override
    public void update(Long id,UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("no such user"));
        userDTO.setId(user.getId());
        save(userDTO);
    }

    @Override
    public void delete(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("no such user"));
        user.setIsDeleted(true);
        userRepository.save(user);
    }
}
