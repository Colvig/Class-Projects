public class Stats {
    // Data members
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;

    // Constructors
    public Stats() {
    }

    public Stats(int intelligence, int strength, int stamina, int speed, int skills) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
    }

    // Getters and setters
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }
    
    @Override
    // Method for printing stats
    public String toString() {
        String thing = "";
        thing += String.format("   Stats:        Intelligence: %d\n", intelligence);
        thing += String.format("                 Strength:     %d\n", strength);
        thing += String.format("                 Stamina:      %d\n", stamina);
        thing += String.format("                 Speed:        %d\n", speed);
        thing += String.format("                 Skills:       %d\n", skills);
        return thing;
    }
    
    // Method to calculate a characters combined stats
    public int combinedStats(){
        return intelligence + strength + stamina + speed + skills;
    }
    
    
}
