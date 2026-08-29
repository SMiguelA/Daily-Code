package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = null;
        List<Integer> values = new ArrayList<>(List.of(6, 4, 8, 1, 5, 9));

        for(int i = 0; i < values.size(); i++){
            root = sortBinaryTree(root, values.get(i));
        }
        System.out.println("Inorder binary tree: ");
        inorder(root);
        System.out.println("Preorder binary tree: ");
        preorder(root);
        System.out.println("Postorder binary tree: ");
        postorder(root);
    }

    public static Node sortBinaryTree(Node node, int value){
        if(node == null) return new Node(value);

        if(value < node.getValue()) node.setLeft(sortBinaryTree(node.getLeft(), value));
        else if(value > node.getValue()) node.setRight(sortBinaryTree(node.getRight(), value));

        return node;
    }

    // Left - Center - Right
    public static void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.getLeft());
        System.out.println(node.getValue());
        inorder(node.getRight());
    }

    // Root - Left - Right
    public static void preorder(Node node){
        if(node == null) return;

        System.out.println(node.getValue());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    //Left - Right - Root
    public static void postorder(Node node){
        if(node == null) return;
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getValue());
    }
}

