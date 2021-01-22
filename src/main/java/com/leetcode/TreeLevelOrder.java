package com.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelOrder {

    List<List<Integer>> m(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        LinkedList<TreeNode> fifo = new LinkedList<>();
        fifo.add(root);

        while (!fifo.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int levelSize = fifo.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmpNode = fifo.poll();
                level.add(tmpNode.val);

                if (tmpNode.left != null) {
                    fifo.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    fifo.add(tmpNode.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    @Test
    public void test() {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        var r = m(node1);
        var r1 = Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7));
        Assert.assertEquals(r, r1);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}
