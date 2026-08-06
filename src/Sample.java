import javax.script.ScriptException;
import java.sql.*;
import java.util.Optional;
import java.util.Scanner;


class Sample {
   public static void main() throws ScriptException {
//       System.out.println("This is sample calculator :   ");
//       ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
//       Scanner sc = new Scanner(System.in);
//       System.out.print("Enter your expression : ");
//       String s = sc.nextLine();
//       System.out.println(" = " + engine.eval(s));

       String name = null;
       Optional<String> opt = Optional.ofNullable(name);
       // Offnullable methods let the variable contain the null value by helping to prevent the null pointer exception
       opt.ifPresent(nam -> {
           System.out.println("name is available\n\n\n");
       });
       String url = "jdbc:mysql://localhost:3306/kunj_db";
       String username = "root";
       String password = "mysql";
       try(Scanner sc = new Scanner(System.in);
           Connection con = DriverManager.getConnection(url,username,password);
           PreparedStatement pstmt = con.prepareStatement("SELECT * from Persons where PersonId = ?");
       ){
           System.out.println("Enter id to search from data base : ");
           pstmt.setInt(1,sc.nextInt());
           ResultSet rs = pstmt.executeQuery();
           while(rs.next()){
               System.out.println("Person id : " + rs.getInt("PersonId"));
               System.out.println("Person name : " + rs.getString("LastName") + " " + rs.getString("FirstName"));
               System.out.println("Person Addres : " + rs.getString("Address") + rs.getString("City"));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
}
