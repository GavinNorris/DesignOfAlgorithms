/*
 * File: project1_part2_GavinNorris.java
 * Author: Gavin Norris
 * Date: October 4, 2023
 * Description: This script executes the consecutive Integer Checking algorithm function as it is described and outlined in "Introduction to the Design and Analysis of Algorithms"
 */


import java.util.Scanner;
public class project1_part2_GavinNorris{
    public static void main(String args[]){

// main method and class established, input from console being read for m and n

	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter two numbers: ");
	int m = scanner.nextInt();
	int n = scanner.nextInt();

    if(m == 0 && n == 0){
        System.out.println("The GCD of 0 and 0 is undefined");
        return;
    }

//The function is called and the output is printed to terminal

    int gcd = cic(Math.abs(m), Math.abs(n));
    System.out.println("The GCD of " + m + " and " + n + " is " + gcd);
}

//Consecutive Integer checking (cic) algorithm function is created and executes as outlined in the textbook
//Smallest integer is selected and proper incrementation is applied


    public static int cic(int m, int n){

        int t = Math.min(m,n);
        int gcd = 1;

            if(t == 0){
                return Math.max(m,n);
            }
            else{
                while(t > 0){
                    if(m % t == 0){
                        if(n % t ==0){
                            gcd = t;
                            break;
                        }
                    }
                    t--;
                }
                return gcd;
            }

        }
}