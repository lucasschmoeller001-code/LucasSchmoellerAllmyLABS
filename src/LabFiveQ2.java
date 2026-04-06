public class LabFiveQ2 {
    public static int singleNum(int[] nums) {
        int numbA = 0;
        for (int i = 0; i < nums.length; i++) {//keeps looping for length of array
            numbA = numbA ^ nums[i]; //removes duplicate numbers and leaves the numbers that only show up once
    }
        return numbA;
    }
    public static void main(String[] args){
        int[] nums = {1};
        int result = singleNum(nums); //the singleNum method created
        System.out.println(result);
    }
}