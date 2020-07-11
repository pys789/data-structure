package cn.pys.sort.cmp;

import cn.pys.Sort;

public class BullbeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort2();
    }

    private void sort1(){
        // 从后往前遍历，end指针后面的已排序，end前面的未排序
        for (int end = array.length - 1; end > 0; end--) {
            // 2比较相邻两个元素
            for (int begin = 0; begin < end; begin++) {
                if (cmp(begin, begin + 1) > 0) {
                    swap(begin, begin + 1);
                }
            }
        }
    }

    private void sort2(){
        // 从后往前遍历，end指针后面的已排序，end前面的未排序
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 0;
            // 比较相邻两个元素
            for (int begin = 0; begin < end; begin++) {
                if (cmp(begin, begin + 1) > 0) {
                    swap(begin, begin + 1);
                    sortedIndex = begin + 1;
                }
            }
            end = sortedIndex;
        }
    }


}
