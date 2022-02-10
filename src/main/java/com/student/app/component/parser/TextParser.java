package com.student.app.component.parser;

import com.student.app.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
public class TextParser implements Parser {
    @Override
    public String[] parse(MultipartFile multipartFile) {
        if (multipartFile == null) {
            throw new FileException("File problem");
        }
        String studentsScore;
        try {
            studentsScore = new String(multipartFile.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new FileException("File process error");
        }
        return studentsScore.split("\n");
    }
}
