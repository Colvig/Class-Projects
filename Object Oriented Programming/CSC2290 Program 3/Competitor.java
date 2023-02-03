public class Competitor {

    // data members
    private int id;
    private String firstName;
    private String lastName;
    private String Character;
    private String vehicle;
    private int[] bestTimes;
    private static int numCompetitors;

    // constructors
    public Competitor() {

    }

    public Competitor(int id, String firstName, String lastName, String Character, String vehicle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Character = Character;
        this.vehicle = vehicle;
        this.bestTimes = new int[4];
    }

    // getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCharacter() {
        return Character;
    }

    public String getVehicle() {
        return vehicle;
    }

    public int getBestTimes(int track) {
        return bestTimes[track];
    }

    public static int getNumCompetitors() {
        return numCompetitors;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCharacter(String Character) {
        this.Character = Character;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setBestTimes(int track, int time) {
        this.bestTimes[track] = time;
    }
    public static void setNumCompetitors(int numCompetitors){
        Competitor.numCompetitors = numCompetitors;
    }
    
    @Override
    public String toString() {
        return "boi";
    }

    ///////////////////////////////////////////////////////////////////
    // to string method
}
