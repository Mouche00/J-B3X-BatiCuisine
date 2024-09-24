package UIs.menus;

import utils.Validator;

public class MainMenu extends Menu {

    @Override
    public int prompt() {
        System.out.println("#-------------- Main Menu -------------#"
                + "\nSelect an option:"
                + "\n1 - Create a new project"
                + "\n2 - List all existing projects"
                + "\n3 - Calculate the overall cost of a project"
                + "\n0 - Exit");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                break;
            case 2:

                break;
            default:
                System.out.println("\nInvalid option!\n");
        }
    }
}
