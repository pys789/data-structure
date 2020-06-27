package cn.pys;

import cn.pys.sort.HeapSort;
import cn.pys.tools.Asserts;
import cn.pys.tools.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {7, 3, 5, 8, 6, 1};

        testSorts(array,
                new HeapSort()
        );
    }

    static void testSorts(Integer[] array, SortAbstract... sorts) {
        for (SortAbstract sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (SortAbstract sort : sorts) {
            System.out.println(sort);
        }
    }
}
