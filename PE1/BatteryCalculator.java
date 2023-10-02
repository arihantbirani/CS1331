public class BatteryCalculator {
    public static void main(String[] args){
        final int tikTokHours = 2;
        final int spotifyHours = 3;
        final double messagingHours = 1.5;
        final double instagramHours = 0.5;
        final int rechargeTime = 31;
        int phoneBattery = 100;

        phoneBattery -= (tikTokHours * 17);
        phoneBattery -= (spotifyHours * 5);
        phoneBattery -= (messagingHours * 8);
        phoneBattery -= (instagramHours * 12);
        System.out.println("The battery of my phone at the end of the day is " + phoneBattery + "%. ");

        phoneBattery += (rechargeTime * 1.3);
        System.out.println("The battery after a " + rechargeTime + " minute recharge is " + phoneBattery + "%." );


    }
}
