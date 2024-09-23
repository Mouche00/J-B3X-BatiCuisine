package UIs;

import java.util.Scanner;

abstract public class Menu {
    protected final int EXIT_OPTION = 0;

    protected Scanner scanner = new Scanner(System.in);

    abstract int prompt();
    abstract void choice(int option);
    public void menu(){
        int option;
        do {
            option = prompt();
            choice(option);
        } while(option != EXIT_OPTION);
    }
}
