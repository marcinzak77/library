package com.library.mapper;

import com.library.domain.dto.ReaderDto;
import com.library.domain.entities.Reader;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getSurname());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getName(),
                reader.getSurname());
    }
}
