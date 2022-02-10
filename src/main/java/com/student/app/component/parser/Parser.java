package com.student.app.component.parser;

import org.springframework.web.multipart.MultipartFile;

public interface Parser {
    String[] parse(MultipartFile multipartFile);
}
