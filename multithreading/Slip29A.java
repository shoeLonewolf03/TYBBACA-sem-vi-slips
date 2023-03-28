/*Display all the odd numbers between 1 to n.
Display all the prime numbers between 1 to n.*/
import java.util.Scanner;
class OddNumbers extends Thread {
    private int n;

    public OddNumbers(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i += 2) {       //since adding 2 to every odd number gives another odd number.....
            System.out.print(i + " ");
        }
    }
}

class PrimeNumbers extends Thread {
    private int n;

    public PrimeNumbers(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 2; i <= n; i++) {          //check if prime or not
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}

public class Slip29A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();

        Thread oddThread = new OddNumbers(n);               //pass the value of n to the threads
        Thread primeThread = new PrimeNumbers(n);

        oddThread.start();                                  //execute the threads
        primeThread.start();
        sc.close();                                        //get rid of the scary warning
    }
}
