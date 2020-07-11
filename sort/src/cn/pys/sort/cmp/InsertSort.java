package cn.pys.sort.cmp;

import cn.pys.Sort;

public class InsertSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort2();
    }

    private void sort1() {
        for (int begin = 0; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }

    private void sort2() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            // 当前元素
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                // 前移
                array[cur] = array[cur - 1];
                cur--;
            }
            // 找到合适位置后，将当前元素赋值回去
            array[cur] = v;
        }
    }




}
