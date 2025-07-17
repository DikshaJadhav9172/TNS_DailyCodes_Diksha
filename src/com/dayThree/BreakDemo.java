package com.dayThree;

public class BreakDemo {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int j = i; // create a separate variable for do-while to avoid infinite loop
            do {
                if (j == 5) {
                    break;
                }
                System.out.println(j);
                break; // prevent infinite loop, run do-while once per iteration
            } while (j <= 10);
        }
    }
}
