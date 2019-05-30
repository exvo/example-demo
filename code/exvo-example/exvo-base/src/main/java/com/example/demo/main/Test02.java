package com.example.demo.main;

/**
 * @Date: 2019/4/12
 * @Author: wu yang
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        int[] num = {1,2,2,3,4,5,6,7,8,9};
        int sum = 7;
        findSum(num,sum);
    }

    public static void findSum(int[] num,int sum){
        int left=0;
        int right=0;

        for(int i=0;i<num.length;i++){
            int curSum = 0;
            left = i;
            right = i;
            while(curSum<sum){
                curSum += num[right++];
            }
            if(curSum==sum){
                for(int j=left;j<right;j++){
                    System.out.print(num[j]+" ");
                }
                System.out.println();
            }
        }
    }


}
