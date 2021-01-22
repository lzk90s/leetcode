package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * TOP k算法
 * 小堆顶
 */
public class FindKthLargest {
    public int m(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k || queue.peek() < num) {
                queue.offer(num);
            }

            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.peek();
    }

    @Test
    public void doTest(){
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        Assert.assertEquals(5, m(nums, k));
    }
}
