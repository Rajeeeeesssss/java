

public class MaxMinArray {
    public static void main(String[] args) {
        int[] arr = {10,11,12,13,14,15,1};
        int Max = arr[0];
        int Min = arr[0];
        for (int i=0; i<arr.length;i++){
            if (arr[i]> Max){
            Max = arr[i];
            }
            
            if (arr[i]<Min){
            Min =arr[i];
            }
        }
        System.out.println("Max:"+Max);
        System.out.println("Min:"+Min);
        
    }
}
