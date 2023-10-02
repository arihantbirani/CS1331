/**
 * Ride class to define a Ride object representing an amusement park ride.
 * @author Arihant Birani
 * @version 1.0
 */
public abstract class Ride {
    protected final String id;
    protected double earnings;
    protected int runsSinceInspection;
    protected String[] passengers;

    /**
     * Constructor that intializes id, runs since inspection, and passengers to parameters and intialized earnings to 0.
     * @param id String identifier for the ride
     * @param runsSinceInspection int number of times the ride ran since last inspection
     * @param passengers String array names of passengers aboard the ride
     */
    public Ride(String id, int runsSinceInspection, String[] passengers) {
        this.id = id;
        this.earnings = 0;
        this.runsSinceInspection = runsSinceInspection;
        int size = passengers.length;
        this.passengers = new String[size];
        for (int i = 0; i < size; i++) {
            this.passengers[i] = passengers[i];
        }
    }
    /**
     * Constructor that intializes id and passengers to parameters and intalized earnings
     * and runs since inspection to 0.
     * @param id String identifier for the ride
     * @param passengers String array names of passengers aboard the ride
     */
    public Ride(String id, String[] passengers) {
        this(id, 0, passengers);
    }
    /**
     * Method to determine if ride can run a certain number of times.
     * @param numberOfRuns int number of runs
     * @return boolean if ride can run that many times before inspection
     */
    public abstract boolean canRun(int numberOfRuns);
    /**
     * Method that determines if ride passes inspection and resets runs.
     * @param componentsOfRide String array components of ride
     * @return boolean if ride passes inspection
     */
    public abstract boolean inspectRide(String[] componentsOfRide);
    /**
     * Method that calculates cost for a passenger to ride.
     * @param numOfStops int number of stops
     * @return double cost for passenger to ride to that many stops
     */
    public abstract double costPerPassenger(int numOfStops);
    /**
     * Method to determine if passengers fit on the ride and that it can travel some number of stops.
     * @param numOfStops int number of stops
     * @param passengersToAdd String array passenger names to be added
     * @return boolean if all passengers can fit on ride and ride can travel the given number of stops
     */
    public abstract boolean addPassengers(int numOfStops, String[] passengersToAdd);
    /**
     * Method creating String representation.
     * @return String a list of passengers
     */
    public String getPassengerList() {
        String list = "Passenger List for " + this.id + ":";
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] != null) {
                list = list + "\n" + this.passengers[i];
            }
        }
        return list;
    }
    /**
     * Method to charge passenger and increases earnings.
     * @param numOfStops int number of stops
     */
    public void chargePassenger(int numOfStops) {
        this.earnings += costPerPassenger(numOfStops);
    }
    /**
     * Method to remove a passenger that has violated rules or doesn't meet ride requirements.
     * @param name String representing name of passeneger to remove
     * @return boolean saying if passenger was on ride
     */
    public boolean removePassenger(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < this.passengers.length; i++) {
            if ((this.passengers[i].toLowerCase()).equals(name)) {
                this.passengers[i] = null;
                return true;
            }
        }
        return false;
    }
    /**
     * Method to determine if rides are equal.
     * @param o Object to compare
     * @return boolean if objects equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass().equals(this.getClass())) {
            Ride object = (Ride) o;
            return (this.id.equals(object.id) && this.runsSinceInspection == object.runsSinceInspection);
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
        String rideString = String.format("%s has run %d times and has earned $%.2f.", this.id,
                            this.runsSinceInspection, this.earnings);
        return rideString;
    }
}