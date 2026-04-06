public class LabFiveQ1 {
    public static int[] findsum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { //keeps looping while length is less than the array size, finds first value in array for target number
            for (int t = i + 1; t < nums.length; t++) {//another loop that finds the second value in the array
                if (nums[i] + nums[t] == target) {
                    return new int[]{i, t}; // will return the values corresponding with the array value
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] answer = findsum(nums, target); //the findsum method
        System.out.println("[" + answer[0] + "," + answer[1] + "]");
    }
}