package com.library.service;

import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    BookDao bookDao;
    @Autowired
    ReaderDao readerDao;
    @Autowired
    BookRentDao bookRentDao;
}
