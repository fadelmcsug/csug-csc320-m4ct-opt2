import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class gradeLoops {

	public static void main(String[] args) throws IOException {
		
		double sumGrades = 0;
		double maximumGrade = 0;
		double minimumGrade = 100; // may seem counter-intuitive, but it allows the program to gradually go down to the real input minimum later
		double userGrade;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("The program will ask you to input 10 grades between 0 and 100.");
		System.out.println("Press enter to continue.");
		scnr.nextLine();
		
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println("Input grade " + (i + 1) + ":");
			
			while (true) {
				try {
					userGrade = scnr.nextDouble();
					if (userGrade >= 0 && userGrade <= 100) {
						sumGrades += userGrade;
						if (userGrade > maximumGrade) {
							maximumGrade = userGrade;
						}
						if (userGrade < minimumGrade) {
							minimumGrade = userGrade;
						}
						break;
					} else { System.out.println("Please input a grade between 0 and 100."); }
				} catch (InputMismatchException e) { 
					System.out.println("Please input a valid number"); 
					scnr.next(); // clears invalid input to avoid continuous exception looping
				}
			}
		}
		
		scnr.close();
		
		System.out.println("The average grade is: " + (sumGrades / 10));
		System.out.println("The maximum grade is: " + maximumGrade);
		System.out.println("The minimum grade is: " + minimumGrade);
	}

}
