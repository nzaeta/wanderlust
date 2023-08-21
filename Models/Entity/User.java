package com.woderlust.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long userId;
    
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Long reputationScore;
    private Long userTypeId;
    private String userType;


}
