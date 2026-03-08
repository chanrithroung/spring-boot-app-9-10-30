package org.chanrith.chanrith.controller;
import org.chanrith.chanrith.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    List<User> userList = new ArrayList<>();
    /// this method use for check email is already exist or not
    /// if exist @return true, otherwise return false;
    /// <h1>Dev profile </h1>
    /// <img width="20px" src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/621814567_122199199592370182_6383625049756325771_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=hl8gjJSpLygQ7kNvwGSlsUZ&_nc_oc=AdnVm4WJVSjL7LDCD8jTa-wzaezAyIgZA3IehmfJzpdQIBRqjFZ1vNoYJPdDucxiwZM&_nc_zt=23&_nc_ht=scontent.fpnh11-2.fna&_nc_gid=QMc70AvIBfvzS0g-zSOBKw&_nc_ss=8&oh=00_Afz5Z-U4F6yawGXytPQE7n4z9QQhs8t4ktRyWIzE8GOdfQ&oe=69B34ECA" />
    /**
     *
     * @param requestEmail
     * @return
     */
    boolean isExistEmail(String requestEmail) {
       return userList.stream().anyMatch(user -> user.getEmail().equals(requestEmail));
    }

    User getOneUser(Integer id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findAny().orElseThrow(() ->
            new RuntimeException("user not found"));
    }

    @GetMapping
    List<User> getAllUser() {
        return userList;
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable Integer id) {
//        return "user id = " + id;
        try {
            return getOneUser(id);
        } catch (RuntimeException exception) {
            return null;
        }
    }

    // after follow the best practice I will code for check username or email
    @PostMapping
    String createUser(@RequestBody User userRequest) {
       if(isExistEmail(userRequest.getEmail()))
          return "Failed to create user! this email is already used!";
       Integer newId;
       if(userList.toArray().length == 0) newId = 1;
       else newId = userList.get(userList.toArray().length - 1).getId() + 1;
       User newUser = new User(
               newId,
               userRequest.getUsername(),
               userRequest.getEmail()
       );
       userList.add(newUser);
       return "User saved!";
    }
}

// create, getAll, getOne, Update, Delete