package cn.pys.sort.cmp;

import cn.pys.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // [begin,end) 左闭右开区间
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        T pivot = array[begin];
        // 将左闭右开的end元素指向数组最后一个元素
        end--;
        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    break;
                }

            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }

        }
        array[begin] = pivot;
        return begin;
    }
}
