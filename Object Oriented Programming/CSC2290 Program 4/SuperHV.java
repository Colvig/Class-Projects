import java.util.*;
public class SuperHV extends Character {
    private ArrayList<String> powers;

    // Constructors
    public SuperHV(String name, String team, String universe, String homePlanet, Stats s, ArrayList<String> powers) {
        super(name, team, universe, homePlanet, s);
        this.powers = powers;
    }
    
    // getter
    public ArrayList<String> getPowers() {
        return powers;
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
        thing += String.format("   Powers:       %s\n", powers.toString().replace("[","").replace("]",""));
        return thing;
    }
    
    // Calculating a characters points for each super power they have for the fight method in Marvel_vs_DC.
    public int combinedPowers(){
        return powers.size()*10;
    }
}
