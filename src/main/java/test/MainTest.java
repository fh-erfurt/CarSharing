package test;

import com.sun.tools.javac.Main;
import data.Locations;
import data.Users;
import model.location.Location;
import model.user.User;

public final class MainTest {

    public static void startTest()
    {
        Users.init();
        Locations.init();


        User dummyuser;
        Location dummyLocation;

        double dummyLat = 50.971076;
        double dummyLong = 11.037831;

        for (int i = 1 ; i <= 5 ; i++)
        {
            dummyLocation = new Location(String.valueOf(i),dummyLat++,dummyLong++);

            Locations.updateCustomerLocation(String.valueOf(i),dummyLocation);

            dummyuser = new User("testuser"+i,"passwort"+i,"dummyuser"+i+"@test.de","testURL"+i,String.valueOf(i),"0"+i);
            Users.addCustomer(dummyuser);
        }



        User dummydriver;

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
            System.out.println("Lat: "+Locations.getCustomerLocation(String.valueOf(i)).getLatitude()+" Long: "+Locations.getCustomerLocation(String.valueOf(i)).getLatitude());
        }

        System.out.println("All Drivers:");

        for (int i = 6 ; i <= 10 ; i++)
        {
            System.out.println(Users.getDriver(String.valueOf(i)).getDisplayName());
            System.out.println("Lat: "+Locations.getDriverLocation(String.valueOf(i)).getLatitude()+" Long: "+Locations.getDriverLocation(String.valueOf(i)).getLatitude());
        }




    }

}
