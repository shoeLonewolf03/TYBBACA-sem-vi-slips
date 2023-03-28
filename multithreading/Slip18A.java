import java.util.Scanner;

public class Slip18A {
  
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = scanner.nextInt();
    
    int factorial = 1;
    
    for(int i = 1; i <= num; i++) {
      factorial *= i;
      try {
        Thread.sleep(1000); // delay for 1 second
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println("Factorial of " + num + " is: " + factorial);
    
    scanner.close();
    
  }

}

