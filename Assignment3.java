package Test;

/**
* Created by Rose on 1/27/17.
* Assignment for your lecture 3. Please finish all the questions under
* 'Assignment'. Please try to think the extra credit questions. The deadline
* of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
* for any questions. Please write your comments about this assignment in the
* end.
*/


public class Assignment3 {
/**
* Given an array, reverse the elements within this array and print the result
* eg, given{1,2,3,4}, print{4,3,2,1}
*/
public void reverseArray(int[] nums) {
	for(int i=0;i<nums.length;i++)
	{
		System.out.println(nums[i]);
	}
	System.out.println("reversed array = ");
	for(int i=nums.length-1;i>=0;i--)
	{
		System.out.println(nums[i]);
	}
}

/**
* Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
* Assume the integer do not contain any leading zero, except the number 0 itself.
* The digits are stored such that the most significant digit is at the head of the array.
* eg, given {1,2,9}, reutrn{1,3,0}.
*/
public void plusOne(int[] digits) {
	boolean flag = false;
	for(int i = 0; i<digits.length; i++)
	{
		if((digits[i] + 1) == 10)
		{
			digits[i] = 0;
			if(i == digits.length-1)
			{
				flag = true;
			}
		}
		else
		{
			digits[i] = digits[i] + 1;
			break;
		}
	}
	for(int i =digits.length- 1; i>= 0; i--)
	{
		if( i == digits.length-1)
		{
			if(flag == true)
			{
				System.out.println(1);
				System.out.println(digits[i]);
			}
			else
			{
				System.out.println(digits[i]);
			}
		}
		else
		{
			System.out.println(digits[i]);
		} 
		
	}
}

/**
* Write a program that takes an integer as input and returns all the primes between 1 and that integer(inclusive).
* eg, input is 18, you should return{2,3,5,7,11,13,17}
*/
public int[] generatePrimes(int n) {
	int[] output_array = new int[n];
	int count = 0;
	for(int i=2;i<=n;i++)
	{
		boolean flag=false;
		for(int j=2;j<i;j++)
		{
			if(i%j==0)
			{
				flag=true;
				break;
			}		
		}
		if(flag==false)
		{
			output_array[count] = i;
			count++;
		}
	}
	return output_array;
}

/**
* Assume you have a method isSubstring which checks if one word is a substring of another.
* Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
* to isSubstring
* eg, "pineapple" is a rotation of "neapplepi"
*/
public boolean isRotation(String s1, String s2) {
	boolean flag = false;
	for(int i = 0; i<s1.length(); i++)
	{
		String first_Letter = s1.substring(0,1);
		s1 = s1.substring(1)+first_Letter;
		if(s1.equals(s2))
		{
			return true;
		}
	}
	if(flag == false)
	{
		return false;
	}
	return true;
}

/**
* Given two strings, write a method to decide if one is a permutation of the other
* hint: the comparison is case sensitive and whitespace is significant
*/
public boolean isPermutation(String s1, String s2) {
	if(s1.length() == s2.length())
	{
		char[] s1_Array = new char[s1.length()];
		char[] s2_Array = new char[s2.length()];
		for(int i = 0; i<s1.length(); i++)
		{
			s1_Array[i] = s1.charAt(i);
		}
		for(int i = 0; i<s2.length(); i++)
		{
			s2_Array[i] = s2.charAt(i);
		}
	
		for(int i = 0; i<s1_Array.length; i++)
		{
			for(int j = 0; j<i+1; j++)
			{
				if(s1_Array[i]< s1_Array[j])
				{
					char temp = s1_Array[i];
					s1_Array[i] = s1_Array[j];
					s1_Array[j] = temp;
				}
			}
		}
		for(int i = 0; i<s2_Array.length; i++)
		{
			for(int j = 0; j<i+1; j++)
			{
				if(s2_Array[i]< s2_Array[j])
				{
					char temp = s2_Array[i];
					s2_Array[i] = s2_Array[j];
					s2_Array[j] = temp;
				}
			}
		}
		for(int i = 0; i<s1_Array.length; i++)
		{
			if(s1_Array[i] != s2_Array[i] )
			{
				return false;
			}
		}
		return true;
	}
	else
	{
		return false;
	}
	
}

/**
* Write a program to implement encoding and decoding string. The rule is simple: encode successive
* repeated characters by the repetition count and the character. For example, the input of encoding()
* is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
* the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
* decoded is a valid encoding.
*/
public static String encoding(String s) {
	String newName = "";
	for(int i=0;i<s.length();i++)
	{
		if((i+1)==s.length())
		{
			String name5=s.substring(i,i+1);
			newName=newName+1+name5;
			
		}
		else if((i+2)==s.length())
		{
			String name3=s.substring(i,i+1);
			String name4=s.substring(i+1,i+2);
			if(name3.equals(name4))
			{
		    newName=newName+2+name3;
			}
			else
			{
				newName=newName+1+name3+1+name4;	
			}
				
			
			break;
		}
		else
		{
			String name1=s.substring(i,i+1);
			String name2=s.substring(i+1,i+2);
		
		
			int counter=1;
			while(name1.equals(name2))
			{
				i = i+1;
				if((s.length()-1) == i)
				{
					counter=counter+1;
					break;
				}
				else
				{
					counter=counter+1;
					name1=s.substring(i,i+1);
					if((s.length()-2) == i)
					{
						name2 = s.substring(i+1);
					}
					else
					{
						name2=s.substring(i+1,i+2);
					}
				}	
			}
			newName=newName+counter+name1;
		}
		
	}
	return newName;
}
public static String decoding(String s) {
	String newName = "";
	for(int i=0;i<s.length();i++)
	{
		String name1=s.substring(i, i+1);
		String name2=s.substring(i+1,i+2);
		int a =Integer.parseInt(name1);
		for(int j=1;j<=a;j++)
		{
			newName = newName + name2;
		}
		i++;
	}
	return newName;
}

//Extra Credit
/**
*Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
* For exmaple, given 1 2 3 , return 7 4 1
* 4 5,6 8 5 2
* 7,8,9 9 6 3
*tip: image could be a square or a rectangle.
*/
public static int[][] rotate(int[][] matrix) {
	int temp;
	for(int i = 0; i<matrix.length; i++)
	{
		for(int j = 0; j<matrix[i].length; j++)
		{
			if(j>i)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	for(int i = 0; i<matrix.length; i++)
	{
		for(int j = 0; j<matrix[i].length; j++)
		{
			if(j<=matrix.length/2)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length -1 - j];
				matrix[i][matrix[i].length -1  - j]= temp;
			}
		}
	}
	return matrix;
}

/**
*Given a string containing just the characters '(', ')', return the count of valid parentheses. If the
* intput is not valid, return -1. A valid parentheses is "()". For example, given "(())", return 2;
* given "(()))", return -1.
*/
public int countValidParentheses(String s) {
	
		int left_Parenthesis_Count = 0;
		int right_Parenthesis_Count = 0;
		String left_Parenthesis = new String("(");
		String right_Parenthesis = new String(")");
		//System.out.println(left_Parenthesis);
		//System.out.println(right_Parenthesis);
		for(int i = 0; i<s.length(); i++)
		{
			if((s.substring(i,i+1)).equals(left_Parenthesis))
			{
				left_Parenthesis_Count++;
			}
			else if((s.substring(i,i+1)).equals(right_Parenthesis))
			{
				right_Parenthesis_Count++;
			}
		}
		if(left_Parenthesis_Count == right_Parenthesis_Count)
		{
			return(left_Parenthesis_Count);
		}
		else if(left_Parenthesis_Count > right_Parenthesis_Count)
		{
			return(right_Parenthesis_Count);
		}
		else
		{
			return(left_Parenthesis_Count);
		}
	}
}
/**
* Write anything you think about this assignment here. Easy? Difficult? Too many questions? Less fun?
* You could write any comments here
*/

