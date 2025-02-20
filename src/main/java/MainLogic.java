import java.util.Map;

public class MainLogic {

    private InputOutput inputOutput;
    private Converter converter;
    private Map<String, Converter> converters;
    private static final String RESULT_MESSAGE = "Вы получите %.2f %s";

    public MainLogic(InputOutput input, Map<String, Converter> converters) {
        this.inputOutput = input;
        this.converters = converters;
    }

    public void start() {
        while (true) {
            try {
                inputOutput.displayMessage("В какую валюту хотите перевести? (USD, EUR или 'exit' для выхода):");

                String currencyCode = inputOutput.inputData();
                if (currencyCode.equalsIgnoreCase("exit")) {
                    throw new ExitException("Выход из программы.");
                }

                if (!converters.containsKey(currencyCode.toUpperCase())) {
                    throw new NoCurrencyException("Нет такой валюты: " + currencyCode);
                }

                converter = converters.get(currencyCode.toUpperCase());
                inputOutput.displayMessage("Сколько рублей хотите перевести?");
                String ruble = inputOutput.inputData();
                double rubleValue = Double.parseDouble(ruble);
                double result = converter.convertMoney(rubleValue);

                String resultMessage = RESULT_MESSAGE.formatted(result, currencyCode.toUpperCase());

                inputOutput.displayMessage(resultMessage);
            } catch (NumberFormatException e) {
                inputOutput.displayMessage("Ошибка : введите корректное число");
            } catch (NoCurrencyException e) {
                inputOutput.displayMessage(e.getMessage());
            } catch (ExitException e) {
                inputOutput.displayMessage(e.getMessage());
                break;
            } catch (Exception e) {
                inputOutput.displayMessage("Ошибка: " + e.getMessage());
            }
        }
    }
}
