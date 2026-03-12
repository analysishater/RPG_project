
public class archy extends player {

    private int nb_arrows = 5;
    private int accuracy = 5;

    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BROWN = "\u001B[38;5;94m";

    public archy(String name) {
        super(name);
        System.out.println(BROWN + "the archy " + name + " joined the game!" + RESET);
        System.out.println(BROWN + "_________________________-----------------------------___________________________" + RESET);
    }

// affichage
    public void affiche_state() {
        // name , level , pva , capacities
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "STATE OF THE ARCHY=" + RESET);
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
        System.out.println(CYAN + "   |     name of the archy is = " + YELLOW + get_name() + CYAN + "          |" + RESET);
        System.out.println(CYAN + "   |     level of the archy is = " + GREEN + get_level() + CYAN + "        |" + RESET);
        System.out.println(CYAN + "   |     life point of the archy is = " + RED + get_pva() + CYAN + "     |" + RESET);
        System.out.println(CYAN + "   |     nb of arrows of the archy is = " + BROWN + nb_arrows + CYAN + "   |" + RESET);
        System.out.println(CYAN + "   |     accuracy of the archy is = " + YELLOW + accuracy + CYAN + "        |" + RESET);

        if (get_capacities("fastness")) {
            System.out.println(CYAN + "   |     and his capacities are =               |" + RESET);
            System.out.println(CYAN + "        fastness" + RESET);
        }
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);

    }

    // attaque
    public void attaque(player p2) {
        System.out.println(RED + "_________________________-----------------------------___________________________" + RESET);
        System.out.println(RED + "ATTAQUE ACTION" + RESET);

        if (nb_arrows == 0) {
            System.out.println(RED + "the archy can not attaque, no enough arrows" + RESET);
        } else {

            if (get_capacities("fastness")) {
                if (accuracy >= 5) {
                    if (p2 instanceof witcher) {
                        System.out.println(RED + "the archy " + get_name() + " attaqued the witcher " + p2.get_name() + " with deadly arrows" + RESET);
                    } else {
                        if (p2 instanceof archy) {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the archy " + p2.get_name() + " with deadly arrows" + RESET);
                        } else {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the warrior " + p2.get_name() + " with deadly arrows" + RESET);
                        }
                    }
                    p2.subir_degat(5);
                    nb_arrows = nb_arrows - 1;

                } else {
                    if (nb_arrows >= 2) {
                        if (p2 instanceof witcher) {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the witcher " + p2.get_name() + RESET);
                        } else {
                            if (p2 instanceof archy) {
                                System.out.println(RED + "the archy " + get_name() + " attaqued the archy " + p2.get_name() + RESET);
                            } else {
                                System.out.println(RED + "the archy " + get_name() + " attaqued the warrior " + p2.get_name() + RESET);
                            }
                        }
                        p2.subir_degat(2);
                        nb_arrows = nb_arrows - 2;
                        accuracy = accuracy + 2;

                    } else {
                        System.out.println(RED + "the archy can not attaque, no enough arrows" + RESET);
                    }
                }

            } else {//no fastness capacity
                if (accuracy >= 5) {
                    if (p2 instanceof witcher) {
                        System.out.println(RED + "the archy " + get_name() + " attaqued the witcher " + p2.get_name() + RESET);
                    } else {
                        if (p2 instanceof archy) {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the archy " + p2.get_name() + RESET);
                        } else {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the warrior " + p2.get_name() + RESET);
                        }
                    }
                    p2.subir_degat(2);
                    nb_arrows = nb_arrows - 1;

                } else {
                    if (nb_arrows >= 3) {
                        if (p2 instanceof witcher) {
                            System.out.println(RED + "the archy " + get_name() + " attaqued the witcher " + p2.get_name() + RESET);
                        } else {
                            if (p2 instanceof archy) {
                                System.out.println(RED + "the archy " + get_name() + " attaqued the archy " + p2.get_name() + RESET);
                            } else {
                                System.out.println(RED + "the archy " + get_name() + " attaqued the warrior " + p2.get_name() + RESET);
                            }
                        }
                        p2.subir_degat(1);
                        nb_arrows = nb_arrows - 3;

                    } else {
                        System.out.println(RED + "the archy can not attaque, no enough arrows" + RESET);
                    }

                }

            }

            if (p2.get_pva() == 0) {
                int life = get_pva();
                if (life < pvm - 1) {
                    life = life + 2;
                    setpva(life);
                    System.out.println(GREEN + "the archy " + get_name() + " gained two life points!" + RESET);
                } else {
                    nb_arrows = nb_arrows + 5;
                    System.out.println(BROWN + "the archy " + get_name() + " increased the number of arrows!" + RESET);
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

        if (get_pva() > 5) {
            int life = get_level();
            if (life == max_level) {
                if (!(get_capacities("fastness"))) {

                    add_capacity("fastness");
                    System.out.println(PURPLE + "the archy " + get_name() + " got the fastness capacity!" + RESET);

                } else {
                    accuracy = accuracy + 5;
                    System.out.println(PURPLE + "the archy " + get_name() + " increased his throws accuracy!" + RESET);
                }

            } else {
                life = life + 1;
                if (life <= max_level) {
                    set_level(life);
                    System.out.println(PURPLE + "the archy " + get_name() + " leveled up!" + RESET);
                }
            }
            life = get_pva();
            life = life - 5;
            setpva(life);
            affiche_state();
        } else {
            System.out.println(RED + "the archy " + get_name() + " can not evaluate, no enough life points!" + RESET);
        }
        System.out.println(PURPLE + "_________________________-----------------------------___________________________" + RESET);

    }

    public void healed() {
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
        if (get_pva() == 10) {
            accuracy = accuracy + 3;
            System.out.println(GREEN + "the archy " + get_name() + " increased his throws accuracy, he is healed!" + RESET);
        } else {

            int life = 10;
            setpva(life);
            System.out.println(GREEN + "the archy " + get_name() + " increased his life score, he is healed!" + RESET);
        }
        affiche_state();
        System.out.println(GREEN + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

    // sibir un degat
    public void subir_degat(int degree) {
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
        int life = get_pva();
        if (degree >= 5) {

            if (life > 3) {

                life = life - 3;
                setpva(life);
                System.out.println(RED + "the archy " + get_name() + " lost three life points" + RESET);

            } else {
                setpva(0);
                System.out.println(RED + "the archy " + get_name() + " died from the attaque" + RESET);
            }
        } else {
            if (life > 1) {
                setpva(life - 1);
                System.out.println(RED + "the archy " + get_name() + " lost one life point" + RESET);

            } else {
                setpva(0);
                System.out.println(RED + "the archy " + get_name() + " died from the attaque" + RESET);
            }
        }

        affiche_state();
        System.out.println(RED + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + RESET);
    }

}
