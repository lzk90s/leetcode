package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public Node m(Node a, Node b) {
        Node r = new Node(0);
        Node ta = a, tb = b;
        int carry = 0;
        Node tmp = r;

        while (ta != null || tb != null) {
            int x = (null == ta) ? 0 : ta.val;
            int y = (null == tb) ? 0 : tb.val;
            int z = x + y + carry;
            carry = z / 10;
            tmp.next = new Node(z % 10);
            tmp = tmp.next;
            ta = ta == null ? null : ta.next;
            tb = tb == null ? null : tb.next;
        }

        if (carry > 0) {
            tmp.next = new Node(carry);
        }
        return r.next;
    }

    @Test
    public void test() {
        Node a = new Node(-1);
        Node b = new Node(-1);
        int[] a1 = {2, 4, 3};
        int[] b1 = {5, 6, 4};

        Node t = a;
        for (var i : a1) {
            t.setNext(new Node(i));
            t = t.getNext();
        }
        t = b;
        for (var i : b1) {
            t.setNext(new Node(i));
            t = t.getNext();
        }

        var r = m(a.next, b.next);
        var r1 = Arrays.asList(7,0,8);
        Assert.assertEquals(r1, r.toList());
    }

    public static class Node {
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
            this.next = null;
        }

        public int getVal(){
            return this.val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

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
