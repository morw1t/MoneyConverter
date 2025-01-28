import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput{

    private Scanner scanner;

    public ConsoleInputOutput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String displayMessage) {
        System.out.println(displayMessage);
    }

    @Override
    public String inputData() {
        return scanner.nextLine();
    }
}
