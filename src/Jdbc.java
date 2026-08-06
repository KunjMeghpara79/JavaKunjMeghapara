import javax.sound.sampled.LineEvent;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.sql.*;
import java.util.Scanner;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kunj_db";
        String username = "root";
        String password = "mysql";
        // Significance of try with resources
        // in previous times we had to manually close all the resources at the end of their uages
        //But After java 7 try with resources was introduced which ensures that all the neccesary resources
        // which needs to be closed will be closed autometically.
        try(Scanner sc = new Scanner(System.in);
            //Any object declared inside these parentheses must implement the AutoCloseable interface
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement insertStatement = con.prepareStatement("INSERT INTO Persons VALUES (?,?,?,?,?)");
            PreparedStatement readStatement = con.prepareStatement("SELECT * from Persons where PersonId = ?");
            PreparedStatement updateStatement = con.prepareStatement("UPDATE Persons SET LastName = ?, FirstName = ? WHERE PersonId = ?");
            PreparedStatement deleteStatement = con.prepareStatement("DELETE from Persons where PersonId = ?");
        ) {
            while (true){
                System.out.println("Enter 1 for insert.\n" +
                        "Enter 2 for read.\n" +
                        "Enter 3 for update.\n" +
                        "Enter 4 for delete.\n" +
                        "Enter 5 for exit.");
                int choice = sc.nextInt();
                if(choice == 1){
                    System.out.print("Enter Person Id : ");
                    insertStatement.setInt(1,sc.nextInt());
                    System.out.print("Enter last and first name : ");
                    insertStatement.setString(2,sc.next());
                    insertStatement.setString(3,sc.next());
                    System.out.println("Enter Address and city : ");
                    insertStatement.setString(4,sc.next());
                    insertStatement.setString(5,sc.next());
                    int rowsAffected = insertStatement.executeUpdate();
                    System.out.println("Insertion Successfull ! rows affected : " + rowsAffected);
                }
                else if(choice == 2){
                    System.out.println("Enter id to search : ");
                    int id = sc.nextInt();
                    readStatement.setInt(1,id);
                    ResultSet rs = readStatement.executeQuery();
                    boolean recordFound = false;
                    while (rs.next()){
                        recordFound = true;
                        System.out.println("Person id : " + rs.getInt("PersonId"));
                        System.out.println("Person name : " + rs.getString("LastName") + " " + rs.getString("FirstName"));
                        System.out.println("Person Address : " + rs.getString("Address") + " " + rs.getString("City"));
                    }
                    if (!recordFound) {
                        System.err.println("No record found with ID " + id);
                    }
                }
                else if(choice == 3){
                    System.out.println("Enter id to change name : ");
                    int id = sc.nextInt();
                    // 1. Check if the ID exists using your existing readStatement
                    readStatement.setInt(1, id);
                    ResultSet rs = readStatement.executeQuery();
                    if (!rs.next()) {
                        // If rs.next() is false, the ID does not exist in the DB
                        System.err.println("Error: No record found with ID " + id);
                    }
                    else {
                        System.out.println("Record found! Current details: " + rs.getString("LastName") + " " + rs.getString("FirstName"));
                        System.out.println("Enter new Last Name : ");
                        String lastName = sc.next();
                        System.out.println("Enter new First Name : ");
                        String firstName = sc.next();
                        // 3. Apply changes using updateStatement
                        updateStatement.setString(1, lastName);
                        updateStatement.setString(2, firstName);
                        updateStatement.setInt(3, id);
                        updateStatement.executeUpdate();
                        System.out.println("Record Updated Successfully !");
                    }
                }
                else if(choice == 4){
                    System.out.println("Enter id to delete : ");
                    int id = sc.nextInt();
                    deleteStatement.setInt(1,id);
                    int rowsAffected = deleteStatement.executeUpdate();
                    if(rowsAffected > 0) {
                        System.out.println("Record deleted successfully !");
                    } else {
                        System.err.println("Error!");
                    }
                }else break;
            }
        }catch (SQLException e){
            System.out.println("Proces failed");
            e.printStackTrace();
        }
    }
}

