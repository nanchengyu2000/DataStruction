package ToolTest;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s="asd";
        int arr[]={1,2,3,5,7,9,10,20,21};
        for (int i = 0; i < arr.length; i++) {
            continue;
        }
        System.out.println(findLeftmostPosition(arr, 4));
    }
    public static int findLeftmostPosition(int arr[],int target){
        int left=0;
        int right= arr.length-1;
        int mid=-1;
        while (left<right){
            mid=left+(right-left)/2;
            if (arr[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
