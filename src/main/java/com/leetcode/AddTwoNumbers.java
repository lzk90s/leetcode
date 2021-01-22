package com.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 链表组成的数字相加
 */
public class AddTwoNumbers {

    public Node m(Node a, Node b) {
        Node r = new Node(0, null);
        Node ta = a, tb = b;
        int carry = 0;
        Node tmp = r;

        while (ta != null || tb != null) {
            int x = (null == ta) ? 0 : ta.val;
            int y = (null == tb) ? 0 : tb.val;
            int z = x + y + carry;
            carry = z / 10;
            tmp.next = new Node(z % 10, null);
            tmp = tmp.next;
            ta = ta == null ? null : ta.next;
            tb = tb == null ? null : tb.next;
        }

        if (carry > 0) {
            tmp.next = new Node(carry, null);
        }
        return r.next;
    }

    @Test
    public void test() {
        Node a = new Node(2, new Node(3, new Node(4, null)));
        Node b = new Node(5, new Node(8, new Node(4, null)));

        var r = m(a, b);
        var r1 = Arrays.asList(7,1,9);
        Assert.assertEquals(r1, r.toList());
    }

    @Data
    @AllArgsConstructor
    public static class Node {
        int val;
        Node next;

        List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            Node tmp = this;
            while (tmp != null) {
                list.add(tmp.val);
                tmp = tmp.next;
            }
            return list;
        }
    }
}
