/**
 * Created by Rose on 1/21/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews.Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */


public class Employee
{
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) 
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

enum Gender {
    MALE,
    FEMALE;
}



public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) 
    {
    	
    		if (employee.salary <= 8900)
    		{
    			return (0.062*employee.salary);
    		}
    		else
    		{
    			return (0.062*106800);
    		}
    }

    

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) 
    {
    	if ((employee.age <= 35))
        {
        	return (employee.salary*0.03);
        }
        else if ((employee.age >= 35) &&(employee.age <= 50))
        {
        	return (employee.salary*0.04);
        }
        else if((employee.age >= 50) &&(employee.age <= 60))
        {
        	return (employee.salary*0.05);
        }
        else
        {
        	return (employee.salary*0.06);
        }
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) 
    {
    	if (e1.salary > e2.salary)
        {
        	if (e1.salary > e3.salary)
        	{
        		if (e2.salary > e3.salary)
        		{
        			System.out.println(e3.name+ "<" + e2.name+ "<" + e1.name);
        		}
        		else
        		{
        			System.out.println(e2.name+ "<" + e3.name+ "<" + e1.name);
        		}
        	}
        	else
        	{
        		System.out.println(e2.name+ "<" + e1.name+ "<" + e3.name);
        	}
        }
        else
        {
        	if (e2.salary > e3.salary)
        	{
        		if (e1.salary > e3.salary)
        		{
        			System.out.println(e3.name+ "<" + e1.name+ "<" + e2.name);
        		}
        		else
        		{
        			System.out.println(e1.name+ "<" + e3.name+ "<" + e2.name);
        		}
        	}
        	else
        	{
        		System.out.println(e1.name+ "<" + e2.name+ "<" + e3.name);
        	}
        }
   
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) 
    {
        employee.raiseSalary(300); 
    }
    
    public void raiseSalary(double byPercent)
    {
    	
    	salary = ((salary*byPercent)/100);
    }

    //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) 
    {
    	 for(int i = 2; i<=(n/2); i++)
         {
         	if(n%i == 0)
         	{
         		return false;
         	}
         }
         return true;
    }

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n)
    {
    	int initial_sum = 0;
        int digit ;
        
        while(n>0)
        {
        	digit = n%10;
        	initial_sum = initial_sum+ digit;
        	n = n/10;
        }
        
        int secondary_sum;
        boolean flag = true;
        while(flag)
        {
        	secondary_sum = initial_sum;
        	initial_sum = 0;
        	while(secondary_sum/10 != 0)
        	{
        		digit = secondary_sum%10;
        		initial_sum = initial_sum+ digit;
        		secondary_sum = secondary_sum/10;
        		if(secondary_sum /10 == 0)
        		{
        			initial_sum = initial_sum + (secondary_sum%10);
        		}
        	}
        	if(initial_sum/10 == 0)
        	{
        		flag = false;
        	}
        }
        
        
        return initial_sum;  
    }
      
     }
    

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {
    	if(n == 1)
		{
			return true;
		}
		else
		{
			while (n >= 5)
			{
				if(n%2 == 0)
				{
					n = n/2;
				}
				else if(n%3 == 0)
				{
					n = n/3;
				}
				else if( n%5 == 0)
				{
					n = n/5;
				}
				else
				{
					return false;
				}
			}
			return true;
		}
	
	
}
    

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
    Java is pass by value not pass by reference.
     Objects stores the reference of the values and not values exactly, that is why we can't swap objects. 
     However we can swap values in java.
    */

    public static void main(String[] args) 
    {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) 
    {
        Employee temp = x;
        x = y;
        y = temp;
    }
}




