import java.util.HashMap;
import java.util.Map;

public class MainLogic {

    private InputOutput inputOutput;
    private Converter converter;
    private Map<String, Converter> converters;

    public MainLogic(InputOutput input) {
        this.inputOutput = input;
        converters = new HashMap<>();
        converters.put("USD", new DefaultConverter());
        converters.put("EUR", new EuroConverter());
    }

    public void start() {
        while (true) {
            try {
                inputOutput.displayMessage("В какую валюту хотите перевести? (USD, EUR или 'exit' для выхода):");

                String currencyCode = inputOutput.inputData();
                if (currencyCode.equalsIgnoreCase("exit")) {
                    inputOutput.displayMessage("Выход из программы.");
                    break;
                }

                converter = converters.get(currencyCode.toUpperCase());
                if (converter == null) {
                    inputOutput.displayMessage("Нет такой валюты: " + currencyCode);
                    continue;
                }

                inputOutput.displayMessage("Сколько рублей хотите перевести? (или введите 'exit' для выхода из программы)");
                String ruble = inputOutput.inputData();
                if (ruble.equalsIgnoreCase("exit")) {
                    inputOutput.displayMessage("Выход из программы.");
                    break;
                }
                double rubleValue = Double.parseDouble(ruble);
                double result = converter.convertMoney(rubleValue);
                inputOutput.displayMessage("Вы получите " + result + " " + currencyCode.toUpperCase());
            } catch (NumberFormatException e) {
                inputOutput.displayMessage("Ошибка : введите корректное число");
            } catch (Exception e) {
                inputOutput.displayMessage("Ошибка: " + e.getMessage());
            }
        }
    }
}
