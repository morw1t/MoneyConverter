public class EuroConverter implements Converter {

    public final static double COURSEEUR = 159.87;

    @Override
    public double convertMoney(double ruble) {
        double euroValue = ruble / COURSEEUR;
        return euroValue;
    }
}
