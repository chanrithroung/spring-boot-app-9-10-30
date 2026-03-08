package org.chanrith.chanrith.controller;
import org.chanrith.chanrith.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    List<User> userList = new ArrayList<>();


    ///  this method use for check email is already exist or not
    /// if exist @return true, otherwise return false;
    boolean isExistEmail(String requestEmail) {
        boolean validEmail = true;
        for (User user : userList) {
            if(user.getEmail().equals(requestEmail)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping
    List<User> getAllUser() {
        return userList;
    }

    // after follow the best practice I will code for check username or email
    @PostMapping
    String createUser(@RequestBody User userRequest) {
       if(isExistEmail(userRequest.getEmail())) {
          return "Failed to create user! this email is already used!";
       } else {
           Integer newId;
           if(userList.toArray().length == 0) {
               newId = 1;
           } else {
               newId = userList.get(userList.toArray().length - 1).getId() + 1;
           }
           User newUser = new User(
                   newId,
                   userRequest.getUsername(),
                   userRequest.getEmail()
           );
           userList.add(newUser);
           return "User saved!";
       }
    }

}
