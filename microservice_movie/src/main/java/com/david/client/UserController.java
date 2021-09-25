package com.david.client;

import com.david.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用戶遠程調用介面
 * <p>
 * 1)使用 @FeignClient，聲明需要調用的微服務
 * 2)檢查@RequestMapping註解，value值(路徑)是否完整
 * 3)@PathVariable 註解的 value值不能省略
 * 4)啟動類添加 @EnableFeignClients註解
 */

@FeignClient(value = "microservice-user", fallback = UserControllerImpl.class)
public interface UserController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public User findById(@PathVariable(value = "id") Integer id);


}
