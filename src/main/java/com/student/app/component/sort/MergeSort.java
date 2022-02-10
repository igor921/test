package com.student.app.component.sort;

import com.student.app.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MergeSort implements StudentSort {
    @Override
    public void sort(ArrayList<Student> students) {
        mergeSort(students, students.size());
    }

    private void mergeSort(ArrayList<Student> students, int size) {
        if (size < 2) {
            return;
        }
        int middle = size / 2;
        ArrayList<Student> left = new ArrayList<>(middle);
        ArrayList<Student> right = new ArrayList<>(size-middle);

        for (int i = 0; i < middle; i++) {
                left.add(students.get(i));
        }

        for (int i = middle; i < size; i++) {
                right.add(students.get(i));
        }
        mergeSort(left, middle);
        mergeSort(right, size - middle);

        merge(students, left, right, middle, size - middle);
    }

    private void merge(
            ArrayList<Student> main, ArrayList<Student> leftData, ArrayList<Student> rightData, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftData.get(i).getScore() <= rightData.get(j).getScore()) {
                main.set(k++,leftData.get(i++));
            } else {
                main.set(k++,rightData.get(j++));
            }
        }
        while (i < left) {
            main.set(k++,leftData.get(i++));
        }
        while (j < right) {
            main.set(k++,rightData.get(j++));
        }
    }

}
