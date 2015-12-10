package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jack on 12/10/15.
 */

//Use @Controller when sending html, se @RestController when sending json
@RestController
public class AngularSpringController {
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/user", method = RequestMethod.GET)  //Only need to specify method type if you are going to have multiple routes with the same name
    public List<User> getUsers() {
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
       // User tempUser = users.findOne(user.id);
       // if (tempUser != null && tempUser.email.equals(user.email)) { Example of a validation before an action can be carried out
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        User user = users.findOne(id);
        if (user != null) {
            users.delete(id);
        }
    }

}
