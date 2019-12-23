import interfacefeautes.A;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        A.sayHelloWorld();
        Function<String,String> function=(R)->{
          return "123";
        };
    }
}
