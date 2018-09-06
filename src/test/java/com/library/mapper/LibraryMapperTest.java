package com.library.mapper;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.ItemDto;
import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.library.domain.entities.Item.AVAIL;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryMapperTest {
    @Autowired
    private LibraryMapper libraryMapper;

    @Test
    public void shouldConvertItemListToDto() {
        //Given
        List<Item> items = Arrays.asList(new Item(1, AVAIL));
        //When
        List<ItemDto> itemDtos = libraryMapper.mapToItemDtoList(items);
        //Then
        assertEquals(1, itemDtos.size());
        assertEquals(1, itemDtos.get(0).getBookTitleId());
        assertEquals(AVAIL, itemDtos.get(0).getBookStatus());
    }

    @Test
    public void shouldConvertToBookDto() {
        //Given
        List<Item> items = Arrays.asList(new Item(1, AVAIL));
        Book book = new Book(1, "title 1", "title 1", 2005, items);
        //When
        BookDto bookDto = libraryMapper.mapToBookDto(book);
        //Then
        assertEquals(1, bookDto.getTitleId());
        assertEquals(2005, bookDto.getReleaseDate());
        assertEquals(1, bookDto.getItems().size());
        assertEquals(AVAIL, bookDto.getItems().get(0).getBookStatus());
        System.out.println(bookDto.getItems());
    }
}