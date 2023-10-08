/*
 * File: project1_part3_GavinNorris
 * Author: Gavin Norris
 * Date: October 5,2023
 * Description: This script executes the 'middle school procedure' as it is described in "Introduction to the Design and Analysis of algorithms"
 */


import java.util.Scanner;
public class project1_part3_GavinNorris{
    public static void main(String args[]){
//Main method has been created and scanner utility captures input from user and assigns variables to m and n

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        if(m == 0 && n == 0){
            System.out.println("The GCD of 0 and 0 is undefined");
            return;
        }
        else if(m == 0){
            System.out.println("The GCD of 0 and " + n + " is " + Math.abs(n));
            return;
        }
        else if(n == 0){
            System.out.println("The GCD of " + m + " and " + "0 is " + Math.abs(m));
            return;
        }
        else{
        int gcd = gcdMiddleSchool(Math.abs(m) , Math.abs(n));
        System.out.println("The GCD of " + m + " and " + n + " is " + gcd);
        }
    }

     
    // class to store factorization 
    // of m and n 
    static class FACTORIZATION{ 
    static final int MAXFACTORS = 1024;
        int size; 
        int factor[] = new int[MAXFACTORS + 1]; 
        int exponent[] = new int[MAXFACTORS + 1]; 
     
    } 


    public static void FindFactorization(int x, FACTORIZATION factorization){ 
    int i = 1;
    int j = 1; 
    int n = x;
    int c = 0; 
    int k = 1; 
    factorization.factor[0] = 1; 
    factorization.exponent[0] = 1; 
 
    for (i = 2; i <= n; i++){ 
        c = 0; 
 
        while (n % i == 0){ 
            c++; 
 
            // factorization.factor[j]=i; 
            n = n / i; 
            // j++; 
        } 
 
        if (c > 0){ 
            factorization.exponent[k] = c; 
            factorization.factor[k] = i; 
            k++; 
        } 
    } 
 
    factorization.size = k - 1; 
} 


//The middle school function is created and executes as it is defined within the book
//Factors are found for m and n
    public static int gcdMiddleSchool(int m , int n){

        FACTORIZATION mFactorization = new FACTORIZATION();
        FACTORIZATION nFactorization = new FACTORIZATION(); 
     
        int r = 1;
        int mi = 1;
        int ni = 1;
        int i = 1;
        int k = 1;
        int x = 1;
        int j; 
     
//Factors for m
        FindFactorization(m, mFactorization); 

//Factors for n
        FindFactorization(n, nFactorization); 

//GCD
        int min; 
        i = 1; 
        j = 1; 
        while (i <= mFactorization.size && j <= nFactorization.size){ 
            if(mFactorization.factor[i] < nFactorization.factor[j]){
                i++;
            }
            else if (nFactorization.factor[j] < mFactorization.factor[i]){
                j++;
            }
     
            else /* if arr1[i] == arr2[j] */
            { 
                min = mFactorization.exponent[i] > nFactorization.exponent[j] ? nFactorization.exponent[j] : mFactorization.exponent[i]; 
                x = x * mFactorization.factor[i] * min; 
                i++; 
                j++; 
            } 
        } 
     
        return x; 
    }
}