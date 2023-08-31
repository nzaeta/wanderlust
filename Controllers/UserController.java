package Controllers;

import com.nicoz.NZWanderlust.NewUserRequest;
import com.nicoz.NZWanderlust.Entities.User;
import com.nicoz.NZWanderlust.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/")
    public List<User> getAllUsers() { return userService.getUsers();}

    @PostMapping("/users/")
    public void addUser(@RequestBody NewUserRequest request) { userService.addUser(request); }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) { return userService.updateUser(id, user);}

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) { userService.delete(id);}

}
