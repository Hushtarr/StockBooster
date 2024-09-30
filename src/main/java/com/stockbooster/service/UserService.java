package com.stockbooster.service;

import com.stockbooster.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findUserByEmail(String email);
    UserDTO findUserById(Long id);
    List<UserDTO> findAll();
    void save(UserDTO userDTO);
    void update(Long id,UserDTO userDTO);
    void delete(Long id);
}
