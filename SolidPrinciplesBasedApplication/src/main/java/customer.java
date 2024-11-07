import static java.lang.System.exit;
import java.util.Random;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

/*
// Customer enters their info and phone selection.
// I chose phones as my item to ship from a company like Staples and similar shipping style to Canada Post.
// I felt this was a little to function-style programming. I wrote the functions before I put them into more oop-style.
// Error-handling included.
*/
public class customer {
    private String customerFirstName;
    private String customerLastName;
    private String phoneNumber;
    private String shippingAddress;
    private String phoneSelection;
    private String itemPhone;
    private String email;
    private String companyID;
    int quantity;
    Scanner myObj = new Scanner(System.in);

    public void customerInfo() {

        System.out.println("Enter your first name:");
        this.customerFirstName = myObj.nextLine();

        System.out.println("Enter your second name:");
        customerLastName = myObj.nextLine();

        System.out.println("Enter your phone number with extension #:");
        phoneNumber = myObj.nextLine();

        // I wanted to do some regular expression here for a proper email formatting
        // But I could not figure it out for Java and emails
        System.out.println("Enter e-mail:");
        email = myObj.nextLine();
        //Pattern pattern = Pattern.compile(^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$);
        //Matcher matcher = pattern.matcher(email);

        System.out.println("Enter your full mailing address: ");
        shippingAddress = myObj.nextLine();

        orderingItem();
    }

    public void orderingItem() {
        while (true) {
            while (true) {

                System.out.println("Enter what you want:\n1 - Latest Android Phone\n2 - Cheap Used Android Phone");
                itemPhone = myObj.nextLine();

                if (Objects.equals(itemPhone, "1")) {
                    phoneSelection = "Latest Android Phone";
                    break;
                }
                if (Objects.equals(itemPhone, "2")) {
                    phoneSelection = "Cheap Used Android Phone";
                    break;
                }
                System.out.println("Invalid Option");

                if (Objects.equals(itemPhone, "1") || Objects.equals(itemPhone, "2"))
                    break;
            }

            while(true) {
                System.out.println("Enter Quantity of Phones Needed:");
                try {
                    quantity = Integer.parseInt(myObj.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Error Try again");
                }
            }
            System.out.println("\nSummary of Order\nFull Name: " + customerFirstName + " " + customerLastName +
                    "\nPhone Number: " + phoneNumber + "E-Mail:" + email + "\nCustomer Address: " + shippingAddress +
                    "\nPhone Selection: " + itemPhone + " " + phoneSelection + "\nQauntity: " + quantity);

            selectionChoice();
        }
    }

    void selectionChoice() {

        String option;
        while (true) {
            System.out.println("Continue with order (Y/N): ");
            option = myObj.nextLine();

            if (Objects.equals(option, "Y")){
                System.out.println("Continue with order...");
                break;
            }

            if (Objects.equals(option, "N")) {
                System.out.println("\nStopping the order...\nStarting process again\n");
                break;

            } else {
                System.out.println("Invalid - Try again... ");
            }
        }
        if (Objects.equals(option, "Y"))
            checkAvailability();

        if (Objects.equals(option, "N"))
            customerInfo();
    }

    public void checkAvailability() {

        System.out.println("\nLook for item - check potential places to shop at");

        //new phones, larger quantities
        if (quantity > 4) {
            if (Objects.equals(itemPhone, "1")) {
                System.out.println("ID 1: Buy from Android Manufacturer");
                System.out.println("ID 2: Buy from ABC Manufacturer");

                while (true) {
                    System.out.println("Enter the ID of the company you wish to buy from: ");
                    companyID = myObj.nextLine();

                    if (Objects.equals(companyID, "1") || Objects.equals(companyID, "2")) {
                        System.out.println("Continue with order...");
                        break;
                    } else
                        System.out.println("Invalid...Try again...");
                }
            }
        }

        //used phones, larger quantities
        if (quantity > 6) {
            if (Objects.equals(itemPhone, "2")) {
                System.out.println("ID 3: Buy from the second-hand Android Store");
                System.out.println("ID 4: Buy from the second-hand Phone Store");

                while (true) {
                    System.out.println("Enter the ID of the company you wish to buy from: ");
                    companyID = myObj.nextLine();

                    if (Objects.equals(companyID, "3") || Objects.equals(companyID, "4")) {
                        System.out.println("Continue with order...");
                        break;
                    } else
                        System.out.println("Invalid...Try again...");
                }
            }
        }

        //new phones, small quantities
        if (quantity <= 4) {
            if (Objects.equals(itemPhone, "1")) {
                System.out.println("ID 5: Buy from Best Buy");
                System.out.println("ID 6: Buy from Staples");
                while (true) {
                    System.out.println("Enter the ID of the company you wish to buy from: ");
                    companyID = myObj.nextLine();

                    if (Objects.equals(companyID, "5") || Objects.equals(companyID, "6")) {
                        System.out.println("Continue with order...");
                        break;
                    } else
                        System.out.println("Invalid...Try again...");
                }
            }
        }

        //old phones, small quantities
        if (quantity <= 6) {
            if (Objects.equals(itemPhone, "2")) {

                System.out.println("ID 7: Buy from Kijiji Sellers");
                System.out.println("ID 8: Buy from E-Bay Sellers");
                while (true) {
                    System.out.println("Enter the ID of the company you wish to buy from: ");
                    companyID = myObj.nextLine();

                    if (Objects.equals(companyID, "7") || Objects.equals(companyID, "8")) {
                        System.out.println("Continue with order...");
                        break;
                    } else
                        System.out.println("Invalid...Try again...");
                }
            }
        }
        new store().data(companyID, itemPhone, quantity);
    }
}