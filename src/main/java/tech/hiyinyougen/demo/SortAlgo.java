package tech.hiyinyougen.demo;

/**
 * @Author yinyg
 * @CreateTime 2020/6/24 16:43
 * @Description 排序算法
 */
public class SortAlgo {
    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 4, 3, 6, 7, 1, 5};
        bubbleSort(a);
        printAll(a);
    }

    public static void printAll(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * 每次冒泡操作都会对相邻的两个元素进行比较，
     * 看是否满足大小关系要求。如果不满足就让它俩互换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，
     * 重复 n 次，就完成了 n 个数据的排序工作
     * @param a
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        // 提前退出循环标志，当某次循环没有交换，说明已经达到完全有序，不用再继续执行后续的冒泡操作
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
