import java.sql.*;
import java.util.*;



class AddressBook{
private Connection con;
     AddressBook()throws Exception{
         Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://127.0.0.1/addressbook";
           con=DriverManager.getConnection(url,"root","root");
         
     }

   public void addPerson()throws Exception
     {
        Statement st=con.createStatement();
        Scanner inp = new Scanner(System.in);

	System.out.print("Please enter UserName: ");
	String u_name = inp.nextLine();

	System.out.print("Please enter address: ");
	String address = inp.nextLine();

	System.out.print("Please enter City: ");
	String city= inp.nextLine();
	
	System.out.print("Please enter Phone: ");
	int phone = inp.nextInt();

	

     String query="insert into info(username,address,phone,city) values('"+u_name+"',  '"+address+"', "+phone+" , '"+city+"' )";

 
     int rs = st.executeUpdate( query );

	 System.out.println(rs);
   
     if(rs > 0){
	    System.out.println("Record inserted successfully.");
	  }
     
     else{
    	 System.out.println("Record could not inserted.");
         }
}
public void searchPerson(String name)throws Exception
{
     Statement st=con.createStatement();
    
     String query="Select * from info where username='"+name+"'";
     
   
     ResultSet rs = st.executeQuery( query );
   
     if(rs.next())
         {
	    String name1 = rs.getString("username");
    	    String address = rs.getString("address");
            String city = rs.getString("city");
            int phone = rs.getInt("phone");
    	    System.out.println("UserName: "+ name1 +"\tAddress: "+ address+"city: "+ city +"\tphone: "+ phone);

	  }
     
     else{
    	 System.out.println("No record found");
         }
}

public void deletePerson(String name) throws Exception
{
     Statement st=con.createStatement();
    
     String query="Delete  from info where username='"+name+"' ";
     
   
     int rs = st.executeUpdate( query );
   
    if(rs > 0){
	    System.out.println("Record deleted successfully.");
	  }
     
     else{
    	 System.out.println("Record could not be deleted.");
         }
}
 



}


public class Driver
{
public static void main(String[] args)throws Exception
{
     AddressBook obj=new AddressBook();
     System.out.println("press 1 for insert\n press 2 for delete \n press 3 for search");
     Scanner in=new Scanner(System.in);
     int ch = in.nextInt();
     switch(ch)
     {
       case 1:
           obj.addPerson();
           break;
       case 2:
           String n,s;
           System.out.println("Enter username to delte:");
            s=in.nextLine();
            n=in.nextLine();
           
           obj.deletePerson(n);
           break;
       case 3:
           String n1,d;
           System.out.println("Enter username to search:");
            d=in.nextLine();
            n1=in.nextLine();
           obj.searchPerson(n1);
           break;
      case 4:
          System.exit(0);
       
     } 
}

}


     

