package com.student.app.controller;

import com.student.app.domain.enums.SortType;
import com.student.app.domain.Student;
import com.student.app.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //in real life need to use DTO in response
    @PostMapping(value = "/sort", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Student> sortByScore(@RequestParam("file")MultipartFile file,
                                     @RequestParam(value = "sortingType", defaultValue = "DEFAULT") SortType sortingType) {
        return studentService.sortByScore(file, sortingType);
    }

}
