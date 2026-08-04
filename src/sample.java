import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.*;

 class sample {
   public static void main() throws ScriptException {
//       System.out.println("This is sample calculator :   ");
//       ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
//       Scanner sc = new Scanner(System.in);
//       System.out.print("Enter your expression : ");
//       String s = sc.nextLine();
//       System.out.println(" = " + engine.eval(s));

       String name = null;
       Optional<String> opt = Optional.of(name);

       opt.ifPresent(nam -> {
           System.out.println("name is available\n\n\n");
       });

    }
}
