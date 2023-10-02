/**
 * RollerCoaster class to define a RollerCoaster object as subclass of Ride.
 * @author Arihant Birani
 * @version 1.0
 */
public class RollerCoaster extends Ride {
    private double rate;
    private double photoFees;
    private int maxNumRuns;
    /**
     * Constructor that intializes id, runsSinceInspection, passengers, rate, photoFees, and maxNumRuns to parameters.
     * @param id String identifier for the ride
     * @param runsSinceInspection int number of times the ride ran since last inspection
     * @param passengers String array names of passengers aboard the ride
     * @param rate double representing the price of one run
     * @param photoFees double representing the total fees to purchase the mandatory photo package
     * @param maxNumRuns int representing the total number of times that the ride can run before it must be inspected
    */
    public RollerCoaster(String id, int runsSinceInspection, String[] passengers, double rate, double photoFees,
                        int maxNumRuns) {
        super(id, runsSinceInspection, passengers);
        this.rate = rate;
        this.photoFees = photoFees;
        this.maxNumRuns = maxNumRuns;
    }
    /**
     * Constructor that intializes id, runsSinceInspection, and maxNumRuns to parameters and intialize passengers,
     * rate, and photoFees to defaults.
     * @param id String representing the identifier for the ride
     * @param runsSinceInspection int representing the number of times the ride has run since the last inspection
     * @param maxNumRuns int representing the total number of times that the ride can run before it must be inspected
     */
    public RollerCoaster(String id, int runsSinceInspection, int maxNumRuns) {
        this(id, runsSinceInspection, new String[4], 10, 15, maxNumRuns);
    }
    /**
     * Constructor that intializes id to parameter.
     * @param id String representing the identifier for the ride
     */
    public RollerCoaster(String id) {
        this(id, 0, 200);
    }
    /**
     * Method to determine if ride can run a certain number of times.
     * @param numberOfRuns int number of runs
     * @return boolean if ride can run that many times before inspection
     */
    @Override
    public boolean canRun(int numberOfRuns) {
        if (numberOfRuns < 0) {
            return false;
        }
        int runsLeft = this.maxNumRuns - this.runsSinceInspection;
        return (numberOfRuns <= runsLeft);
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
            if (rideComp.equals("TRACKS CLEAR")) {
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
    @Override
    public double costPerPassenger(int numOfStops) {
        return ((this.rate * numOfStops) + this.photoFees);
    }
    /**
     * Method to determine if passengers fit on the ride and that it can travel some number of stops.
     * @param numOfStops int number of stops
     * @param passengersToAdd String array passenger names to be added
     * @return boolean if all passengers can fit on ride and ride can travel the given number of stops
     */
    @Override
    public boolean addPassengers(int numOfStops, String[] passengersToAdd) {
        int numToAdd = passengersToAdd.length - numberNullElements(passengersToAdd);
        if (numOfStops > (this.maxNumRuns - this.runsSinceInspection)) {
            return false;
        } else if (numToAdd > numberNullElements(this.passengers)) {
            return false;
        } else {
            int lenCurrent = this.passengers.length;
            int lenAdd = passengersToAdd.length;
            for (int i = 0; i < lenAdd; i++) {
                if (passengersToAdd[i] != null) {
                    for (int j = 0; j < lenCurrent; j++) {
                        if (this.passengers[j] == null) {
                            this.passengers[j] = passengersToAdd[i];
                            passengersToAdd[i] = null;
                            break;
                        }
                    }
                }
            }
            earnings += (numToAdd * costPerPassenger(numOfStops));
            this.runsSinceInspection += numOfStops;
            return true;
        }
    }
    /**
     * Method to determine if rides are equal.
     * @param object Object to compare
     * @return boolean if objects equal
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object.getClass().equals(this.getClass())) {
            RollerCoaster o = (RollerCoaster) object;
            return (this.id.equals(o.id) && this.runsSinceInspection == o.runsSinceInspection
                && this.rate == o.rate && this.photoFees == o.photoFees
                && this.maxNumRuns == o.maxNumRuns);
        } else {
            return false;
        }
    }
    /**
     * Method to create String representation of Ride object.
     * @return String representation of Ride
     */
    @Override
    public String toString() {
        int runsLeft = this.maxNumRuns - this.runsSinceInspection;
        String rideString = String.format("Roller Coaster %s has run %d times and has earned $%.2f. "
                                    + "It can only run " + "%d more "
                                    + "times. It costs $%.2f per ride and there is a one-time photo fee of $%.2f.",
                                    this.id, this.runsSinceInspection, this.earnings, runsLeft, this.rate,
                                    this.photoFees);
        return rideString;
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