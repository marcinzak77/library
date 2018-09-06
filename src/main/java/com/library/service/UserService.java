package com.library.service;

import com.library.domain.dao.ReaderDao;
import com.library.domain.entities.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ReaderDao readerDao;

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

    public List<Reader> getReaders() {
        return readerDao.findAll();
    }

    public void deleteReader(final int readerId) {
        readerDao.deleteById(readerId);
    }

}
