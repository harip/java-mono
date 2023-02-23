interface A {
    void show();    
}

class Xyz implements A { 
    @Override
    public void show() {
        System.out.println("Hello World");
    }

}

public class LambdaDemo {
    public static void main(String[] args) {
        A obj = new Xyz();
        
        
        // {
        //     public void show() {
        //         System.out.println("Hello World");
        //     }
        // };
        obj.show();
    }
}
