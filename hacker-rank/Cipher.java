import java.util.*;

interface AnonymousInterface {
    void getCipher(ArrayList<String> list);
}

class Cipher_Anonymous {
    void anonymousClass(ArrayList<String> list) {
        AnonymousInterface anonymousInterface = new AnonymousInterface() {
            @Override
            public void getCipher(ArrayList<String> list) {
                StringBuilder cipher = new StringBuilder();
                list.forEach(s -> cipher.append(new StringBuilder(s).toString()));
                System.out.println(cipher);
            }
        };
        anonymousInterface.getCipher(list);
    }
}

class Cipher_MethodRef {
    void methodReference(ArrayList<String> list) {
        StringBuilder cipher = new StringBuilder();
        list.forEach(cipher::append);
        String result = cipher.toString();
        System.out.println(result);
    }
}

class Cipher_LambdaExp {
    void lambdaExpression(ArrayList<String> list) {
        list.replaceAll(str -> {
            String val = "";
            if(str.equals(" ")) {
                val = "#$";
            } else {
                val = (int)str.charAt(0) + str.substring(1);
            }
            return new StringBuilder(val).reverse().toString();
        });
        String result = list.stream().map(s -> new StringBuilder(s).toString()).reduce("",
                (s1, s2) -> s1 + s2);
        System.out.println(result);
    }
}

class CipherMain {
    public static void main(String[] args) throws Exception {
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        String input = "First, solve the problem. Then, write the code.";
        String inputarr[] = input.split(" ");

        list.add(inputarr[0]);
        for (int i = 0; i < inputarr.length - 1; i++) {
            list.add(" ");
            list.add(inputarr[i + 1]);
        } 

        Cipher_LambdaExp l1 = new Cipher_LambdaExp();
        System.out.print("Lambda Expression : ");
        l1.lambdaExpression(list); 

        Cipher_MethodRef m1=new Cipher_MethodRef();
        System.out.print("Method Reference : ");
        m1.methodReference(list);

        Cipher_Anonymous a1=new Cipher_Anonymous();
        System.out.print("Anonymous Class : ");
        a1.anonymousClass(list);
    }
}
