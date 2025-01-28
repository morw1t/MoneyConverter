public class MainLogic {

    private InputOutput inputOutput;
    private Converter converter;

    public MainLogic(InputOutput input, Converter converter) {
        this.inputOutput = input;
        this.converter = converter;
    }

    public void start() {
        inputOutput.displayMessage("Сколько рублей хотите перевести?");
        String ruble = inputOutput.inputData();
        double rubleValue = Double.parseDouble(ruble);
        double result = converter.convertMoney(rubleValue);
        inputOutput.displayMessage("Вы получите " + result);
    }
}
