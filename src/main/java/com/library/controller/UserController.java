package com.library.controller;

import com.library.domain.dto.ReaderDto;
import com.library.domain.entities.Reader;
import com.library.mapper.UserMapper;
import com.library.service.DbUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class UserController {
    private final DbUser dbUser;
    private final UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createNewReader(@RequestBody ReaderDto readerDto) {
        dbUser.saveReader(userMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public Reader updateReader(@RequestBody ReaderDto readerDto) {
        return dbUser.saveReader(userMapper.mapToReader(readerDto));
    }
}
