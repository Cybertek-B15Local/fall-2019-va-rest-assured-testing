package com.cbt.tests.office_hours;

public class Calculator {

    public static void addVoid(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
    }


    public static int add(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }


    public static double multiply(double num1, double num2) {
        double result = num1 * num2;
        return result;
    }

    public static double minus(double num1, double num2) {
        double result = num1 - num2;
        return result;
    }

    public static double divide(double num1, double num2) {
        if(num2 == 0) {
            System.out.println("ERROR: Cannot / by 0");
            return 0;
        }else {
            double result = num1 / num2;
            return result;
        }
    }

}
