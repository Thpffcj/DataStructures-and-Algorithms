package dataStructures.heap;

/**
 * Created by Thpffcj on 2017/10/13.
 */

// 最大索引堆
public class IndexMaxHeap<Item extends Comparable> {

    private Item[] data;  // 最大索引堆中的数据
    private int[] indexes;  // 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    private int[] reverse;  // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    private int count;
    private int capacity;
}
