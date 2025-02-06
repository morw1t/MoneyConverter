public class Main {
    public static void main(String[] args) {
        ConsoleInputOutput inputOutput = new ConsoleInputOutput();
        MainLogic mainLogic = new MainLogic(inputOutput);
        mainLogic.start();
    }
}
