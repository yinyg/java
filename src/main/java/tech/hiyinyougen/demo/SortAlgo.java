package tech.hiyinyougen.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author yinyg
 * @CreateTime 2020/6/24 16:43
 * @Description 排序算法
 */
public class SortAlgo {
    public static void main(String[] args) {
        // 排序
        int[] arr = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        bubbleSort(arr);
//        bubbleSort2(arr);
//        insertionSort(arr);
//        selectionSort(arr);
//        shellSort(arr);
//        mergeSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        // 性能测试
        System.out.println("10000个数组，每个数组200个元素");
        int[][] array = new int[10000][200];
        for (int i = 0; i < 10000; ++i) {
            for (int j = 0; j < 200; ++j) {
                array[i][j] = new Random().nextInt(10000);
            }
        }
        int[][] array2 = Arrays.copyOf(array, 10000);
        int[][] array3 = Arrays.copyOf(array, 10000);
        int[][] array4 = Arrays.copyOf(array, 10000);
        int[][] array5 = Arrays.copyOf(array, 10000);
        long bubbleSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            bubbleSort(array[i]);
        }
        System.out.println("冒泡排序: " + (System.currentTimeMillis() - bubbleSortStartTime) + "ms");

        long insertionSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            insertionSort(array2[i]);
        }
        System.out.println("插入排序: " + (System.currentTimeMillis() - insertionSortStartTime) + "ms");

        long shellSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            insertionSort(array3[i]);
        }
        System.out.println("希尔排序: " + (System.currentTimeMillis() - shellSortStartTime) + "ms");

        long mergeSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            mergeSort(array4[i]);
        }
        System.out.println("归并排序: " + (System.currentTimeMillis() - mergeSortStartTime) + "ms");

        long quickSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; ++i) {
            quickSort(array5[i]);
        }
        System.out.println("快速排序: " + (System.currentTimeMillis() - quickSortStartTime) + "ms");
    }

    /**
     * @description 冒泡排序
     * 冒泡排序只会操作相邻的两个数据。
     * 每次冒泡操作都会对相邻的两个元素进行比较，
     * 看是否满足大小关系要求。如果不满足就让它俩互换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，
     * 重复 n 次，就完成了 n 个数据的排序工作。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 0; i < length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }

    /**
     * @description 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void bubbleSort2(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = length - 1;
        for (int i = 0; i < length; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }


    /**
     * @description 插入排序
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，
     * 在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 1; i < length; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    /**
     * @description 选择排序
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void selectionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 0; i < length - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            if (minIndex != i) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }

    /**
     * @description 希尔排序
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。
     * 这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，
     * 但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; ++i) {
                int tmp = a[i];
                int j = i - step;
                while (j >= 0 && a[j] > tmp) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = tmp;
            }
        }
    }

    /**
     * @description 归并排序
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
     * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    public static void mergeSort(int[] a) {
        mergeSortInternally(a, 0, a.length-1);
    }

    /**
     * @description 递归调用函数
     * @param a
     * @param p
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * @description 合并
     * @param a
     * @param p
     * @param q
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    /**
     * @description 合并(哨兵)
     * 当数组中存在2个以上(包括2个)Integer.MAX_VALUE时，不能使用该函数
     * @param arr
     * @param p
     * @param q
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortInternally(arr, 0, arr.length - 1);
    }

    /**
     * @description 快速排序递归函数，p,r为下标
     * @param arr
     * @param p
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/21
     */
    private static void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(arr, p, r); // 获取分区点
        quickSortInternally(arr, p, q-1);
        quickSortInternally(arr, q+1, r);
    }

    /**
     * @description 分区函数
     * @param arr
     * @param p
     * @param r
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/8/21
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;

        return i;
    }
}
