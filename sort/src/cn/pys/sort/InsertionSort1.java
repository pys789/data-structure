package cn.pys.sort;

import cn.pys.SortAbstract;

public class InsertionSort1<T extends Comparable<T>> extends SortAbstract<T> {

	@Override
	protected void sort() {
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			while (cur > 0 && cmp(cur, cur - 1) < 0) {
				swap(cur, cur - 1);
				cur--;
			}
		}
	}

}
