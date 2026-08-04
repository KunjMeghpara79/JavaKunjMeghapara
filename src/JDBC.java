import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kunj_db";
        String username = "root";
        String password = "mysql";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement stmt = con.createStatement();;

//       stmt.execute("CREATE TABLE Persons (\n" +
//               "  PersonID int PRIMARY KEY,\n" +
//               "  LastName varchar(255) NOT NULL,\n" +
//               "  FirstName varchar(255),\n" +
//               "  Address varchar(255),\n" +
//               "  City varchar(255)\n" +
//               ");");
      //  stmt.execute("INSERT INTO Persons VALUES (60, 'Meghapara', 'Kunj', 'Sentosa greens', 'Bardoli')");
        ResultSet rs = stmt.executeQuery("Select * from Persons where PersonID = 60");
        while (rs.next()){
            int personId = rs.getInt("PersonID");
            String lastName = rs.getString("LastName");
            String firstName = rs.getString("FirstName");
            String address = rs.getString("Address");
            String city = rs.getString("City");

            System.out.println(
                    personId + " " +
                            lastName + " " +
                            firstName + " " +
                            address + " " +
                            city
            );
        }
        stmt.close();;
        con.close();
    }
}
