import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConsoleInputOutput inputOutput = new ConsoleInputOutput();
        Map<String, Converter> converters = new HashMap<>();
        converters.put("USD", new DefaultConverter());
        converters.put("EUR", new EuroConverter());
        MainLogic mainLogic = new MainLogic(inputOutput, converters);
        mainLogic.start();
    }
}
