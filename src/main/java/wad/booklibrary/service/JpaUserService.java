/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.booklibrary.User;
import wad.booklibrary.repository.UserRepository;

/**
 *
 * @author Teemu
 */
@Service
public class JpaUserService implements UserService {
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public User read(Long userId) {
        return userRepo.findOne(userId);
    }

    @Override
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepo.delete(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    
}
