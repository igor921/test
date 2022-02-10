package com.student.app.component.sort;

import com.student.app.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HeapSort implements StudentSort{

    @Override
    public void sort(ArrayList<Student> students) {
        if (students.size() == 0) {
            return;
        }

        int length = students.size();

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapProcess(students, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            Student tmp = students.get(0);
            students.set(0, students.get(i));
            students.set(i,tmp);
            heapProcess(students, i, 0);
        }
    }

    private void heapProcess(ArrayList<Student> students, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && students.get(left).getScore() > students.get(largest).getScore()) {
            largest = left;
        }
        if (right < length && students.get(right).getScore() > students.get(largest).getScore()) {
            largest = right;
        }
        if (largest != i) {
            Student tmp = students.get(i);
            students.set(i,students.get(largest));
            students.set(largest,tmp);
            heapProcess(students, length, largest);
        }
    }
}
