package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {

    Node reverseListByInsert(Node node) {
        Node result = new Node(-1);
        while (node != null) {
            var tmpNode = node.getNext();
            node.next = result.next;
            result.next = node;
            node = tmpNode;
        }
        return result.next;
    }

    Node reverseListByLocal(Node node) {
        return null;
    }

    @Test
    public void test() {
        Node node = new Node(0);
        node.setNext(new Node(1));
        node.getNext().setNext(new Node(2));
        node.getNext().getNext().setNext(new Node(3));

        var r = reverseListByInsert(node);
        List<Integer> r1 = Arrays.asList(3, 2, 1, 0);
        Assert.assertEquals(r1, r.toList());
    }


    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        int getVal() {
            return this.val;
        }

        public void setVal(int val) {
            this.val = val;
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
                list.add(tmp.getVal());
                tmp = tmp.next;
            }
            return list;
        }
    }
}
