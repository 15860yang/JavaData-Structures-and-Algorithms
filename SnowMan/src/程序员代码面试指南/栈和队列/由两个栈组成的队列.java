package 程序员代码面试指南.栈和队列;


import java.util.Stack;

/**
 * 使用两个栈实现队列
 */

public class 由两个栈组成的队列 {

    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        public void add(int num) {
            stackPush.add(num);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            } else if (!stackPush.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
