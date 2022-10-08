import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;

class Main {
    public static String nick;
    public static String input;
    public static String fot = "[attack] [defined] [info] [RUN]";
    public static int HP=10;
    public static int armor=0;
    public static int xp=0;
    public static int atk=1;
    public static int lv=0;
    public static int money = 0;
    public static int zhp=2;
    public static int zatk=1;
    public static void main(String[] args) throws InterruptedException {

        Scanner myObj = new Scanner(System.in);
        print("Game Ver.Demo");
        print("Made by " + "apo");
        Thread.sleep(1500);
        print("==Story==");
        print("(Story)");
        print("Hey, What's Your Name?");
        nick();
        Thread.sleep(1800);

        System.out.println("-- " + nick + " INFO --" ); //player info
        System.out.println("HP : " + HP);
        print("Armor : " + armor);
        System.out.println("Xp : " + xp);
        System.out.println("attack : " + atk);
        System.out.println("lv : "+ lv);

        print("\nOK Let's Move"); //game play start
        Thread.sleep(1600);
        print("There is a zombie, let's fight!");
        zombie();
        Thread.sleep(1200);
        zombie();
        print("You Win!");
        print("+1 xp, +5$");
        ++xp;
        money+=5;
        Thread.sleep(1500);
        village("");
    }

    public static String print(String a) {
        System.out.println(a);
        return a;
    }
    public  static String nick() {
        System.out.println("Enter username on input");
        nick = JOptionPane.showInputDialog("nickname");
        System.out.println("Username : " + nick);
        return null;
    }

    public static void gameover() {
        System.out.println( nick + " Died!");
        System.out.println("GAME OVER!");
        System.exit(0); // terminates if lost
    }
    public static String village(String V) {
        print("This village is your town");
        print("[shop] [dungeon] [quest] [(update)] [(update)]");
        V = JOptionPane.showInputDialog("now, where we go?");
        if (V.equals("shop")) {
            Shop();
        } else if (V.equals("dungeon")) {
            dungeon();
        } else if (V.equals("quest")) {
            quest();
        } else {
            print("(UPDATE)");
        }
        return null;
    }
    public static void zombie() throws InterruptedException {
        if (HP > 0) {
            if (zhp > 0) {
                print(fot);
                input = JOptionPane.showInputDialog("Motion");

                if (input.equals("attack")) {
                    --zhp;
                    print("zombie HP -1");
                    System.out.println("Zombie HP : " + zhp);
                } else if (input.equals("defined")) {
                    armor++;
                    print("armor +1");
                    print("armor : " + armor);
                    Thread.sleep(1500);
                    print("zombie attack me! \n armor -1");
                    --armor;
                } else if (input.equals("info")) {
                    print("--zombie--");
                    print("zombie is default monster");
                    print("attack damage : " + zatk);
                    print("HP : " + zhp);
                } else if (input.equals("run")) {
                    gameover();
                }
            } else {
                print("You Win");
            }
        } else {
            gameover();
        }
    }
    public static String Shop() {
        print("Hello, I'm Shop Keeper What Do You Want?");
        print("[(UPDATE)] [(UPDATE)] [(UPDATE)] [(UPDATE)]");
        input=JOptionPane.showInputDialog("select Stuff");
        print("(UPDATE)");
        village("");
        return null;
    }
    public static String dungeon() {
        print("(UPDATE)");
        village("");
        return null;
    }
    public static String quest() {
        print("(UPDATE)");
        village("");
        return null;
    }
}
