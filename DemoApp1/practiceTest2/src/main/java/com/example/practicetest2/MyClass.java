package com.example.practicetest2;

public class MyClass {
    public static void main(String[] args) {
        int n=5;
        int m=5;
        int k=0;
        for(int i=5;i>0;i--,k++){
            for(int j=0;j<5;j++){
                if(j<k)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();

        }
    }
}