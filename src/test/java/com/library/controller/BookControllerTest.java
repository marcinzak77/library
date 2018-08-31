package com.library.controller;

import com.google.gson.Gson;
import com.library.domain.dto.BookDto;
import com.library.mapper.LibraryMapper;
import com.library.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibraryMapper libraryMapper;
    @MockBean
    private BookService bookService;

    @Test
    public void shouldAddBook() throws Exception {
        //Given
        BookDto bookDto = new BookDto(1,"test author", "test title", 2008, new ArrayList<>());

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When&Then
        mockMvc.perform(post("/library/addBook").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

    }

}