public class Character {
    // Data members
    private String name;
    private String team;
    private String universe;
    private String homePlanet;
    protected Stats s;
    private static int numCharacters = 0;
    
    // Constructor
    public Character(String name, String team, String universe, String homePlanet, Stats s) {
        this.name = name;
        this.team = team;
        this.universe = universe;
        this.homePlanet = homePlanet;
        this.s = s;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    public Stats getS() {
        return s;
    }

    public void setS(Stats s) {
        this.s = s;
    }

    public static int getNumCharacters() {
        return numCharacters;
    }

    public static void setNumCharacters(int numCharacters) {
        Character.numCharacters = numCharacters;
    }
    
    @Override
    // Method for printing characters info.
    public String toString() {
        String thing = "";
        thing += String.format("   Name:         %s\n", this.getName());
        thing += String.format("   Team:         %s\n", this.getTeam());
        thing += String.format("   Universe:     %s\n", this.getUniverse());
        thing += String.format("   Home Planet:  %s\n", this.getHomePlanet());
        thing += this.getS().toString();
        return thing;
    }
    
}
