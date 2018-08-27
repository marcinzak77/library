package com.library.controller;

import com.google.gson.Gson;
import com.library.domain.dao.BookDao;
import com.library.domain.dto.BookDto;
import com.library.domain.entities.Book;
import com.library.mapper.LibraryMapper;
import com.library.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllerTest {
    @InjectMocks
    private LibraryMapper libraryMapper;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private DbService dbService;

    @Test
    public void shouldAddBook() throws Exception {
        //Given
        Book book = new Book("test author", "test title", 2008);

    //    BookDto bookDto = libraryMapper.mapToBookDto(book);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(libraryMapper.mapToBookDto(book));

        //When&Then
        mockMvc.perform(post("/library/addBook").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

    }

}