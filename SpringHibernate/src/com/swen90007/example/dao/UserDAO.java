package com.swen90007.example.dao;

import java.util.List;
import com.swen90007.example.domain.User;

public interface UserDAO {
    public void saveUser(User user);

    public List<User> listUser();
}
