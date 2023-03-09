package com.example.demoMVCproject.Service;

import com.example.demoMVCproject.Dao.UserDao;
import com.example.demoMVCproject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService
{

    @Autowired
    UserDao userDao;
    @Override
    public User savingUser(User user)
    {
         return userDao.save(user);
    }
}
