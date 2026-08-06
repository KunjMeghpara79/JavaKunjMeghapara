import javax.script.ScriptException;
import java.util.Optional;


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
    }
}
