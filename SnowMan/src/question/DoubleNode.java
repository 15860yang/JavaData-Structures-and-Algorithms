package question;

public class DoubleNode {
    public DoubleNode(int val) {
        this.val = val;
    }

    public int val;
    public DoubleNode left = null;
    public DoubleNode right = null;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DoubleNode) {
            return ((DoubleNode) obj).val == this.val;
        }
        return super.equals(obj);
    }
}
