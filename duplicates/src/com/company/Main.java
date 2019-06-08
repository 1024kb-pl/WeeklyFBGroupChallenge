package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main<T> {
    private Object [] removeNull(Object [] arr) {
        int length = 0;
        while (arr[length] != null) {
            length++;
        }

        Object [] newArr = new Object[length];

        System.arraycopy(arr, 0, newArr, 0, length);

        return newArr;
    }

    @SuppressWarnings("unchecked")
    private T [] removeDuplicates(T [] arr) {
        Object [] newArr = new Object[arr.length];

        int currentElement = 0;
        for (int i=0;i<arr.length;i++) {
            boolean foundDuplicate = false;

            for (int j=i + 1;j<arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    foundDuplicate = true;
                    break;
                }
            }

            if (!foundDuplicate) {
                newArr[currentElement] = arr[i];
                currentElement += 1;
            }
        }

        return (T []) removeNull(newArr);
    }

    public static void main(String[] args) {
        String [] sDuplicates = {"asd", "qwe", "asd", "as", "ee", "qw", "qwe"};
        Float [] fDuplicates = {1.0f, 1.1f, 0.9f, 1.0f, 2.0f, 1.5f, .9f};
        Integer [] iDuplicates = {1, 2, 1, 0, 2, 5, 9, 1, 4};

        Arrays.stream(new Main<String>().removeDuplicates(sDuplicates)).forEach(System.out::println);
        Arrays.stream(new Main<Float>().removeDuplicates(fDuplicates)).forEach(System.out::println);
        Arrays.stream(new Main<Integer>().removeDuplicates(iDuplicates)).forEach(System.out::println);

        new Main<Integer>().forbiddenSolutionUsingJavaCollection(iDuplicates).forEach(System.out::println);
    }

    private Set<T> forbiddenSolutionUsingJavaCollection(T [] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }
}
