import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 10/30/13
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        ContactList list = new ContactList("Contacts.txt");
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Contact Manager!");

        do{
            System.out.println("-------------------");
            System.out.println("Do you want to:\n1) See all contacts\n2)See a specific contact\n3)Enter a new contact\n4+)Quit");
            int userInput = Integer.parseInt(input.nextLine());

            switch(userInput){
                case 1:
                    System.out.println("-------------------");
                    System.out.println("All contacts:");
                    list.listContactNames();
                    break;
                case 2:
                    System.out.println("-------------------");
                    System.out.println("Enter the name of the contact that you wish to see");
                    String userInput2 = input.nextLine();
                    System.out.println("-------------------");
                    list.getContact(userInput2);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("-------------------");
                    System.out.println("Enter the name, then the email, and the number in order to add the contact");
                    String name = input.nextLine();
                    String email = input.nextLine();
                    String number = input.nextLine();
                    list.addContact(name, email, number);
                    System.out.println("-------------------");
                    System.out.println("\n" + name + "'s Contact has been added:\n" + list.getContact(name));
                    break;
                default:
                    System.out.println("-------------------");
                    System.out.println("Goodbye.");
                    exit = true;
                    break;
            }
        }while(exit == false);
    }
}
