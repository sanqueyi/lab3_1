package View;

public class main {
	public static void main(String[] args){
		int[] a = {1, 2, 3, 4, 5};
		int k = 2;
		rotate(a, k);
	}
	
    public static void rotate(int[] nums, int k) {
        int current = nums[0];
        int index = 0;
        for(int i=0; i<nums.length; i++){
            int next = index + k;
            next = next % nums.length;
            int nextCurrent = nums[next];
            nums[next] = current;
            current = nextCurrent;
            index = next;
            System.out.println("index: "+index+"\tvalue: "+current);
        }
        
        for(int s: nums){
        	System.out.print(s+"\t");
        }
    }
}
