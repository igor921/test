package com.student.app.service;

import com.student.app.domain.Student;
import com.student.app.domain.enums.SortType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    List<Student> sortByScore(MultipartFile multipartFile, SortType sortingType);
}
