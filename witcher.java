
public class witcher extends player {

    private int mana = 10;

    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public witcher(String name) {

        super(name);
        System.out.println(PURPLE + "the witcher " + name + " joined the game!" + RESET);
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);
    }

    // affichage de state
    public void affiche_state() {
        // name , level , pva , capacities
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "STATE OF THE WITCHER=" + RESET);
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "   |     name of the witcher is = " + YELLOW + get_name() + CYAN + "          |" + RESET);
        System.out.println(CYAN + "   |     level of the witcher is = " + GREEN + get_level() + CYAN + "        |" + RESET);
        System.out.println(CYAN + "   |     life point of the witcher is = " + RED + get_pva() + CYAN + "     |" + RESET);
        System.out.println(CYAN + "   |     mana points of the witcher is = " + BLUE + mana + CYAN + "           |" + RESET);

        if (get_capacities("defense") || get_capacities("healing")) {
            System.out.println(CYAN + "   |     and its capacities are =               |" + RESET);
            if (get_capacities("defense")) {
                System.out.println(CYAN + "        defense" + RESET);
            }
            if (get_capacities("healing")) {
                System.out.println(CYAN + "        healing" + RESET);
            }

        }
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);

    }

    public void attaque(player p2) {
        System.out.println(RED + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(RED + "ATTAQUE ACTION" + RESET);
        if (mana == 0) {
            System.out.println(RED + "the witcher can not attaque, no enough mana" + RESET);
        } else {
            if (mana > 6) {
                mana = mana - 4;
                if (p2 instanceof witcher) {
                    System.out.println(RED + "the witcher " + get_name() + " attaqued the witcher " + p2.get_name() + RESET);
                } else {
                    if (p2 instanceof archy) {
                        System.out.println(RED + "the witcher " + get_name() + " attaqued the archy " + p2.get_name() + RESET);
                    } else {
                        System.out.println(RED + "the witcher " + get_name() + " attaqued the warrior " + p2.get_name() + RESET);
                    }
                }
                p2.subir_degat(5);
            } else {
                mana = mana - 2;
                if (p2 instanceof witcher) {
                    System.out.println(RED + "the witcher " + get_name() + " attaqued the witcher " + p2.get_name() + RESET);
                } else {
                    if (p2 instanceof archy) {
                        System.out.println(RED + "the witcher " + get_name() + " attaqued the archy " + p2.get_name() + RESET);
                    } else {
                        System.out.println(RED + "the witcher " + get_name() + " attaqued the warrior " + p2.get_name() + RESET);
                    }
                }
                p2.subir_degat(2);
            }

            if (p2.get_pva() == 0) {
                int life = get_pva();
                if (life < pvm - 1) {
                    life = life + 2;
                    setpva(life);
                    System.out.println(GREEN + "the witcher " + get_name() + " gained two life points!" + RESET);
                } else {
                    mana = mana + 3;
                    System.out.println(BLUE + "the witcher " + get_name() + " increased the mana score!" + RESET);
                }
            }
            affiche_state();
        }
        System.out.println(RED + "_________________________-----------------------------___________________________" + RESET);

    }

// evolution
    public void evolution() {
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(PURPLE + "EVOLUTION ACTION" + RESET);
        if (mana >= 10) {
            int life = get_level();
            if (life == max_level) {
                if (get_capacities("healing")) {
                    if (!(get_capacities("defense"))) {
                        add_capacity("defense");
                        System.out.println(PURPLE + "the witcher " + get_name() + " got the defense capacity!" + RESET);
                    }
                } else {

                    add_capacity("healing");
                    System.out.println(PURPLE + "the witcher " + get_name() + " got the healing capacity!" + RESET);
                }

            } else {
                life = life + 1;
                if (life <= max_level) {
                    set_level(life);
                    System.out.println(PURPLE + "the witcher " + get_name() + " leveled up!" + RESET);
                }
            }

            mana = mana - 10;
            affiche_state();
        } else {
            System.out.println(RED + "the witcher " + get_name() + " can not evaluate, no enough mana point!" + RESET);
        }
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);

    }

    public void healed() {
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
        int life = get_pva();
        if (life == 10) {
            mana = mana + 3;
            System.out.println(GREEN + "the witcher " + get_name() + " increased his mana, he is healed" + RESET);
        } else {

            life = 10;
            setpva(life);
            System.out.println(GREEN + "the witcher " + get_name() + " is increased his life score, he is healed" + RESET);
        }
        affiche_state();
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

    // healing
    public void healing(player p2) {
        System.out.println(GREEN + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(GREEN + "HEALING ACTION" + RESET);

        if (get_capacities("healing")) {
            System.out.println(GREEN + "the witcher " + get_name() + " is healing the player " + p2.get_name() + " with the magician tool" + RESET);
            p2.healed();
        } else {
            if (mana >= 3) {
                mana = mana - 3;
                System.out.println(GREEN + "the witcher " + get_name() + " is healing the player " + p2.get_name() + " with mana energy" + RESET);
                p2.healed();
                affiche_state();
            } else {
                System.out.println(RED + "the witcher " + get_name() + " can not heal the player " + p2.get_name() + ", no enough mana" + RESET);
            }
        }
        System.out.println(GREEN + "_________________________-----------------------------___________________________" + RESET);
    }

// sibir un degat
    public void subir_degat(int degree) {
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);

        if (get_capacities("defense")) {
            System.out.println(BLUE + "the witcher " + get_name() + " stricked the attaque with defense capacity" + RESET);
        } else {
            if (mana >= degree) {
                System.out.println(BLUE + "the witcher " + get_name() + " stricked the attaque with mana defense" + RESET);
                mana = mana - degree;
            } else {
                int manny = degree - mana;
                mana = 0;
                int life = get_pva();
                if (life > manny) {
                    life = life - 1;
                    setpva(life);
                    System.out.println(RED + "the witcher " + get_name() + " did not strick the attaque" + RESET);
                    if (life == 0) {
                        System.out.println(RED + "the witcher " + get_name() + " died from the attaque" + RESET);
                    }

                } else {
                    setpva(0);
                    System.out.println(RED + "the witcher " + get_name() + " died from the attaque" + RESET);

                }

            }
        }

        affiche_state();
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

}
