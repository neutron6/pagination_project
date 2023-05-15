package com.rsn.pagination.pagination_with_sorting.service;

import com.rsn.pagination.pagination_with_sorting.exception.ResourceNotFoundException;
import com.rsn.pagination.pagination_with_sorting.model.User;
import com.rsn.pagination.pagination_with_sorting.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user, int id) {
        User user1 = userRepo.findById((long) id).map(product -> {
            user.setProduct(product.getProduct());
            return userRepo.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("csd" + id));

        return userRepo.save(user);
    }

    public List<User> getAllUserData() {
        List<User> userList = new ArrayList<>();
        if (userList.isEmpty()) {
            throw new ResourceNotFoundException("user list is empty");
        } else {
            return userRepo.findAll();
        }
    }


    public Optional<User> getDataById(long userId) {
        return userRepo.findById(userId);
    }
}
