import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptEngine {
    public static int averageCost(int noOfMonths, int[] travelCostForMonths) {
        int totalCost = 0;
        for (int i = 0; i < noOfMonths; i++) {
            totalCost += travelCostForMonths[i];
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        int averageCost = 0;
        try {
            engine.eval("var totalCost = " + totalCost + "; var noOfMonths = " + noOfMonths + ";");
            engine.eval("var averageCost = Math.round(totalCost / noOfMonths);");
            double temp = (double) engine.get("averageCost");
            averageCost = (int) Math.round(temp);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return averageCost;
    }

    public static void main(String[] args) {
        int noOfMonths = 6;
        int[] travelCostForMonths = {500, 700, 800, 600, 900, 1000};
        System.out.println("Average cost spent by Tim on travel is: $" + averageCost(noOfMonths, travelCostForMonths));
    }
}
