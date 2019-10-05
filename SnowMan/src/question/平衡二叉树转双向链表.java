package question;


public class 平衡二叉树转双向链表 {

    public void tranceTreeToList(DoubleNode root) {
        if(root == null){
            return;
        }
        root.left = tranceLeft(root, root.left);
        root.right = tranceRight(root, root.right);
    }

    private DoubleNode tranceRight(DoubleNode root, DoubleNode right) {
        if(right == null){



            
        }


return null;


    }

    private DoubleNode tranceLeft(DoubleNode root, DoubleNode left) {
        /**
         * 代码思路：给我你的根节点和你的左节点，我会让你的左节点成链表之后你的左节点的最右指向你的根，
         *          如果你的左节点为null，那么我给你也返回null，表示你的指向的左为null。
         */
        if(left == null){
            return null;
        }else {
            tranceRight(left,left.right);
            tranceLeft(left,left.left);
            DoubleNode node = left;
            while (node.right != null){
                node = node.right;
            }
            node.right = root;
            return node;
        }
    }
}