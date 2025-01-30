public class MainLogic {

    private InputOutput inputOutput;
    private Converter converter;

    public MainLogic(InputOutput input, Converter converter) {
        this.inputOutput = input;
        this.converter = converter;
    }

    public void start() {
        while (true) {
            inputOutput.displayMessage("Сколько рублей хотите перевести? (или введите 'exit' для выхода из программы)");
            String ruble = inputOutput.inputData();
            if (ruble.equalsIgnoreCase("exit")) {
                inputOutput.displayMessage("Выход из программы.");
                break;
            }
            try {
                double rubleValue = Double.parseDouble(ruble);
                double result = converter.convertMoney(rubleValue);
                inputOutput.displayMessage("Вы получите " + result);
            } catch (NumberFormatException e) {
                inputOutput.displayMessage("Ошибка : введите корректное число");
            }

        }
    }
}
