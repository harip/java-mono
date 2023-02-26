import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;
import java.util.function.Function;

 interface Adder {
    String add(Function<String, String> f);
    void add(Consumer<Integer> f);
}
 
 class AdderImpl implements Adder {
 
    @Override
    public  String add(Function<String, String> f) {
        return f.apply("Welcome ");
    }
 
    @Override
    public void add(Consumer<Integer> f) {}
}

 class App{
  public static void main(String [] args){
    AdderImpl adderImpl= new AdderImpl();
    String r = adderImpl.add(a -> a + " lambda"); System.out.println(r);
  }
}