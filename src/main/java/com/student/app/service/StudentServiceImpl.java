package com.student.app.service;

import com.student.app.component.mapper.DataMapper;
import com.student.app.component.parser.Parser;
import com.student.app.component.sort.StudentSort;
import com.student.app.domain.Student;
import com.student.app.domain.enums.SortType;
import com.student.app.service.timelogger.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final Parser parser;
    private final DataMapper studentMapper;
    private final StudentSort bubbleSort;
    private final StudentSort heapSort;
    private final StudentSort mergeSort;
    private final StudentSort defaultSort;

    public StudentServiceImpl(Parser parser, DataMapper studentMapper,
                              @Qualifier("bubbleSort") StudentSort bubbleSort,
                              @Qualifier("mergeSort") StudentSort mergeSort,
                              @Qualifier("heapSort") StudentSort heapSort,
                              @Qualifier("defaultSort") StudentSort defaultSort) {
        this.parser = parser;
        this.studentMapper = studentMapper;
        this.bubbleSort = bubbleSort;
        this.mergeSort = mergeSort;
        this.heapSort = heapSort;
        this.defaultSort = defaultSort;
    }

    @Override
    @LogExecutionTime
    public List<Student> sortByScore(MultipartFile multipartFile, SortType sortType) {
        ArrayList<Student> students = (ArrayList<Student>) studentMapper.mapToStudents(parser.parse(multipartFile));
        log.info(String.format("Sort type: %s, rows: %s", sortType.name(), students.size()));
        switch (sortType) {
            case BUBBLE:
                bubbleSort.sort(students);
                break;
            case HEAP:
                heapSort.sort(students);
                break;
            case MERGE:
                mergeSort.sort(students);
                break;

            default: defaultSort.sort(students);
        }
      return students;
    }
}
