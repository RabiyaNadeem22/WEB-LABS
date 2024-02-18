import java.util.*;
import java.io.*;

class Employee{
       int id; String name; static double salary; String rank;

      public Employee(int id, String name,double salary, String rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
       Employee.salary = salary;
    }

   
    public void setId(int id) {
        this.id = id;
    }
 
   public void setName(String name) {
        this.name = name;
    }

   

    public static void setSalary( double salary) {
        Employee.salary = salary;
    }


    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
       }


     public String getName() {
        return name;
       }

    public static double getSalary() {
        return salary;
       }

     public String getRank() {
        return rank;
        }

public String toString() {
        return id + "," + name + "," + salary + "," + rank;
    }
}





public class Management {
    public ArrayList<Employee> employees;

    public Management() {
        employees = new ArrayList<>();
    }

    public void load(String filename) {
        try {
            File file = new File(filename);
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String line = f.nextLine();
                String[] s = line.split(",");
                int id = Integer.parseInt(s[0]);
                String name = s[1];
                double salary = Double.parseDouble(s[2]);
                String rank = s[3];
                Employee employee = new Employee(id, name, salary, rank);
                employees.add(employee);
            }
            scanner.close();
            System.out.println("Data loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    public void save(String filename) {
        try {
            FileWriter w = new FileWriter(filename);
            for (int i=0; i< employeess.size(); i++)
               {
                w.write(employee.toString() + "\n");
            }
            w.close();
            System.out.println("Data saved to " + filename);
        } catch (IOException e)
           {
            System.out.println("Error saving data to " + filename);
            }
    }

    public void removeEmployee(int id) {
        for (int i=0; i< employeess.size(); i++) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed: " + employee.getName());
                return;
            }
        }
        System.out.println("Employee not found with ID: " + id);
    }

    public void printEmployees() {
        for (int i=0; i< employeess.size(); i++) {
            System.out.println(employee);
        }
    }
}

public class Driver{
   
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       Management m = new Management();

        while (true) {
            System.out.println("\n Management System");
            System.out.println("1= Load ");

            System.out.println("2= Add  employee");

            System.out.println("3= Save");

            System.out.println("4= Remove employee");

            System.out.println("5= Print");

            System.out.println("6= Exit");

            System.out.print("Enter your choice: ");

            int ch = s.nextInt();

            s.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter CSV filename: ");
                    String csvFilename = s.nextLine();
                    ems.loadFromCSV(csvFilename);
                    break;
                case 2:
   
              }
     }
}
}