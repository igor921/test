package com.student.app.component.mapper;

import com.student.app.domain.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataMapper {

    private final String delimiter = ",";

    public Optional<Student> mapToStudent(String value) {
        if (StringUtils.hasText(value)) {
            String[] studentData = value.split(delimiter);
            return Student.fromData(studentData);
        }
        return Optional.empty();
    }

    public List<Student> mapToStudents(String[] values) {
        return Stream.of(values)
                .map(this::mapToStudent)
                .filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }
}
