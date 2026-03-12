
import java.util.Scanner;

public class execution {

    public static void main(String[] args) {

        System.out.println("\n                                                            WELCOME TO THE WAR GAME! \n");
        System.out.println("                            * We would like to introduce our characters to you: the Warrior, the Witcher and the Archy.");
        System.out.println("                                       * To start the game, you must specify a name for each character.");
        System.out.println("                                                          * SO, LET'S START!");

        // Create Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask for warrior name
        System.out.print("\n               Enter warrior name: ");
        String name = scanner.nextLine();
        warrior w = new warrior(name);

        // Ask for witcher name
        System.out.print("\n               Enter witcher name: ");
        name = scanner.nextLine();
        witcher wi = new witcher(name);

        // Ask for archy name
        System.out.print("\n               Enter archy name: ");
        name = scanner.nextLine();
        archy a = new archy(name);

        int r = 1;
        int life;
        int life2;
        while (r < 4) {
            if (r == 1) {
                w.attaque(wi);
                life = wi.get_pva();
                if (life == 0) {
                    w.evolution();
                    System.out.println("\n                                         WE MOVE TO THE THIRD ROUND!");
                    r = 3;
                } else {
                    wi.evolution();
                    w.evolution();
                    wi.attaque(w);

                    System.out.println("\n                                         WE MOVE TO THE SECOND ROUND!");
                    r = 2;

                }

            } else {
                if (r == 2) {
                    wi.attaque(a);
                    life = a.get_pva();
                    if (life == 0) {
                        wi.evolution();
                        break;
                    } else {
                        wi.evolution();
                        a.evolution();
                        a.attaque(wi);
                        System.out.println("\n                                         WE MOVE TO THE THIRD ROUND!");
                        r = 3;
                    }
                } else {
                    life = a.get_pva();
                    life2 = a.get_pva();
                    if (life == 0 || life2 == 0) {
                        break;
                    } else {

                        w.attaque(a);
                        life = a.get_pva();
                        if (life == 0) {
                            break;
                        } else {
                            life = wi.get_pva();
                            if (life == 0) {
                                a.evolution();
                                w.evolution();
                                a.attaque(w);
                                r = 4;
                            } else {
                                wi.healing(a);
                                w.evolution();
                                a.attaque(w);
                                r = 4;
                            }
                        }
                    }

                }

            }

        }

        System.out.println("\n                                        GAME OVER!                    \n");

    }

}
