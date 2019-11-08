package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 5;
		nums[2] = 1;
		nums[3] = 9;
		nums[4] = 2;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;

				}
			}

		}
		ArrayList<Integer> aList = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			aList.add(nums[i]);
		}
//		for(int i=0; i<aList.size(); i++) {
//			for(int j=i+1; j<aList.size(); j++) {
//				if(aList.get(i)<aList.get(j)) {
//					int tempList = aList.get(i);
//					aList.set(i, aList.get(i));
//					aList.set(j, tempList);
//					
//				}
//			}
//		} System.out.println(aList);
		
		Collections.sort(aList);
		System.out.println(aList);
		
		for (int i = 0; i < nums.length; i++) {

			System.out.println(nums[i]);
		}
	}
}


