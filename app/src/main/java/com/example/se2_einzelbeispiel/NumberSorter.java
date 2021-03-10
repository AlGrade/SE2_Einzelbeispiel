package com.example.se2_einzelbeispiel;

import java.util.ArrayList;

public class NumberSorter {

    String sortedNumber;
    ArrayList<Integer> tempNumbers = new ArrayList<>();

    public NumberSorter(String numberToSort) {
        this.sortedNumber = sortNumber(numberToSort);
    }

    public String sortNumber(String numberToSort) {

        ArrayList<Integer> tempEven = new ArrayList<>();
        ArrayList<Integer> tempOdd = new ArrayList<>();

        generateNumberList(numberToSort);

        // split the mat. nr in odd and even
        for (int i = 0; i < tempNumbers.size(); i++) {
            if (tempNumbers.get(i) % 2 == 0) {
                tempEven.add(tempNumbers.get(i));
            } else tempOdd.add(tempNumbers.get(i));
        }

        // sort the two temp lists separately
        tempEven = bubbleSort(tempEven);
        tempOdd = bubbleSort(tempOdd);

        // concat the two lists and convert them to a string
        return concat(tempEven, tempOdd);
    }

    /**
     * converts the given string of numbers to an array list of numbers
     * @param numbers the string that is converted
     */
    public void generateNumberList(String numbers) {

        for (int i = 0; i < numbers.length(); i++) {
            tempNumbers.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
    }

    /**
     * implemented a bubble sort to sort the two temporary array lists; alternatively libraries of the Arrays package could have been used (Arrays.sort())
     * but for the purpose of demonstration i decided to implement the sorting myself.
     * @param list the input list that will be sorted using bubble sort
     * @return a sorted list
     */
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int temp;

        for (int i = 1; i < list.size(); i++) {

            for (int j = 0; j < list.size() - i; j++) {

                if (list.get(j) > list.get(j + 1)) {

                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }

            }
        }
        return list;
    }


    /**
     * concatenates two lists of integers and converts it to a string
     * @return
     */
    public String concat(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        String res = "";

        for (int i = 0; i < mergedList.size(); i++) {
            res += mergedList.get(i).toString();
        }

        return res;
    }
}
