import java.sql.*;
import java.util.Scanner;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kunj_db";
        String username = "root";
        String password = "mysql";

        // Significance of try with resources
        // in previous times we had to manually close all the resources at the end of their uages
        //But After java 7 try with resources was introduced which ensures that all the neccesary resources which needs o be closed will be closed autometically.
        try(Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Persons VALUES (?,?,?,?,?)");
        ) {
            pstmt.setInt(1,sc.nextInt());
            pstmt.setString(2,sc.next());
            pstmt.setString(3,sc.next());
            pstmt.setString(4,sc.next());
            pstmt.setString(5,sc.next());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Query executed succesfully. Rows affected : " + rowsAffected);
        }catch (SQLException e){
            System.out.println("Proces failed");
            e.printStackTrace();
        }
    }
}

