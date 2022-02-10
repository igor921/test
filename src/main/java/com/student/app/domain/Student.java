package com.student.app.domain;

import com.student.app.exception.DataParseException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Builder
public class Student {
    private String name;
    private double score;

    public static Optional<Student> fromData(String [] data){
        if (data.length < 2) {
            throw new DataParseException("Data error. Format should be: {name},{score}");
        }
        return Optional.of(Student.builder()
                .name(data[0])
                .score(Double.parseDouble(data[1])).build());
    }
}
