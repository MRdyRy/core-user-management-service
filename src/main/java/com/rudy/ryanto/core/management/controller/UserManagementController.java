package com.rudy.ryanto.core.management.controller;

import com.rudy.ryanto.core.management.domain.UserDto;
import com.rudy.ryanto.core.management.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@RequestMapping("/v1")
@Slf4j
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @ResponseBody
    @PostMapping("/user/add")
    public Boolean saveNewUser(@RequestBody UserDto req) throws ParseException {
        log.info("/user/add");
        return userManagementService.doSaveNewUser(req);
    }

    @ResponseBody
    @PostMapping("/user/find/{id}")
    public UserDto fingById(@RequestBody UserDto req) throws ParseException {
        log.info("/user/add");
        return userManagementService.findById(req);
    }
}
