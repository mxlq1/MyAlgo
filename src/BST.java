public class BST {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(new int[]{2, 1, 0});
        System.out.println(tree.root.val + " "  + tree.root.left.val + " " + tree.root.left.left.val);
        System.out.println(tree.search(1, tree.root));
        System.out.println(tree.search(3, tree.root));
    }


}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }


}

class BinarySearchTree{
    Node root;

    public BinarySearchTree(int[] nums){
        root = new Node(nums[0]);

        for (int i = 1; i < nums.length; i++){
            this.add(nums[i], root);
        }
    }

    public void add(int num, Node current_node) {

        if (num > current_node.val){
            if (current_node.right == null){
                current_node.right = new Node(num);
            }
            else{
                add(num, current_node.right);
            }
        }
        else{
            if (current_node.left == null){
                current_node.left = new Node(num);
            }
            else{
                add(num, current_node.left);
            }
        }
    }

    public boolean search(int val, Node current_node){
        if (current_node == null){
            return false;
        }
        else if (val == current_node.val){
            return true;
        }
        else if(val > current_node.val){
            return search(val, current_node.right);
        }
        else {
            return search(val, current_node.left);
        }
    }
}
