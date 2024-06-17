package cn.effine.algorithm;

/**
 * @author effine
 * @email zhang.yafei#gzdzswy.cn
 * @date 2024-06-17 16:02
 */
public class Case1 {

    /**
     * TODO effine 理解其中的含义
     *
     * 围着坐一圈人数数，数到3的人退出，下一个重新开始；输出最后留下的人的位置（数组中的位置）
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int zeroNum = 0;
        int clearNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                clearNum++;
            } else {
                zeroNum++;
            }

            if (zeroNum == arr.length - 2) {
                System.err.println("最后一个人的位置：" + i);
                break;
            }

            if (clearNum == 3) {
                arr[i] = 0;
                clearNum = 0;
                zeroNum = 0;
            }

            if (i == arr.length - 1) {
                i = -1;
            }
        }
    }
}
