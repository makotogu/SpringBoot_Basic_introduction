package com.example.springbootint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String name2;

    @Value("${address[0]}")
    private String address;

    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        return  "hello spring boot 22";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        System.out.println(name);
        return  "hello spring boot 22";
    }

    @RequestMapping("/hello3")
    public String hello3() {
        System.out.println(name2);
        return  "hello spring boot 22";
    }

    @RequestMapping("/hello4")
    public String hello4() {
        System.out.println(address);
        return "hello";
    }

    @RequestMapping("/hello5")
    public String hello5() {
        System.out.println(msg1);
        System.out.println(msg2);
        return "hello";
    }

    @RequestMapping("/hello6")
    public String hello6() {
        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("address[0]"));
        return "hello";
    }

    @RequestMapping("/hello7")
    public String hello7() {
        System.out.println(person);
        return "hello";
    }

    @RequestMapping("/hello8")
    public String hello8() {
        System.out.println(person);
        String[] addresses = person.getAddress();
        for (String s : addresses) {
            System.out.println(s);
        }
        return "hello";
    }
}
