package com.springBootDemo.Initial.controller;

import com.springBootDemo.Initial.model.User;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String Home(){
        return "Hi, I am Shudhanshu, Welcome to my page";
    }
    @GetMapping("/user")
    public User u(){
        User user = new User();
        user.setId(1);
        user.setName("shudhanshu");
        user.setDepartment("Software Engineering");
        return user;
    }

    @GetMapping("/find/{id}/{s}")
    public String printId( @PathVariable String id,@PathVariable("s")  String sns){
        return id+" "+sns;
    }

    @GetMapping("/find")
    public String printIdPathParameter( @RequestParam("name1") String id,@RequestParam(value = "name2",required = false,defaultValue = "")  String sns){
        return id+" "+sns;
    }
}
