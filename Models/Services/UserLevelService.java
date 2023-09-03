package com.nicoz.NZWanderlust.Models.services;

import com.nicoz.NZWanderlust.Models.entities.UserLevel;
import com.nicoz.NZWanderlust.Models.repository.UserLevelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserLevelService {

	private final UserLevelRepository userLevelRepository;

	public UserLevelService(UserLevelRepository userLevelRepository) {
		this.userLevelRepository = userLevelRepository;
	}

	//only when user entity is generated
	@Transactional
	public UserLevel newUserLevel(UserLevel userLevel) {
		UserLevel newUserLevel = new UserLevel();
		newUserLevel.setLevelName(userLevel.getLevelName());
		newUserLevel.setNumberOfTickets(0);
		newUserLevel.setProfit(0.0);
		newUserLevel.setUser(userLevel.getUser());
		userLevelRepository.save(newUserLevel);
		return newUserLevel;
	}

	//only when user entity is deleted
    @Transactional
    public void deleteUserLevel(Long id) {
    	UserLevel userLevel = searchUserLevel(id);
    	userLevelRepository.delete(userLevel);
    }

	@Transactional(readOnly = true)
	public UserLevel searchUserLevel(Long id) {
		return userLevelRepository.findById(id).get();
	}
	
	@Transactional
	public ResponseEntity<UserLevel> updateUserLevel(Long id, UserLevel userLevel)  {
		Optional<UserLevel> optionalUserLevel = userLevelRepository.findById(id);
		if(!optionalUserLevel.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		UserLevel userLevelToUpdate = optionalUserLevel.get();
		userLevelToUpdate.setLevelName(userLevel.getLevelName());
		userLevelToUpdate.setNumberOfTickets(userLevel.getNumberOfTickets());
		userLevelToUpdate.setProfit(userLevel.getProfit());
		UserLevel userLevelUpdate = userLevelRepository.save(userLevelToUpdate);
		return new ResponseEntity<>(userLevelUpdate,HttpStatus.OK);

	}
}
