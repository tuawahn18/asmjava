package Asm;

import java.util.Scanner;

public class Main {
    private static PostManager postManager = new PostManager();
    public static void main(String[] args) {
        createMenu();
    }

    public static void createMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------ MENU ------");
            System.out.println("1. Create Post\n" + "2. Show Post\n" + "3. Search Post\n" + "4. Delete Post\n" + "0. Exit");
            System.out.println("------------------");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    postManager.add();
                    break;
                case 2:
                    postManager.show();
                    break;
                case 3:
                    postManager.search();
                    break;
                case 4:
                    postManager.remove();
                    break;
                case 0:
                    System.out.println("Thank you for using");
                    break;
                default:
                    System.out.println("Please, Enter a choice from 0 to 4 ");
                    break;
            }
        } while (choice != 0);
//                Kết thúc chương trình

    }
}
