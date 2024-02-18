import javax.swing.*;
import java.util.*;

class duplicateCustomerException extends Exception{
  
  public String toString(){
    return "duplicate Customer String";
  }   
}

class invalidAgeException extends Exception{
 
  public String toString(){
      return "invalid Age Exception"; 
   }
}

class lowBalanceException extends Exception{
    
    public String toString(){
      return "low Balance Exception"; 
   }
}

class invalidCustomerIDException extends Exception{
   
    public String toString(){
     return "Invalid Customer Id Exception"; 
   }
}

class Customer{
      String name;
      String id;
      int age;
      Double balance;
     
      public Customer(String n,String id1,int age1,Double bal)
      {
          name=n;
          id=id1;
          age=age1;
          balance=bal;
      }
     
} 
 
public class Bank{
       ArrayList Customers;
       public Bank()
       {
          Customers= new ArrayList();
        }
      
     public void addCustomer() throws duplicateCustomerException, invalidAgeException
      {
       try{
         String name = JOptionPane.showInputDialog("Enter name:");
         String id = JOptionPane.showInputDialog("Enter id:");
         String age = JOptionPane.showInputDialog("Enter age:");
         int age2=Integer.parseInt(age);
          if(age2<18 || age2>65)
              {
                 throw new invalidAgeException();
               }
                
         String bal = JOptionPane.showInputDialog("Enter balance:");
         Double balance2=Double.parseDouble(bal);
         
         for(int i=0;i<Customers.size();i++)
          {             
             Customer p = (Customer)Customers.get(i);
             if ( id.equals(p.id) )
             {
                throw new duplicateCustomerException();
             } 
                            
           }
//construt new customer object
        Customer p = new Customer(name,id,age2,balance2);
//add the above Customer object to arraylist
        Customers.add(p); 
           }      
       catch(duplicateCustomerException e)
         {
          System.out.println(e);
          }
         catch(invalidAgeException e)
         {
          System.out.println(e);
          }
       
        
      }

public void searchCustomer (String id)throws invalidCustomerIDException{

for (int i=0; i< persons.size(); i++) {
Customer p = (Customer)Customers.get(i);
if ( n.equals(p.id) ) {
p.print();}
else{
   thow new invalidCustomerIDException();
   }
} 
}

public static void main(String args[])
 {
      Bank b=new Bank();
      
String input, s;
int ch;
while (true) {
input = JOptionPane.showInputDialog("Enter 1 to add " + "\n Enter 2 to
Search " + "\n Enter 3 to Exit");

ch = Integer.parseInt(input);
switch (ch) {
case 1:
ab.addCustomer();
break;

case 2:
s = JOptionPane.showInputDialog("Enter name to search ");
ab.search(s);
break;

case 3:
System.exit(0);
}
       
 }       

        
} }