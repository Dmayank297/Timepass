 import java.util.Scanner;
public abstract class Shape  
{ 
    // Abstract methods to calculate area and perimeter 
    public abstract double calculateArea(); 
    public abstract double calculatePerimeter(); 
} 
 
// Circle class, a subclass of Shape 
class Circle extends Shape  
{ 
    private double radius; 
 
    public Circle(double radius)  
    { 
        this.radius = radius; 
    } 
 
    // Implementing abstract methods 
 
    public double calculateArea()  
    { 
        return Math.PI * Math.pow(radius, 2); 
    } 
 
    public double calculatePerimeter()  
    { 
        return 2 * Math.PI * radius; 
    } 
} 
 
 
class Triangle extends Shape  
{ 
    private double side1, side2, side3; 
 
    // Constructor 
    public Triangle(double side1, double side2, double side3)  
    { 
        this.side1 = side1; 
        this.side2 = side2; 
        this.side3 = side3; 
    } 
 
    // Implementing abstract methods 
    public double calculateArea()  
    { 
        // Using Heron's formula to calculate the area of a triangle 
        double s = (side1 + side2 + side3) / 2; 

return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); 
} 
public double calculatePerimeter()  
{ 
return side1 + side2 + side3; 
} 
} 
class Main { 
public static void main(String[] args) { 
// Creating objects of Circle and Triangle 

Scanner sc = new Scanner(System.in);
System.out.println("Enter radius: ");
int radius = sc.nextInt();

Circle circle = new Circle(radius); 

System.out.println("Enter side of triangle: ");
int side1 = sc.nextInt();
int side2 = sc.nextInt();
int side3 = sc.nextInt();

Triangle triangle = new Triangle(side1, side2, side3); 
// Displaying area and perimeter of the Circle 

System.out.println("Circle - Area: " + circle.calculateArea()); 
System.out.println("Circle - Perimeter: " + 
circle.calculatePerimeter()); 

// Displaying area and perimeter of the Triangle 
System.out.println("Triangle - Area: " + 
triangle.calculateArea()); 
System.out.println("Triangle - Perimeter: " + 
triangle.calculatePerimeter()); 
} 
} 