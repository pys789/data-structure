package cn.pys;

import cn.pys.sort.CountingSort;
import cn.pys.sort.RadixSort;
import cn.pys.tools.Asserts;
import cn.pys.tools.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(20, 1, 50);
        Integers.println(array);

        testSorts(array,
                //new BullbeSort(),
                //new QuickSort(),
                //new InsertSort(),
                //new SelectionSort(),
                //new HeapSort(),
                //new MergeSort()
                new CountingSort(),
                new RadixSort()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Integers.println(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }


        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
