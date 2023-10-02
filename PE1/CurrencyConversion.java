public class CurrencyConversion {
    //Arihant Birani - My favorite musical artist is Tyler the Creator
    public static void main(String[] args){
        double aedPerUsd = 3.67;
        double aedPerEur = 4.19;
        int notes  = 250;
        String name = "Arihant";
        double euros = notes / aedPerEur;
        double dollars = notes / aedPerUsd;
        double eurosTrunc = ((int) (euros *100))/100.0;
        double dollarsTrunc = ((int)(dollars *100))/100.0;
        System.out.println(name + " is carrying " + eurosTrunc + " Euros and " + dollarsTrunc + " Dollars!");

    }
}
