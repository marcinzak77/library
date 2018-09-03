package com.library.controller;

import com.library.domain.dto.ReaderDto;
import com.library.domain.entities.Reader;
import com.library.mapper.UserMapper;
import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createNewReader(@RequestBody ReaderDto readerDto) {
        userService.saveReader(userMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public Reader updateReader(@RequestBody ReaderDto readerDto) {
        return userService.saveReader(userMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<Reader> getReaders() {
        return userService.getReaders();
    }
}
