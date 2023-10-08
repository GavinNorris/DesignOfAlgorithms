/*
* File: project1_part1_GavinNorris.java
* Author: Gavin Norris
* Date: October 4, 2023
* Description: This script executes the extended euclidean algorithm as outlined in "The Art of Computer Programming vol.1"
*/


import java.util.Scanner;
public class project1_part1_GavinNorris{

// main method and class established, input from console being read for m and n, and gcdExtended function being called with parameters m and n
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
//Variables m and n store input from the user and are then checked for the possibility of both being 0. Then they are passed to 'gcdExtended'
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		if(m == 0 && n == 0){
			System.out.print("The GCD of 0 and 0 is undefined");
			return;
		}

//Variable ans stores the answer of calling gcdExtended for values m and n. System.out.println then prints out the solution

	int[] ans = gcdExtended(Math.abs(m), Math.abs(n));
	System.out.print("Using Extended Euclidean Algorithm, the GCD of " + m + " and " + n + " becomes: " + ans[1] + " * " + m + " " + ans[2] + " * " + n + " = " + ans[0]);
	}


//Extended Euclidean Algorithm based off of "The Art of Computer Programming vol.1" = reference material for textbook and adapted
    public static int[] gcdExtended(int a, int b){
//Variables x, y, u, and v are outlined in "The Art of Computer Programming vol.1" as variables responsible for storing values neccessary for computation of the gcd and coeffiencts of the given input to allow for the equation mx + ny = gcd. They are initialized to default values
		int x = 0;
		int y = 1;
		int u = 1;
		int v = 0;

//Varriables for m, n, and their coeffiecients are assigned and given default values
//While loop tests for default values and completes the 'meat' of the extended euclidean algorithm as outlined in reference text, which is essentially the basic euclidean backwards
		while (a != 0){
			int q = b / a;
    		int r = b % a;
    		int z = x - u * q;
			int i = y - v * q;
    		b = a;
    		a = r;
    		x = u;
    		y = v;
    		u = z;
    		v = i;
		}

	int gcd = b;

//Java only supports single variable return, so a list is created and referenced in the call in order to allow for multiple

	int[] ans = new int[3];
		ans[0] = gcd;
		ans[1] = x;
		ans[2] = y;
	return ans;
    }
}

//Standard input: success
//Zero input: conditional success - double zero fail
	//added 'if' statement to catch conditional a and b == 0 with a list consisting of 0 for all but the gcd element, which is undefined
		//'undefined' is not int
			//moved 'if' statement to after user input - success
//integer input: fail for negative input
	// Math.abs() added when calling parameter - success