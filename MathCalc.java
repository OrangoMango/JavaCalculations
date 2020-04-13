import java.util.Random;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner sn = new Scanner(System.in);
		
		int correct = 0, error = 0, operation=0;
		System.out.print("Enter number of operations: ");
		
		try {
	   	operation = sn.nextInt();
		}
		catch (Exception e){
			System.out.println("Invalid input");
			System.exit(0);
		}
		
		long time1 = System.currentTimeMillis();
		int times = 1;
		for (times=1; times<=operation; times++){
			System.out.println("---------------");
			System.out.println(String.format("Operation: %d", times));
			int a = rnd.nextInt(10);
			int b = rnd.nextInt(10);
		
			String output = String.format("%d + %d = ?",a,b);
			System.out.println(output);
			System.out.print("Enter value: ");
			
		Scanner scn = new Scanner(System.in);
			try {
   			int ins = scn.nextInt();
		   	if (ins == a+b){
					System.out.println("Good");
					correct ++;
				} else {
					throw new Exception();
				}
			}
			catch (Exception e){
				System.out.println("Not good");
				error ++;
				continue;
			}
			
		}
		long time2 = System.currentTimeMillis();
		float passing_time = (time2-time1)/1000F;
		System.out.println(String.format("\nCorrect: %d/%d in %.2f seconds", correct, operation,passing_time));
		//System.out.println(a);
		//System.out.println(b);
	}
}