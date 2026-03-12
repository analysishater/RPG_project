
import java.util.HashSet;

abstract public class player {

    private String name;
    private int level = 1;
    public final static int max_level = 20;
    private int pva = 5;//point de vie actuel
    public final static int pvm = 10;//point de vie maximal 
    private HashSet<String> capacities = new HashSet<>();// to store capacities

    public player(String name) {
        this.name = name;//if extands we use super directly
    }

    public boolean state() {
        if (get_pva() == 0) {
            return false;
        } else {
            return true;
        }
    }

    //subir degat
    abstract public void subir_degat(int degree);

    //attaque
    abstract public void attaque(player p2);

    // afficher les infos
    abstract public void affiche_state();

    // evolution abstract
    abstract public void evolution();

    abstract public void healed();

    // getters
    //getter of pva
    public int get_pva() {
        return pva;
    }

    //getter of level
    public int get_level() {
        return level;
    }

    //getter of name
    public String get_name() {
        return name;
    }

    //getter of capacities
    public boolean get_capacities(String capacite) {
        for (String capacity : capacities) {
            if (capacite.equals(capacity)) {
                return true;
            }

        }
        return false;
    }

    // end getters 
    // setters
    public void setpva(int life) {
        pva = life;
    }

    // adding capacities
    public void add_capacity(String c) {
        capacities.add(c);
    }//depending the character

    //level
    public void set_level(int life) {
        level = life;
    }

    // incerement level 
    public void increment_level() {
        int life;
        if (get_level() == max_level) {
            System.out.println("can not reach more levels");
        } else {
            life = get_level();
            life = life + 1;
            set_level(life);
        }

    }

}
