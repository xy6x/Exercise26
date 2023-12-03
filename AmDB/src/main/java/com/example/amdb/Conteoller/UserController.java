package com.example.amdb.Conteoller;

import com.example.amdb.Model.Category;
import com.example.amdb.Model.User;
import com.example.amdb.Service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        return ResponseEntity.status(200).body(userService.getAllCategory());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       userService.addCategory(user);
        return ResponseEntity.status(200).body("added User");
    }
    @PutMapping("/put/{id}")

    public ResponseEntity updateUser(@Positive Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateCategory(id, user);
        return ResponseEntity.status(200).body("Update User");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@Positive Integer id) {
        boolean isDelete =userService.deleteUser(id);
        if (isDelete) {
            return ResponseEntity.status(200).body("Delete User");
        }
        return ResponseEntity.status(400).body("Not delete ");
    }
}
