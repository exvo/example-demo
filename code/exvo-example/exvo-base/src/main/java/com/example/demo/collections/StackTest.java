package com.example.demo.collections;

import java.util.Stack;

/**
 * User: wu yang
 * Time: 2018/11/8
 * Description:栈  后进先出
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stringStack = init(5);
        System.out.println(stringStack);
        pop(stringStack);
        System.out.println(stringStack);
        peek(stringStack);
        System.out.println(stringStack);
    }

    public static Stack<String> init(int size) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < size; i++) {
            push(stringStack, "A00" + i);
        }
        return stringStack;
    }

    /**
     * 移除当前栈中最上面的数据并返回
     * @param stringStack
     */
    public static void pop(Stack<String> stringStack) {
        System.out.println("pop()  ----" + "    " + stringStack.pop());
    }

    /**
     * 向栈中添加数据
     *
     * @param stringStack
     * @param value
     */
    public static void push(Stack<String> stringStack, String value) {
        stringStack.push(value);
    }

    /**
     * 返回当前栈中最上面的数据
     * @param stringStack
     */
    public static void peek(Stack<String> stringStack) {
        System.out.println("peek()  ----" + "    " + stringStack.peek());
    }


}
