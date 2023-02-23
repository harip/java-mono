interface A {
    void show();
}

 
public class LambdaDemo {
    public static void main(String[] args) {
        A obj = () ->  System.out.println("Hello World from show method");
        obj.show(); 
    }
}