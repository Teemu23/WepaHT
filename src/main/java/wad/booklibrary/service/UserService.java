/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary.service;

import wad.booklibrary.User;

/**
 *
 * @author Teemu
 */
public interface UserService {
    User read(Long userId);
    void create(User user);
    void delete(Long userId);
    User findByUsername(String username);
    
    
}
