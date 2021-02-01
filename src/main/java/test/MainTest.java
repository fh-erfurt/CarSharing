package test;

import data.Locations;
import data.Requests;
import data.Users;
import model.location.Location;
import model.user.User;

public final class MainTest {

    /**
     * For the testing purpose, the MainTest class
     * will create 5 customers and 5 drivers, as well as their locations.
     * Further on, one customer will start, and end a ride with a driver
     */

    public static void startTest()
    {
        Users.init();
        Locations.init();

        User dummyuser;
        Location dummyLocation;

        double dummyLat = 50.971076;
        double dummyLong = 11.037831;

        //add customers
        for (int i = 1 ; i <= 5 ; i++)
        {
            dummyLocation = new Location(String.valueOf(i),dummyLat+=1,dummyLong+=1);

            Locations.updateCustomerLocation(String.valueOf(i),dummyLocation);

            dummyuser = new User("testuser"+i,"passwort"+i,"dummyuser"+i+"@test.de","testURL"+i,String.valueOf(i),"0"+i);
            Users.addCustomer(dummyuser);
        }

        User dummydriver;

        //add drivers
        for (int i = 6 ; i <= 10 ; i++)
        {
            dummyLocation = new Location(String.valueOf(i),dummyLat++,dummyLong++);

            Locations.updateDriverLocation(String.valueOf(i),dummyLocation);

            dummydriver = new User("testdriver"+i,"passwort"+i,"dummydriver"+i+"@test.de","testURL"+i,String.valueOf(i),"0"+i);
            Users.addDriver(dummydriver);
        }

        System.out.println("All Customers with Location:");

        for (int i = 1 ; i <= 5 ; i++)
        {
            System.out.println(Users.getCustomer(String.valueOf(i)).getDisplayName());
            System.out.println("Lat: "+Locations.getCustomerLocation(String.valueOf(i)).getLatitude()+" Long: "+Locations.getCustomerLocation(String.valueOf(i)).getLongitude());
        }

        System.out.println("All Drivers with Location:");

        for (int i = 6 ; i <= 10 ; i++)
        {
            System.out.println(Users.getDriver(String.valueOf(i)).getDisplayName());
            System.out.println("Lat: "+Locations.getDriverLocation(String.valueOf(i)).getLatitude()+" Long: "+Locations.getDriverLocation(String.valueOf(i)).getLongitude());
        }


        Requests.addStartRideRequest("6",Locations.getCustomerLocation("1"));

        System.out.println("User 1 starts a ride with Driver - userID 6:");
        System.out.println("Is driver with Id 6 occupied?: "+Users.getDriver("6").isOccupied());

        Requests.addEndRideRequest("6",Locations.getCustomerLocation("1"));

        System.out.println("User 1 ended a ride with Driver - userID 6:");
        System.out.println("Is driver with Id 6 occupied?: "+Users.getDriver("6").isOccupied());


    }

}
