package Algoritms;
//Task 116 Medium. Populating Next Right Pointers in Each Node
//Success
//Runtime: 2 ms, faster than 44.65% of Java online submissions for Populating Next Right Pointers in Each Node.
//Memory Usage: 40 MB, less than 7.28% of Java online submissions for Populating Next Right Pointers in Each Node.

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NextRightPointer {
    public Node connect(Node root) {
        if (root == null) return null;
        List<Node> currentList = new ArrayList<>();
        currentList.add(root);
        while (!currentList.isEmpty()) {
            for (int i = 0; i < currentList.size() - 1; i++) {
                currentList.get(i).next = currentList.get(i + 1);
            }
            currentList = nextList(currentList);
        }
        return root;
    }

    private List<Node> nextList(List<Node> currentList) {
        List<Node> nextList = new ArrayList<>();
        for (Node node : currentList) {
            if (node.left != null) nextList.add(node.left);
            if (node.right != null) nextList.add(node.right);
        }
        return nextList;
    }

    private Node createTestCase() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    @Test
    public void test() {
        Node root = createTestCase();
        new NextRightPointer().connect(root);
        Assert.assertTrue(root.next == null);
        Assert.assertTrue(root.left.next.val == root.right.val);
        Assert.assertTrue(root.right.next == null);
        Assert.assertTrue(root.left.left.next.val == root.left.right.val);
        Assert.assertTrue(root.left.right.next.val == root.right.left.val);
        Assert.assertTrue(root.right.left.next.val == root.right.right.val);
        Assert.assertTrue(root.right.right.next == null);
    }
}
