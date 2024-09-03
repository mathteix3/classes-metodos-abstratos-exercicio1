package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapesArrayList = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            scanner.nextLine(); // Consume the newline character
            System.out.println("\nShape #"+ (i+1) + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char shapeType = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline character
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(scanner.nextLine().toUpperCase());

            if (shapeType == 'r'){
                System.out.print("Width: ");
                double width = scanner.nextDouble();
                System.out.print("Height: ");
                double height = scanner.nextDouble();

                shapesArrayList.add(new Rectangle(color, width, height));

            } else if (shapeType == 'c') {
                System.out.print("Radius: ");
                double radius = scanner.nextDouble();

                shapesArrayList.add(new Circle(color, radius));

            }else {
                System.out.println("Invalid or non-existent figure");
                i--; // Allow reentry for the current shape
            }

        }

        System.out.println("\nSHAPE AREAS:");
        for (Shape shape : shapesArrayList){
            System.out.printf("%.2f%n",shape.area());
        }

        scanner.close();

    }

}
