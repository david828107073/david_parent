package com.david.client;

import com.david.vo.User;
import org.springframework.stereotype.Component;

/**
 * 熔斷器類別
 */
@Component
public class UserControllerImpl implements UserController {

    @Override
    public User findById(Integer id) {
        System.out.println("執行了熔斷器");
        return null;
    }
}
