package com.stockbooster.controller;

import com.stockbooster.dto.UserDTO;
import com.stockbooster.dto.common.ApiInfo;
import com.stockbooster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/",
        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("public/users")
    public ResponseEntity<ApiInfo<List<UserDTO>>> findAllUsers() {
        List<UserDTO>userList=userService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Here is the list of users", userList));
    }
    @GetMapping("public/users{id}")
    public ResponseEntity<ApiInfo<UserDTO>> findUsersById(@PathVariable Long id) {
        UserDTO user=userService.findUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Here is the user", user));
    }

    @GetMapping("public/users{email}")
    public ResponseEntity<ApiInfo<UserDTO>> findUsersByEmail(@PathVariable String email) {
        UserDTO user=userService.findUserByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Here is the user", user));
    }

    @PostMapping("admin/users")
    public ResponseEntity<ApiInfo<Void>>creatUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiInfo.successVoid("user created"));
    }

    @DeleteMapping("admin/users{id}")
    public ResponseEntity<ApiInfo<Void>>deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successVoid("user deleted"));
    }

    @PutMapping("admin/user{id}")
    public ResponseEntity<ApiInfo<Void>>updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successVoid("user updated"));
    }

}
