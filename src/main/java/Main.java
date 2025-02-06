public class Main {
    public static void main(String[] args) {
        ConsoleInputOutput inputOutput = new ConsoleInputOutput();
        Converter converter = new EuroConverter();
        MainLogic mainLogic = new MainLogic(inputOutput, converter);
        mainLogic.start();
    }
}
