import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/*
// Deals with shipment for the item from the store to the user.
// One random number for delivery and one random number for the return
// I did not do as detailed as I would have liked, but it works and I spent a lot of time on this assignment.
// Error-handling included.
*/
public class shipment extends customer {
    Random r = new Random();
    int low = 100000000;
    int high = 1000000000;
    int trackingNumber = r.nextInt(high-low) + low;
    Scanner myObj = new Scanner(System.in);
    public void orderShipment() {
        //order is getting ready to be shipped
        System.out.print("\nOrder is Picked and is being processed.\n\n");
        packageDetails();
    }

    public void packageDetails() {
        String location = "Package ready at facility for courier pickup.";
        trackOrder(location);
        deliveryDetails();
    }

    public void deliveryDetails() {
        dispatchOrder();
    }

    public void dispatchOrder() {
        String location = "Parcel is on its way!";
        trackOrder(location);
        deliverOrder();
    }

    public void deliverOrder() {
        String location = "Delivered!";
        trackOrder(location);
        received();
    }

    public void received() {
        int choice = 0;

        while(true) {

            System.out.println("What do you do now with the parcel?\n1-Return Order!\n2-Order come as expected!\n3-Other");
            try {
                choice = Integer.parseInt(myObj.nextLine());
            } catch (Exception e) {
                System.out.println("Use an integer.");
            }

            switch (choice) {
                //we should be able to track at any time
                case 1:
                    //order issue
                    returnOrder();

                case 2:
                    //order is fine
                    System.out.print("Exiting Program.\n");
                    exit(1);

                case 3:
                    System.out.print("We will contact you shortly for more info.\n");
                    exit(1);

                default:
                    System.out.println("Error - Try Again.\n");
            }
        }
    }
    public void returnOrder() {
        String location = "Order is returned.\nRefund given.\n";
        trackingNumber = r.nextInt(high-low) + low;
        trackOrder(location);
        exit(1);
    }
    public void trackOrder(String location) {
        //add next tracking number function - but I just set it to something for now
        //pass strings to know location - display here

        System.out.println("Your order has a tracking number of " + trackingNumber);
        System.out.println(location + "\n");
    }
}