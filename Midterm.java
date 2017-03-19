package MidTerm;
import java.util.*;

public class Midterm {
	        public static void reverse(ArrayList<Integer> list) {
			int temp=list.size();
			for (int i=temp-1;i>=0;i--) {
				list.add(list.get(i));
			}
			for(int i=0;i<temp;i++){
				list.remove(0);
			}
			for (Integer i : list) {
				System.out.println(i);
			}
		}
		
		public static String generateStrings(String string1,String string2){
			Set<String> sts=new TreeSet<String>();
			for(int i=0;i<string1.length();i++){
				for(int j=0;j<string2.length();j++){
					String st=String.valueOf(string1.charAt(i)+String.valueOf(string2.charAt(j)));
					sts.add(st);
				}
			}
			String st="";
			for (String string : sts) {
				st+=string+" ";
			}
			return st;
		}
		
		public static int singelNumber(int[] nums) {
			int result = 0;
			for (int a : nums)
			    result ^= a;
			return result;
		}
		
		public int[] twoSum(int[] nums,int target){
       HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
       int[] returnnums = new int[2];
       for(int i=0;i<nums.length;i++){
       if(hm.containsKey(target-nums[i])){
    	   returnnums[0] = hm.get(target-nums[i]);
           returnnums[1] = i;
           return returnnums;
       }
       else{
       hm.put(nums[i],i);
       }
       }
       return returnnums;
       }
		
			public static List<Integer> getRow(int rowIndex){
            int[][] array = new int[rowIndex+1][rowIndex+1];
            for(int i = 0; i< rowIndex+1; i++){
            for(int j =0; j<i+1; j++){
            if(i == 0){
            array[i][j] = 1;
       }
       else{
       if(j == 0){
       array[i][j] = array[i-1][j];
       }
       else if(j == i)
       {
       array[i][j] = array[i-1][j - 1];
       }
       else
       {
       array[i][j] = array[i-1][j-1]+array[i-1][j];
       }
       }
       }
       }
       ArrayList<Integer> al = new ArrayList<Integer>();
       for(int j =0; j<rowIndex+1; j++){
        al.add(array[rowIndex][j]);
       }
       return al;
       }
		public static void main(String[] arg) {
			ArrayList<Integer> ls=new ArrayList<Integer>();
			ls.add(5);
			ls.add(1);
			ls.add(2);
			ls.add(3);
			Midterm.reverse(ls);
			System.out.println(Midterm.generateStrings("ABCD", "EFGH"));
			int[] x={2,2,4,5,4,1,1};
			System.out.println(Midterm.singelNumber(x));
			ls=new ArrayList<>();
			Midterm t=new Midterm();
			ls.add(t.twoSum(x, 9)[0]);
			ls.add(t.twoSum(x, 9)[1]);
			System.out.println(ls);
			System.out.println(getRow(3));
		}
	}


