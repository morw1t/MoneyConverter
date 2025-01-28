public class DefaultConverter implements Converter {

    public final static double COURSEUSD = 102.59;

    @Override
    public double convertMoney(double ruble) {
        double dollarValue = ruble / COURSEUSD;
        return dollarValue;
    }
}
