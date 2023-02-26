import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

class StoreElementsInCollection {
    
    static void storeElements(String input) {
        ArrayList<String> sandwiches = new ArrayList<>();
        ArrayList<String> incorrectSandWiches = new ArrayList<>();
        
        // Split the input String using comma as a separator
        String[] sandwichArray = input.split(",");
        
        // Use Consumer interface to add the sandwiches to the ArrayList
        Consumer<String> addSandwich = sandwich -> {
            if (sandwich.equals("cheese sandwich") || sandwich.equals("corn sandwich") || sandwich.equals("mix veg sandwich")) {
                sandwiches.add(sandwich);
            } else {
                incorrectSandWiches.add(sandwich);
                if (incorrectSandWiches.size()==1) {
                    System.out.println("Incorrect Input");
                }
            }
        };
        
        // Add the sandwiches to the ArrayList using the Consumer interface
        for (String sandwich : sandwichArray) {
            addSandwich.accept(sandwich.trim().toLowerCase());
        }

        
        
        // Use Supplier interface to print the elements of the ArrayList
        if (incorrectSandWiches.size()==0) {
            Supplier<ArrayList<String>> getSandwiches = () -> sandwiches;
            getSandwiches.get().forEach(System.out::println);
        }
    }
}

class StoreElementsInCollectionMain
{
    public static void main(String[] args) throws Exception
    {
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
		// String input=br.readLine();
		
		StoreElementsInCollection.storeElements("cheese,cheese sandwich,corn sandwich,milk");
    }
}