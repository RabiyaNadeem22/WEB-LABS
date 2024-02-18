import java.util.*;
import javax.swing.*;

class Task1
{
  public static void main(String args[])
  {
     String shape;
     Double area,s,l,w,b,h,b1,b2,r,a;

    

     if(args[0].equals("Square"))
      {
          s=Double.parseDouble(args[1]);
         area=s*s;
         JOptionPane.showMessageDialog(null,"Area of square:" + area);
      }
      
       
      if(args[0].equals("Rectangle"))
      {
         l=Double.parseDouble(args[1]);
         w=Double.parseDouble(args[2]);
         area=l*w;
         JOptionPane.showMessageDialog(null,"Area of Rectangle:" + area);
      }
      
       if(args[0].equals("Parallelogram"))
      {
         b=Double.parseDouble(args[1]);
         h=Double.parseDouble(args[2]);
         area=b*h;
         JOptionPane.showMessageDialog(null,"Area of Parallelogram:" + area);
      }
     
     if(args[0].equals("Trapezoid"))
      {
         b1=Double.parseDouble(args[1]);
         b2=Double.parseDouble(args[2]);
         h=Double.parseDouble(args[3]);
         area=(((b1 + b2) / 2)*h);
         JOptionPane.showMessageDialog(null,"Area of Trapezoid:" + area);
      }
       
      if(args[0].equals("Triangle"))
      {
         b=Double.parseDouble(args[1]);
         h=Double.parseDouble(args[2]);
         
         area=((1/2)*b*h);
         JOptionPane.showMessageDialog(null,"Area of Triangle:" + area);
      }
      
      if(args[0].equals("Circle"))
      {
         r=Double.parseDouble(args[1]);
         
         area=(3.147*(r*r));
         JOptionPane.showMessageDialog(null,"Area of Circle:" + area);
      }
      
     if(args[0].equals("Ellipse"))
      {
         
         a=Double.parseDouble(args[1]);
         b=Double.parseDouble(args[2]);
         
         area=(3.147*(a*b));
         JOptionPane.showMessageDialog(null,"Area of Circle:" + area);
      }

     else{
      System.out.println("Error");
     } 
     
  }

}