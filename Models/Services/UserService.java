package Models.Services;

import com.nicoz.NZWanderlust.NewUserRequest;
import com.nicoz.NZWanderlust.Entities.User;
import com.nicoz.NZWanderlust.Repositories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User get(Long id){
        return userRepository.findById(id).get();
    }

    public void addUser(NewUserRequest newUserRequest){
        User user = new User();
        user.setUsername(newUserRequest.getUsername());
        user.setPassword(newUserRequest.getPassword());
        user.setName(newUserRequest.getName());
        user.setLastname(newUserRequest.getLastname());
        user.setEmail(newUserRequest.getEmail());
        user.setReputationScoreId(newUserRequest.getReputationScoreId());
        user.setUserTypeId(newUserRequest.getUserTypeId());
        user.setUserType(newUserRequest.getUserType());
        userRepository.save(user);
    }
    public ResponseEntity<User> updateUser(Long id, User userDetails){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = optionalUser.get();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setName(userDetails.getName());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setReputationScoreId(userDetails.getReputationScoreId());
        user.setUserTypeId(userDetails.getUserTypeId());
        user.setUserType(userDetails.getUserType());
        User updateUser = userRepository.save(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    public void delete(Long id){ userRepository.deleteById(id); }
}
