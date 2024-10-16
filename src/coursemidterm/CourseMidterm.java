
package coursemidterm;

import static java.lang.System.exit;
import java.util.Scanner;


public class CourseMidterm {

    public void addCourse(){
        
        Scanner sc = new Scanner(System.in);
        Config con = new Config();
        
        System.out.print("Enter Course Name: ");
        String cname = sc.next();
        System.out.print("Enter Course Code: ");
        String code = sc.next();
        System.out.print("Credits: ");
        int credits = sc.nextInt();
        System.out.print("Enter semester: ");
        String sem = sc.next();
        System.out.print("Year: ");
        int year = sc.nextInt();

        String sqlAdd = "INSERT INTO Course (Course_Name, Course_Code, Credits, SEMESTER, Year)VALUES (?,?,?,?,?)";
        
        con.addRecord(sqlAdd, cname,code,credits,sem,year);
       
    }
    public void viewCourse(){
        
         Config con = new Config();
        String courseQuery = "SELECT * FROM Course";
        String[] courseHeaders = {"ID", "Course Name", "Course Code", "Credits", "Semester","Year"};
        String[] courseColumns = {"Course_Id", "Course_Name", "Course_Code", "Credits", "SEMESTER","Year"};

        con.viewRecords(courseQuery, courseHeaders, courseColumns);
    
    }
    
   
    public static void main(String[] args) {
       
        CourseMidterm cm = new CourseMidterm();
        Scanner sc = new Scanner(System.in);
          
        Config con = new Config();
            String response;
        do{
        System.out.println("1. Add Course");
        System.out.println("2. View Course");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Exit");
        
        int choice;
    
        
        System.out.print("Enter Choice: ");
       choice = sc.nextInt();
       sc.nextLine();
     
      
           
       switch(choice){
           
           case 1:
               
               cm.addCourse();

               break;
           case 2:
               
               cm.viewCourse();
               break;
           
           case 3:
               
                  cm.viewCourse();
                   
                  String sqlUpdate = "UPDATE Course SET Course_Name = ?, Course_Code = ?, Credits = ?, SEMESTER = ?, Year = ?  WHERE Course_Id = ?";
                  
                  System.out.print("Enter ID to Update: ");
                  int id = sc.nextInt();
                 
                    System.out.print("Enter  new Course Name: ");
                    String newname = sc.next();
                    System.out.print("Enter new Course Code: ");
                    String newcode = sc.next();
                    System.out.print("Enter new Credits: ");
                    int newcredits = sc.nextInt();
                    System.out.print("Enter new semester: ");
                    String newsem = sc.next();
                    System.out.print("Enter new Year: ");
                        int nyear = sc.nextInt();
                  con.updateRecord(sqlUpdate, newname, newcode, newcredits, newsem,nyear,id);
               break;
               
           case 4:
               
                cm.viewCourse();
                
                String sqlDelete = "DELETE FROM Course WHERE Course_Id = ?";
                
                System.out.print("Enter id to delete: ");
                int delID = sc.nextInt();
                
                con.deleteRecord(sqlDelete, delID);
                break;
          
           
           case 5:
               
               exit(0);
               break;
       }
       
           System.out.print("Do you want to continue? Yes / No : ");
           response = sc.next();
           
           
       }while(response.equalsIgnoreCase("yes"));
       
        System.out.println("Thank you for using the Application");
    }
    
}
