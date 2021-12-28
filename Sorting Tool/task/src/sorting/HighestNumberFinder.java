package sorting;

import java.util.*;

public class HighestNumberFinder extends Finder<Long> {
    private Long highestNumber;

    public HighestNumberFinder(ArrayList<Long> listOfItems) {
        super(listOfItems);
    }

    @Override
    public int howManyTimeOccurred() {
        int counter = 0;
        for (Long l : listOfItems
        ) {
            if (l.equals(this.highestNumber)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String displayInfo() {
        return String.format("Total numbers: %d." +
                        "\nThe greatest number: %d (%d time(s), %d%%)."
                , listOfItems.size()
                , highestNumber
                , howManyTimeOccurred()
                , getPercentage());
    }

    public void displayInfo(boolean displaySortedInfo) {
        System.out.print("Sorted data: ");
        for (Long l : listOfItems
        ) {
            System.out.print(l + " ");
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.listOfItems);
    }

    @Override
    public void scanAndAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            super.listOfItems.add(number);
        }
    }

    @Override
    public Long findHighestValue() {
        Long highestNumber = listOfItems.get(0);
        for (Long l : listOfItems) {
            if (l > highestNumber) {
                highestNumber = l;
            }
        }
        this.highestNumber = highestNumber;
        return highestNumber;
    }

    public void sort(String typeOfSort) {
        if (typeOfSort.equalsIgnoreCase("insertion")) {
            for (int i = 1; i < listOfItems.size(); i++) {
                long currentValue = listOfItems.get(i);
                int j = i - 1;
                while (j >= 0 && listOfItems.get(j) > currentValue) {
                    listOfItems.set(j + 1, listOfItems.get(j));
                    j--;
                }
                listOfItems.set(j + 1, currentValue);
            }
        } else if (typeOfSort.equalsIgnoreCase("mergesort")) {
            long[] array = new long[listOfItems.size()];

            for (int i = 0; i < listOfItems.size(); i++) {
                array[i] = listOfItems.get(i);
            }
            mergeSort(array);
            int x = 0;
            for (long l : array
                 ) {
                listOfItems.set(x,l);
                x++;
            }
        } else {
            sort();
        }
    }

    private void mergeSort(long[] array) {
        int listSize = array.length;
        if (listSize < 2) {
            return;
        }
        int middleIndex = listSize / 2;

        long[] leftArray = new long[middleIndex];
        long[] rightArray = new long[listSize - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middleIndex; i < listSize; i++) {
            rightArray[i - middleIndex] = array[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);
    }

    private void merge(long[] original, long[] leftArray, long[] rightArray) {
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int i = 0, j = 0, k = 0;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                original[k] = leftArray[i];
                i++;
            } else {
                original[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArraySize) {
            original[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArraySize) {
            original[k] = rightArray[j];
            j++;
            k++;
        }
    }
}