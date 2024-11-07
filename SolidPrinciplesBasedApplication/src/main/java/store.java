import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/*
// Child class
// Store does their verification on items, process the credit card and ships items.
// I do pass on the Company ID for cargo dealer or regular store.
// The companyID, itemPhone, quantity for proper payment.
// I followed my UML, but I did break down some functions due to being so large.
// Error-handling included.
*/
public class store extends customer {
    Random rand = new Random();
    int shippingHubRates = 10;
    int CreditCardNumber;
    int CreditCardCVC;
    String creditCardPostalCode;
    String creditCardName;
    String companyID;
    String itemPhones;
    int quantities;
    Scanner myObj = new Scanner(System.in);
    void data(String companyIDs, String itemPhone, int quantity) {
        companyID = companyIDs;
        itemPhones = itemPhone;
        quantities = quantity;
        System.out.println("\nSelected Company ID: " + companyID + "\nSelected Phone Type: " + itemPhones + "\nQuantity: " + quantities + "\n");
        reviews();
    }

    public void reviews() {
        int rand_int1 = rand.nextInt(6);
        switch (rand_int1) {
            case 0:
                System.out.println("0 Star Rating");
                break;

            case 1:
                System.out.println("1 Star Rating");
                break;

            case 2:
                System.out.println("2 Star Rating");
                break;

            case 3:
                System.out.println("3 Star Rating");
                break;

            case 4:
                System.out.println("4 Star Rating");
                break;

            case 5:
                System.out.println("5 Star Rating");
                break;

            default:
                System.out.println("No Proper Rating Yet!");
        }
        pickupTicket();
    }

    public void pickupTicket() {
        checkStoreAvailability();
        shipmentCost();
        processOrder();
        //choice where the phone come from
        switch (companyID) {
            case "1":
            case "2":
                cargoManufacturingDealer();

            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
                new shipment().orderShipment();

            default:
                System.out.println("Error - Try Again");
        }
    }
    public void checkStoreAvailability() {
        System.out.println("Enough phones in stock.\n");
    }

    void shipmentCost(){
        if(Objects.equals(itemPhones, "1")){
            System.out.println("New Phones Cost $1,000 each...\nTotal Phone Cost: $" + 1000*quantities);
        }

        if(Objects.equals(itemPhones, "2")){
            System.out.println("Old Phones Cost $100 each...\nTotal Phone Cost: $" + 100*quantities);
        }
    }
    public void processOrder(){
        while(true) {
            System.out.println("Enter Credit Card Number: ");
            try {
                CreditCardNumber = Integer.parseInt(myObj.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error Try again");
            }
        }

        while(true) {
            System.out.println("Enter Credit Card CVC: ");
            try {
                CreditCardCVC = Integer.parseInt(myObj.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error Try again");
            }
        }

        System.out.println("Enter Credit Card Postal Code: ");
        creditCardPostalCode = myObj.nextLine();

        System.out.println("Enter Credit Card Name: ");
        creditCardName = myObj.nextLine();

        System.out.println("Payment Processed - E-mail receipt sent.");
    }

    public void cargoManufacturingDealer() {

        String selection;

        while (true) {
            System.out.println("\n1 - Postpone order\n2 - Order Phone(s) now");
            selection = myObj.nextLine();

            if (Objects.equals(selection, "1") || Objects.equals(selection, "2"))
                break;
            else
                System.out.println("Invalid...Try again...");
        }

        switch (selection) {
            case "1":
                //postpone order
                manageStock();

            case "2":
                hubPayment();

            default:
                System.out.println("Error - Try Again");
        }
    }

    public void manageStock() {
        System.out.println("\nPostponing order - we will contact you later about delivery.\nExiting Program\n");
        exit(0);
    }

    public void hubPayment(){
        System.out.println("\nHub rate is $10 per phone.\nWith " + quantities + " phones, the cost is $" + shippingHubRates*quantities);
        System.out.println("Payment Processed\n");
        new shipment().dispatchOrder();
    }
}
