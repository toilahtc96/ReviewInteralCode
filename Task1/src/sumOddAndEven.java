import java.util.Arrays;

public class sumOddAndEven {
    public static void main(String[] args) {
        int[] test1 = {5, 3, 10, 6, 11};
        int[] test2 = {20,10,7,5};
        int[] test3 = {7,13,15,13};
        int[] test4 = {2,6,4,6};
        //checkArrOnlyOddOrEven boolean
        showSumOfArr(test1);
        showSumOfArr(test2);
        showSumOfArr(test3);
        showSumOfArr(test4);


        //Sap xep mang
        //Phan tu cuoi cung + phan tu khac kieu gan nhat


    }
    private static void showSumOfArr(int[] arr){
        if (isOnlyOddOrEven(arr))
            System.out.println("0");
        else {
            System.out.println(sumLargeOddAndEven(arr));
        }
    }

    private static boolean isOnlyOddOrEven(int[] arr) {
        if (arr.length <= 0) return true;
        if (arr[0] % 2 == 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] % 2 != 0) return false;
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] % 2 == 0) return false;
            }
        }


        return true;
    }

    private static int sumLargeOddAndEven(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        sum = arr[arr.length - 1];
        if (sum % 2 == 0) {
            //+ so le gan nhat
            for (int i = arr.length - 2; i >= 0; i--) {
                if(arr[i]%2!=0){
                    sum+=arr[i];
                    break;
                }
            }
        } else {
            for (int i = arr.length - 2; i >= 0; i--) {
            }
            //+so chan gan nhat
            for (int i = arr.length - 2; i >= 0; i--) {
                if(arr[i]%2==0){
                    sum+=arr[i];
                    break;
                }
            }
        }
        return sum;
    }
}
