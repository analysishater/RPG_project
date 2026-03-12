
public class warrior extends player {

    private int strengh = 5;
    private int defense = 5;

    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public warrior(String name) {

        super(name);
        System.out.println(CYAN + "the warrior " + name + " joined the game!" + RESET);
        System.out.println(CYAN + "_________________________-----------------------------___________________________" + RESET);
    }

    public void healed() {
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
        if (get_pva() == 10) {
            strengh = strengh + 3;
            System.out.println(GREEN + "the warrior " + get_name() + " increased his strengh, he is healed" + RESET);
        } else {

            int life = 10;
            setpva(life);
            System.out.println(GREEN + "the warrior " + get_name() + " is healed" + RESET);
        }
        affiche_state();
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

    public void attaque(player p2) {
        System.out.println(RED + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(RED + "ATTAQUE ACTION" + RESET);

        if (get_capacities("attaque")) {

            if (p2 instanceof witcher) {
                System.out.println(RED + "the warrior " + get_name() + " hitted the witcher " + p2.get_name() + RESET);
            } else {
                if (p2 instanceof archy) {
                    System.out.println(RED + "the warrior " + get_name() + " hitted the archy " + p2.get_name() + RESET);
                } else {
                    System.out.println(RED + "the warrior " + get_name() + " hitted the warrior " + p2.get_name() + RESET);
                }
            }
            p2.subir_degat(5);
        } else {
            if (strengh >= 3) {

                if (p2 instanceof witcher) {
                    System.out.println(RED + "the warrior " + get_name() + " hitted the witcher " + p2.get_name() + RESET);
                } else {
                    if (p2 instanceof archy) {
                        System.out.println(RED + "the warrior " + get_name() + " hitted the archy " + p2.get_name() + RESET);
                    } else {
                        System.out.println(RED + "the warrior " + get_name() + " hitted the warrior " + p2.get_name() + RESET);
                    }
                }
                p2.subir_degat(3);
                strengh = strengh - 2;
            } else {
                if (strengh >= 1) {

                    if (p2 instanceof witcher) {
                        System.out.println(RED + "the warrior " + get_name() + " hitted the witcher " + p2.get_name() + RESET);
                    } else {
                        if (p2 instanceof archy) {
                            System.out.println(RED + "the warrior " + get_name() + " hitted the archy " + p2.get_name() + RESET);
                        } else {
                            System.out.println(RED + "the warrior " + get_name() + " hitted the warrior " + p2.get_name() + RESET);
                        }
                    }
                    p2.subir_degat(1);
                    strengh = strengh - 1;
                } else {

                    if (p2 instanceof witcher) {
                        System.out.println(RED + "the warrior " + get_name() + " can not attaque the witcher " + p2.get_name() + RESET);
                    } else {
                        if (p2 instanceof archy) {
                            System.out.println(RED + "the warrior " + get_name() + " can not attaque the archy " + p2.get_name() + RESET);
                        } else {
                            System.out.println(RED + "the warrior " + get_name() + " can not attaque the warrior " + p2.get_name() + RESET);
                        }
                    }

                }
            }

        }

        if (p2.get_pva() == 0) {
            int life = get_pva();
            if (life < pvm) {
                life = life + 2;
                setpva(life);
                System.out.println(GREEN + "the warrior " + get_name() + " gained two life points!" + RESET);
            } else {
                defense = defense + 3;
                System.out.println(BLUE + "the warrior " + get_name() + " increased the defense score!" + RESET);
            }
        }
        affiche_state();
        System.out.println(RED + "_________________________-----------------------------___________________________" + RESET);
    }

    public void evolution() {
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(PURPLE + "EVOLUTION ACTION" + RESET);
        int life = get_pva();
        if (life > 3) {
            life = get_level();
            if (life == max_level) {
                if (get_capacities("strengh")) {
                    if (!(get_capacities("defense"))) {
                        add_capacity("defense");
                        System.out.println(PURPLE + "the warrior " + get_name() + " got the defense capacity!" + RESET);
                    }
                } else {
                    if (strengh < 10) {
                        strengh = strengh + 5;
                        System.out.println(PURPLE + "the warrior " + get_name() + " increased his strengh!" + RESET);
                    } else {
                        add_capacity("strengh");
                        System.out.println(PURPLE + "the warrior " + get_name() + " got the strengh capacity!" + RESET);
                    }

                }
            } else {
                life = life + 1;
                if (life <= max_level) {
                    set_level(life);
                    System.out.println(PURPLE + "the warrior " + get_name() + " leveled up!" + RESET);
                }
            }
            life = get_pva();
            life = life - 3;
            setpva(life);
            affiche_state();
        } else {
            System.out.println(RED + "the warrior " + get_name() + " can not evaluate, no enough life point!" + RESET);
        }
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);
    }

    public void subir_degat(int degree) {
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);

        if (get_capacities("defense")) {
            System.out.println(BLUE + "the warrior " + get_name() + " stricked the attaque with defense capacity" + RESET);
        } else {
            if (defense >= degree) {
                System.out.println(BLUE + "the warrior " + get_name() + " stricked the attaque with defense characteristic" + RESET);
                defense = defense - degree;
            } else {
                if (strengh > 0) {
                    strengh = strengh - 1;
                    defense = 0;
                    System.out.println(YELLOW + "the warrior " + get_name() + " stricked the attaque with decreasing strengh" + RESET);

                } else {

                    System.out.println(RED + "the warrior " + get_name() + " did not strick the attaque" + RESET);
                    defense = 5;
                    strengh = 3;
                    int life = get_pva();
                    life = life - 1;
                    setpva(life);
                    if (life == 0) {
                        System.out.println(RED + "the warrior " + get_name() + " died from the attaque" + RESET);
                    }
                }

            }
        }

        affiche_state();
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

    public void affiche_state() {
        // name , level , pva , capacities
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "STATE OF THE WARRIOR=" + RESET);
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "   |     name of the warrior is = " + YELLOW + get_name() + CYAN + "          |" + RESET);
        System.out.println(CYAN + "   |     level of the warrior is = " + GREEN + get_level() + CYAN + "        |" + RESET);
        System.out.println(CYAN + "   |     life point of the warrior is= " + RED + get_pva() + CYAN + "     |" + RESET);
        System.out.println(CYAN + "   |     defense point of the warrior is= " + BLUE + defense + CYAN + "     |" + RESET);
        System.out.println(CYAN + "   |     attack point of the warrior is= " + YELLOW + strengh + CYAN + "      |" + RESET);

        if (get_capacities("defense") || get_capacities("attaque")) {
            System.out.println(CYAN + "   |     and its capacities are =               |" + RESET);
            if (get_capacities("defense")) {
                System.out.println(CYAN + "        defense" + RESET);
            }
            if (get_capacities("attaque")) {
                System.out.println(CYAN + "        attaque" + RESET);
            }
        }
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
    }
}
