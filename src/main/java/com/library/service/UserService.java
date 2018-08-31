package com.library.service;

import com.library.domain.dao.ReaderDao;
import com.library.domain.entities.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ReaderDao readerDao;

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

}
