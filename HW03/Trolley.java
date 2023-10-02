/**
 * Trolley class to define a Trolley object as subclass of Ride.
 * @author Arihant Birani
 * @version 1.0
 */
public class Trolley extends Ride {
    private String[] stations;
    private int currentStation;
    /**
     * Four-arg construtors that takes in id, runsSinceInspection, stations, and current station.
     * @param id String representing the identifier for the ride
     * @param runsSinceInspection int representing the number of times the ride has run since the last inspection
     * @param stations String array representing station names
     * @param currentStation int corresponding to index of stations array of where the trolley is currently at
     */
    public Trolley(String id, int runsSinceInspection, String[] stations, int currentStation) {
        super(id, runsSinceInspection, new String[20]);
        this.stations = new String[stations.length];
        for (int i = 0; i < stations.length; i++) {
            this.stations[i] = stations[i];
        }
        this.currentStation = currentStation;
    }
    /**
     * Three-arg construtors that takes in id, runsSinceInspection, stations, and current station.
     * @param id String representing the identifier for the ride
     * @param stations String array representing station names
     * @param currentStation int corresponding to index of stations array of where the trolley is currently at
     */
    public Trolley(String id, String[] stations, int currentStation) {
        this(id, 0, stations, currentStation);
    }
    /**
     * Method to determine if ride can run a certain number of times.
     * @param numberOfRuns int number of runs
     * @return boolean if ride can run that many times before inspection
     */
    @Override
    public boolean canRun(int numberOfRuns) {
        return (numberOfRuns >= 0);
    }
    /**
     * Method that determines if ride passes inspection and resets runs.
     * @param componentsOfRide String array components of ride
     * @return boolean if ride passes inspection
     */
    @Override
    public boolean inspectRide(String[] componentsOfRide) {
        boolean[] passInspection = {false, false};

        String rideComp = "";
        for (int i = 0; i < componentsOfRide.length; i++) {
            rideComp = componentsOfRide[i].toUpperCase();
            if (rideComp.equals("GAS TANK NOT EMPTY")) {
                passInspection[0] = true;
            } else if (rideComp.equals("BRAKES OK")) {
                passInspection[1] = true;
            }
        }
        if (passInspection[0] && passInspection[1]) {
            this.runsSinceInspection = 0;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method that calculates cost for a passenger to ride.
     * @param numOfStops int number of stops
     * @return double cost for passenger to ride to that many stops
     */
    public double costPerPassenger(int numOfStops) {
        return ((numOfStops * 3.0) / stations.length);
    }
    /**
     * Method to determine if passengers fit on the ride and that it can travel some number of stops.
     * @param numOfStops int number of stops
     * @param passengersToAdd String array passenger names to be added
     * @return boolean if all passengers can fit on ride and ride can travel the given number of stops
     */
    @Override
    public boolean addPassengers(int numOfStops, String[] passengersToAdd) {
        int numToAdd = passengersToAdd.length;
        if (numToAdd > numberNullElements(this.passengers)) {
            return false;
        } else {
            int lenCurrent = this.passengers.length;
            for (int i = 0; i < numToAdd; i++) {
                for (int j = 0; j < lenCurrent; j++) {
                    if (passengersToAdd[i] != null && this.passengers[j] == null) {
                        this.passengers[j] = passengersToAdd[i];
                        passengersToAdd[i] = null;
                    }
                }
            }
            earnings += (numToAdd * costPerPassenger(numOfStops));
            moveTrolley(numOfStops);
            return true;
        }
    }
    /**
     * Method to determine if rides are equal.
     * @param   object to compare
     * @return boolean if objects equal
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object.getClass().equals(this.getClass())) {
            Trolley o = (Trolley) object;
            boolean stationNamesEqual = true;
            if (this.stations.length == o.stations.length) {
                for (int i = 0; i < this.stations.length; i++) {
                    if (!(this.stations[i].equals(o.stations[i]))) {
                        stationNamesEqual = false;
                        break;
                    }
                }
            } else {
                stationNamesEqual = false;
            }
            return (this.id.equals(o.id) && this.runsSinceInspection == o.runsSinceInspection
                    && this.currentStation == o.currentStation && stationNamesEqual);
        } else {
            return false;
        }
    }
    /**
     * Method to increase runsSinceInspection for number of loops completed after moving a certain number of stops.
     * @param stationsToMove int number of stations to move
     */
    public void moveTrolley(int stationsToMove) {
        int a = (currentStation + stationsToMove) / stations.length;
        currentStation = (currentStation + stationsToMove) % stations.length;
        runsSinceInspection += a;

    }
    /**
     * Method to create String representation of Ride object.
     * @return String representation of Ride
     */
    @Override
    public String toString() {
        String nextStation = "";
        if (this.currentStation == (this.stations.length - 1)) {
            nextStation = this.stations[0];
        } else {
            nextStation = this.stations[this.currentStation + 1];
        }
        String val = String.format("Trolley %s has driven %d loops and has earned $%.2f. This trolley is at %s."
                                    + " Next up is %s.", this.id, this.runsSinceInspection, this.earnings,
                                    this.stations[currentStation], nextStation);
        return val;
    }
    /**
     * Method counting how many null elemnts in array.
     * @param passengers String array passengers names on roller coaster
     * @return int number of null elements
     */
    private int numberNullElements(String[] array) {
        int nullElements = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                nullElements += 1;
            }
        }
        return nullElements;
    }
}
