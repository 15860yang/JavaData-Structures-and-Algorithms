package 程序员代码面试指南.栈和队列;


import java.util.Stack;

/**
 * 实现一个特殊的栈   在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */

public class Q1 {

    static class Solution1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Solution1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= getMin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            int value = getMin();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        private int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    static class Solution2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Solution2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (num < getMin()) {
                this.stackMin.push(num);
            } else stackMin.push(stackMin.peek());
            stackData.push(num);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        private int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return stackMin.peek();
        }
    }

}
