package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement merge sort
        mergeSort(a, 0, a.length -1, comp);
        // divide the array in half temporary

    }
    private <T> void mergeSort(T[] a, int left, int right, Comparator<? super T> comp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // recursive sort
            mergeSort(a, left, mid, comp);
            mergeSort(a, mid + 1, right, comp);
            // merge
            merge(a, left, mid, right, comp);
        }
    }
    private <T> void merge(T[] a, int left, int mid, int right, Comparator<? super T> comp) {
        int s1 = mid - left + 1;
        int s2 = right - mid;

        // temporary arrays with suppress warnings
        @SuppressWarnings("UNCHECKED")
        T[] leftArray = (T[]) new Object[s1];
        @SuppressWarnings("UNCHECKED")
        T[] rightArray = (T[]) new Object[s2];

        // copy data to temporary array
        for (int i = 0; i < s1; i++) {
            leftArray[i] = a[left + i];
        }
        for (int j = 0; j < s2; j++) {
            rightArray[j] = a[mid + 1 + j];
        }
        // merge back
        int i = 0;
        int j = 0;
        int k = left;

        while (i < s1 && j < s2) {
            if (comp.compare(leftArray[i], rightArray[j]) <= 0) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // copy remaining elements
        while (i < s1) {
            a[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < s2) {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
