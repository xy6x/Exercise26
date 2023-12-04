package com.example.amdb.Service;

import com.example.amdb.Model.User;
import com.example.amdb.Repository.MerchantStockRepository;
import com.example.amdb.Repository.ProductRepository;
import com.example.amdb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private  final MerchantStockRepository merchantStockRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public Boolean updateUser(Integer id ,User user){
        User olduser = userRepository.getById(id);
        if (olduser == null) {
            return false;
        }
        olduser.setUserName(user.getUserName());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setBalance(user.getBalance());
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
    public boolean buy(Integer id){
      User user=userRepository.getById(id);
        for (int i = 0; i <productRepository.findAll().size() ; i++) {
            if (merchantStockRepository.findAll().get(i).getStock()>0
                    &&productRepository.findAll().get(i).getPrice()<user.getBalance()) {

                user.setUserName(user.getUserName());
                user.setPassword(user.getPassword());
                user.setEmail(user.getEmail());
                user.setRole(user.getRole());
                user.setBalance(productRepository.findAll().get(i).getPrice()- user.getBalance());
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }
}
