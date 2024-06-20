package cn.effine.algorithm;

import java.util.*;

/**
 * @author effine
 * @email zhang.yafei#gzdzswy.cn
 * @date 2024-06-18 09:39
 */
public class Case2 {

    /**
     * TODO effine 研究
     * 给定一个包含10万个数的数组,我们需要计算每个数字的频率，然后找出频率较高的数字，并找到覆盖数组中80%出现次数的数字边界。
     */

    public static void main(String[] args) {
        // Step 1: 生成示例数据
        Random rand = new Random();
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1000);  // 生成0到999之间的随机数
        }

        // Step 2: 统计每个数字的出现频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: 按照频率对数字进行排序
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 4: 找出出现频率较高的数字
        System.out.println("出现频率较高的数字:");
        for (int i = 0; i < 10 && i < sortedList.size(); i++) {
            Map.Entry<Integer, Integer> entry = sortedList.get(i);
            System.out.println("数字: " + entry.getKey() + "，频率: " + entry.getValue());
        }

        // Step 5: 计算覆盖数组中80%出现次数的数字边界
        int totalCount = nums.length;
        int cumulativeCount = 0;
        Integer boundaryNumber = null;

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            cumulativeCount += entry.getValue();
            if (cumulativeCount >= 0.8 * totalCount) {
                boundaryNumber = entry.getKey();
                break;
            }
        }

        System.out.println("覆盖80%出现次数的数字边界是: " + boundaryNumber);
    }
}
