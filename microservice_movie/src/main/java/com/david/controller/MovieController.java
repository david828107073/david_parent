package com.david.controller;

import com.david.client.UserController;
import com.david.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movie")
@RestController
public class MovieController {
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
//    @Autowired
//    private LoadBalancerClient client;

    /**
     * 購票方法
     */
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order() {
//        //模擬當前用戶
//        Integer id = 2;
//        //查詢用戶微服務，獲取用戶訊息
//        //使用restTemplate遠程調用用戶微服務
//        /**
//         * 參數一；調用 URL 地址
//         * 參數二:需要封裝的物件類型
//         */
//        User user = restTemplate.getForObject("http://localhost:9001/user/" + id, User.class);
//        System.out.println(user.getUsername() + "正在購票.....");
//        System.out.println();
//        return "購票成功";
//    }
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order() {
//        Integer id = 2;
//        //獲取到所有同名的微服務
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user");
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return "購票成功";
//    }

    /**
     * 購票方法 使用Ribbon(loading balence)
     *
     * @return
     */
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order() {
//        Integer id = 2;
//        //獲取到所有同名的微服務
////        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user");
////        ServiceInstance serviceInstance = instances.get(0);
    //使用ribbon挑選合適的服務實體
//        ServiceInstance serviceInstance = client.choose("microservice-user");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return "購票成功";
//    }

//    /**
//     * 簡化版Ribbon
//     *
//     * @return
//     * 啟動類添加@
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String order() {
//        Integer id = 2;
//        //使用ribbon挑選合適的服務實體
//        String url = "http://microservice-user/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return "購票成功";
//    }

    /**
     * 熔斷處理方法
     */

//    public String fallback() {
//        return "服務暫時無法運作!";
//    }


    @Autowired
    private UserController userController;


    /**
     * 使用OpenFeign
     *
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order() {
        Integer id = 2;
        User user = userController.findById(id);
        return "購票成功";
    }
}

