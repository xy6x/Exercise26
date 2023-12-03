package com.example.amdb.Service;

import com.example.amdb.Model.Category;
import com.example.amdb.Model.User;
import com.example.amdb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllCategory(){
        return userRepository.findAll();
    }
    public void addCategory(User user){
        userRepository.save(user);
    }
    public Boolean updateCategory(Integer id ,User user){
        User olduser = userRepository.getById(id);
        if (olduser == null) {
            return false;
        }
        olduser.setUserName(user.getUserName());
        olduser.setRole(user.getRole());
        olduser.setBalance(user.getBalance());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        userRepository.save(olduser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User user =userRepository.getById(id);
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }
}
