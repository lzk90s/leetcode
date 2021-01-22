package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class LeastNumbers {
    public int[] m(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int num : nums) {
            if (queue.size() < k || queue.peek() > num) {
                queue.add(num);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int r[] = new int[k];
        int i = 0;
        for (var q : queue) {
            r[i++] = q;
        }
        return r;
    }

    @Test
    public void test() {
        int nums[] = {3, 2, 1};
        int k = 2;
        var r = m(nums, k);
        Assert.assertEquals(r.length, 2);
        Assert.assertEquals(r[0], 2);
        Assert.assertEquals(r[1], 1);
    }
}
