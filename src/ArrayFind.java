/**
 * 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 *
 * @author ：LightinSUi
 * @since ：2020/2/14 17:49
 */
public class ArrayFind {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        int n = 16;

        boolean result = Find(n, array);
        System.out.println(result);
    }

    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            // 判断目标数是否大于当前行的第一个数
            if (array[i].length != 0 && array[i][0] <= target &&
                    array[i][array[i].length - 1] >= target) {
                // > 如果大于则进行二分查找
                int start = 0;
                int end = array[i].length - 1;
                int mid = (end - start) / 2;
                while(end >= start){
                    if(target == array[i][mid]){
                        return true;
                    }else if(target > array[i][mid]){
                        mid = ((start = mid + 1) + end) / 2;
                    }else {
                        mid = (start + (end = mid - 1)) / 2;
                    }
                }
            }
        }

        return false;
    }
}
