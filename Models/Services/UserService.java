package com.nicoz.NZWanderlust.Models.services;

import com.nicoz.NZWanderlust.Models.entities.ReputationScore;
import com.nicoz.NZWanderlust.Models.entities.User;
import com.nicoz.NZWanderlust.Models.entities.UserLevel;
import com.nicoz.NZWanderlust.Models.repository.UserRepository;
import com.nicoz.NZWanderlust.NewUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(NewUserRequest newUserRequest) {
        User user = new User();
        user.setUsername(newUserRequest.getUsername());
        user.setPassword(newUserRequest.getPassword());
        user.setName(newUserRequest.getName());
        user.setLastname(newUserRequest.getLastname());
        user.setEmail(newUserRequest.getEmail());
        user.setAddress(newUserRequest.getAddress());
        user.setPhoneNumber(newUserRequest.getPhoneNumber());
        user.setReputationScore(new ReputationScore());
        user.setUserLevel(new UserLevel());
        userRepository.save(user);
        return user;
    }

    public ResponseEntity<User> updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = optionalUser.get();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setName(userDetails.getName());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        User updateUser = userRepository.save(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    public void delete(Long id) {
        /*Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            return null;
        }
        User user = optionalUser.get();
        if(userHasActiveTickets(user)){ userRepository.deleteById(id); }
        return null;*/
        userRepository.deleteById(id);
    }

 /*   private boolean userHasActiveTickets(User user) {
        if(user.getTicketTravelBuyerList().isEmpty()){ return true; }
        return false;
    }*/


    public User updateOnlyUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return null;
        }
        User user = optionalUser.get();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setName(userDetails.getName());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setReputationScore(userDetails.getReputationScore());
        user.setAddress(userDetails.getAddress());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setUserLevel(userDetails.getUserLevel());
        user.setTicketTravelBuyerList(userDetails.getTicketTravelBuyerList());
        User updateUser = userRepository.save(user);
        return updateUser;
    }
}
