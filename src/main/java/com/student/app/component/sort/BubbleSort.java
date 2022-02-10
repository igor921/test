package com.student.app.component.sort;

import com.student.app.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BubbleSort implements StudentSort {

    @Override
    public void sort(ArrayList<Student> students) {
        int length = students.size();
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (students.get(j).getScore() > students.get(j + 1).getScore()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
    }
}
