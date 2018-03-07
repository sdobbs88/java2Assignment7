/* Shaun Dobbs
 CSCI 1302
 Assignment 7
 May 3, 2016
 Purpose : Receives input from a grade file and then calculates 
 the grade percentages. Also displays certain information about the grades 
 into the console. 
 */
package passign7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PAssign7 {

    public static void main(String[] args) {
        File grades = new File("src/passign7/grades.txt");
        File finalGrades = new File("src/passign7/finalGrades.txt");
        final int POINTSAVAILABLE = 150;
        int count = 0;
        int sum = 0;
        double average = 0;
        
        //First loop to create sum. Tried, but was unable to do this in 
        //the same loop as where the file is written to. 
        try {
            Scanner inputForArray = new Scanner(grades);

            while (inputForArray.hasNext()) {
                sum += inputForArray.nextDouble();
            }
            inputForArray.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found.");
        }
        
        //Second loop that actually converts each grade to a percentage
        //and does other calculations with the newly calculated percentages.
        try {
            Scanner input = new Scanner(grades);
            PrintWriter output = new PrintWriter(finalGrades);

            while (input.hasNext()) {
                count++;
                output.printf("%.2f\n", (input.nextDouble() / POINTSAVAILABLE) * 100);
            }
            output.println();
            output.println("The total number of grades is: " + count + "\n");
            output.println("The sum of all of the grades is: " + sum + "\n");
            average = sum / count;
            output.print("The average grade is: ");
            output.printf("%.2f", average);

            input.close();
            output.close();
            
            //Messages indicating that file was written to. 
            System.out.println("Grades converted into new file successfully.");
            System.out.println("New file name is: finalGrades.txt");

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found.");
        }
    }
}
