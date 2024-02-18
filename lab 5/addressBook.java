import java.sql.*;
import java.util.*;



class AddressBook{
private Connection con;
     AddressBook()throws Exception{
         Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://127.0.0.1/addressbook";
          Connection con=DriverManager.getConnection(url,"root","root");
         
     }

    void addPerson()throws Exception
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
void searchPerson(String name )throws Exception
{
     Statement st=con.createStatement();
    
     String query="Select * from info where username='"+name+"' ";
     
   
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

void deletePerson(String name) throws Exception
{
     Statement st=con.createStatement();
    
     String query="Delete * from info where username='"+name+"' ";
     
   
     int rs = st.executeUpdate( query );
   
    if(rs > 0){
	    System.out.println("Record deleted successfully.");
	  }
     
     else{
    	 System.out.println("Record could not be deleted.");
         }
}
 



}


public class Driver()
{
public static void main(String[] args)
{
     AddressBook obj=new AddressBook():
     String ch;
     System.out.println("press 1 for insert\n press 2 for delete \n press 3 for search");
     Scanner in=new 
}

}


     

