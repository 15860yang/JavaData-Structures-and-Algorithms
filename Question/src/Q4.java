/**
 * 将一个链表根据某个值来修改，使得，大于这个值的在左边，等于这个值的在中间，小于这个值的在右边
 */
public class Q4 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(8);
        Node n6 = new Node(2);
        Node n7 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        Node head = changeListByData(n1,4);
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static Node changeListByData(Node head,int data){
        if(head == null || head.next == null){
            return head;
        }
        Node more = null;
        Node less = null;
        Node equal = null;
        Node p = head;
        Node moreEnd = more;
        Node lessEnd = less;
        Node equalEnd = equal;
        while (p != null){
            if(p.data < data){
                if(less == null){
                    less = lessEnd = p;
                }else {
                    lessEnd.next = p;
                    lessEnd = p;
                }
            }else if(p.data > data){
                if(more == null){
                    more = moreEnd = p;
                }else {
                    moreEnd.next = p;
                    moreEnd = p;
                }
            }else {
                if(equal == null){
                    equal = equalEnd = p;
                }else {
                    equalEnd.next = p;
                    equalEnd = p;
                }
            }
            p = p.next;
        }
        if(more != null){
            moreEnd.next = null;
        }
        if(equal != null){
            equalEnd.next = more;
        }else {
            equal = more;
        }
        if(less != null){
            lessEnd.next = equal;
        }else {
            less = equal;
        }
        return less;
    }
}
