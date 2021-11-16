package com.yaohua.structure;

public class BinarySearchTree {
    private Node tree;

    public BinarySearchTree(){
    }

    private static class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data =data;
        }
    }

    public Node find(int data){
        Node p = tree;
        while(p!=null){
            if(p.data>data){
                p = p.right;
            }else if(p.data<data){
                p = p.left;
            }else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data){
        if(tree==null){
            tree = new Node(data);
        }
        Node p = tree;
        while(p!=null){
            if(p.data>data){
                if(p.left==null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else if(p.data<data){
                if(p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void delete(int data){

    }
}
