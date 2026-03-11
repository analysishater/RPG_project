package RPG;

public class warrior extends player {

    private int strengh = 5;
    private int defense = 5;

    public warrior(String name) {
        super(name);
    }

    public boolean state() {
        if (get_pva() == 0) {
            return false;
        } else {
            if (get_pva() <= 2) {
                System.out.println("the warrior" + get_name() + " is about dying");
            }
            return true;
        }
    }

    public void healed() {
        if (get_pva() == 10) {
            System.out.println("the warrior" + get_name() + "is with full health score");
        } else {

            int life = 10;
            setpva(life);
            System.out.println("the warrior" + get_name() + "is healed");
        }
    }

    public void attaque(player p2) {
        if (get_capacities("attaque")) {
            p2.subir_degat(5);
        } else {
            if (strengh >= 3) {
                p2.subir_degat(3);
            } else {
                p2.subir_degat(1);
            }

        }

        if (p2 instanceof witcher) {
            System.out.println("the warrior" + get_name() + "hitted the witcher " + p2.get_name());
        } else {
            if (p2 instanceof archy) {
                System.out.println("the warrior " + get_name() + "hitted the archy" + p2.get_name());
            } else {
                System.out.println("the warrior " + get_name() + "hitted the warrior" + p2.get_name());
            }
        }

        if (p2.get_pva() == 0) {
            int life = get_level();
            if (life < max_level) {
                life = life + 1;
                set_level(life);
            } else {
                if (!(get_capacities("defense"))) {
                    add_capacity("defense");
                }
            }
        }

    }

    public void evolution() {
        int life = get_level();
        if (life == max_level) {
            if (get_capacities("strengh")) {
                if (!(get_capacities("defense"))) {
                    add_capacity("defense");
                }
            } else {
                add_capacity("strengh");
            }
        } else {
            life = life + 1;
            if (life <= max_level) {
                set_level(life);
            }
        }

    }

    public void subir_degat(int degree) {
        if (get_pva() > 0) {

            if (get_capacities("defense")) {
                System.out.println("the warrior " + get_name() + " stricked the attaque with defense capacity");
            } else {
                if (defense >= degree) {
                    System.out.println("the warrior " + get_name() + " stricked the attaque with defense characteristic");
                    defense = defense - degree;
                } else {
                    if (strengh > 0) {
                        strengh = strengh - 1;
                        System.out.println("the warrior" + get_name() + "  stricked the attaque with decreasing strengh");

                    } else {

                        System.out.println("the warrior" + get_name() + " did not strick the attaque");
                        defense = 5;
                        int life = get_pva();
                        life = life - 1;
                        setpva(life);
                    }

                }
            }

        } else {
            System.out.println("can not attaque a died warrior");
        }

    }

}
