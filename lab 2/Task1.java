import java.util.Scanner;

abstract class TwoDimensionalShape
{
   abstract double getArea();
   
   abstract void getInput();
   
}

class Circle extends TwoDimensionalShape
{
   double radius;
    public void getInput()
    {
       Scanner in =new Scanner(System.in);
       System.out.println("Enter radius of circle: ");
       radius=in.nextDouble();
    }

    public double getArea()
    {
        return 3.14*radius*radius;
    }

    public String toString()
     {
        return "Area of TwoDimensional Circle is :" + getArea();
        }
}

class Square extends TwoDimensionalShape
{
   double a;
    public void getInput()
    {
       Scanner in =new Scanner(System.in);
       System.out.println("Enter sidelength of square: ");
       a=in.nextDouble();
    }

    public double getArea()
    {
        return a*a;
    }

    public String toString()
     {
        return "Area of TwoDimensional Square  is :" + getArea();
        }
}

class Triangle extends TwoDimensionalShape
{
   double base,height;
    public void getInput()
    {
       Scanner in =new Scanner(System.in);
       System.out.println("Enter base of Triangle: ");
       base=in.nextDouble();
        System.out.println("Enter height of Triangle: ");
       height=in.nextDouble();
    }

    public double getArea()
    {
        return 1/2*(base*height);
    }

    public String toString()
     {
        return "Area of TwoDimensional Triangle is :" + getArea();
        }
}


public class Task1
{
   public static void main(String args[])
   {
      TwoDimensionalShape s[]=new TwoDimensionalShape[3];
          s[0]=new Circle();
          s[0].getInput();
          System.out.println(s[0]);

         s[1]=new Square();
          s[1].getInput();
          System.out.println(s[1]);

          s[2]=new Triangle();
          s[2].getInput();
          System.out.println(s[2]);

          for(int i=0;i<3;i++)
          {
            if(s[i] instanceof TwoDimensionalShape)
             {
                   System.out.println(s[i]);          
             }
          }
   }
}