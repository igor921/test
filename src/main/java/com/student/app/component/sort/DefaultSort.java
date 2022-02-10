package com.student.app.component.sort;

import com.student.app.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;

@Component
public class DefaultSort implements StudentSort {
    @Override
    public void sort(ArrayList<Student> students) {
        students.sort(Comparator.comparing(o -> o.getScore()));
    }
}
