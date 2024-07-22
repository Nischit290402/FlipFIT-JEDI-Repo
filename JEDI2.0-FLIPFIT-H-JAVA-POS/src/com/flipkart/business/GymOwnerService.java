// Package declaration
package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.*;

import java.time.LocalDateTime;
import java.util.*;

import com.flipkart.business.UserService;
import com.flipkart.dao.CityDAOImpl;
import com.flipkart.dao.GymOwnerDAOImpl;
import com.flipkart.dao.UserDAOImpl;
import com.flipkart.utils.sharedState;

import static com.flipkart.utils.dbutils.getTableCnt;

/**
 * This class implements the GymOwnerServiceInterface and provides methods
 * to manage gym owner-related operations such as creating a gym owner,
 * adding gym centers, showing gym centers, and editing slots.
 */
public class GymOwnerService implements GymOwnerServiceInterface {
    // Counter for generating unique IDs for gym owners
//    private int cntUsers = getTableCnt("user");

    // Scanner instance for user input
    Scanner scanner = new Scanner(System.in);
    // UserService instance to manage user-related operations
    UserService userService = new UserService();
    // HashMap to store gym centers by city
    public static HashMap<String, List<GymCenter>> cityGymcenters = new HashMap<>();
    // HashMap to store pending gym owners
    public static HashMap<String, GymOwner> PendingGymOwnerMap = new HashMap<>();
    // HashMap to store approved gym owners
    public static HashMap<String, GymOwner> GymOwnerMap = new HashMap<>();
    private GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();
    private CityDAOImpl cityDAO = new CityDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();

    /**
     * Returns the city gym centers map
     */
    public HashMap<String, List<GymCenter>> getCityGymcenters() {
        return cityGymcenters;
    }

    /**
     * Searches for a gym center by name and city.
     */
    public GymCenter searchcitygc(String name, String city) {
        for (GymCenter i : cityGymcenters.get(city)) {
            if (i.getGymName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Creates a new gym owner with the provided details.
     */
    public void createGymOwner(String username, String name, String mail, String phone, int age, String password) {
        System.out.println("Registering Gym Owner");
        String id = "O" + sharedState.getCntUsers();
        sharedState.incrementCntUsers();
        Role role = new Role("B", "GymOwner");
        GymOwner gymOwner = new GymOwner(username, name, mail, phone, age, password, id, role.getRoleID());
//        PendingGymOwnerMap.put(id, gymOwner);
        User user = new User(username, password, id, role.getRoleID());
//        userService.addUser(user);
        boolean val1 = userDAO.addUser(user);
        boolean val2 = userDAO.registerGymOwner(gymOwner);
        if(val1 && val2){
            System.out.println("Gym Owner registered successfully");
        }
        else System.out.println("Customer creation failed");
    }

    /**
     * Adds a gym center associated with the given user.
     */
    public boolean addGymCenter(GymOwner gymOwner, String gymName, String address, String cityName) {
        if (!cityDAO.cityExists(cityName)) {
            sharedState.incrementCntCity();
            String cityId = "0" + sharedState.getCntCity();
            City citydao = new City(cityId, cityName);
            boolean cityAdded = cityDAO.addCity(citydao);
            if (!cityAdded) {
                System.out.println("Failed to add city");
                return false;
            }
        }
        sharedState.incrementCntCenters();
        String gym_id = "GC" + sharedState.getCntCenters();
        List<Slot> slots=new ArrayList<>();
        GymCenter gymCenter = new GymCenter(gym_id, gymName, address, cityName, slots, gymOwner.getUserid());

//        AdminService.pendingCenters.put(gym_id, gymCenter);
//        GymOwnerMap.put(user.getUserid(), GymOwner);

        if(gymOwnerDAO.addGymCenter(gymCenter)){
            System.out.println("Gym Owner registered successfully");
            return true;
        }
        else {
            System.out.println("Gym Owner not registered successfully");
            return false;
        }
    }

    /**
     * Displays the gym centers associated with the given user.
     */
    public void showGymCenters(User user) {
//        GymOwner gymOwner = GymOwnerMap.get(user.getUserid());
        GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();
        List<GymCenter> gymCenters = gymOwnerDAO.getGymCenters(user.getUserid());
//        print all gym centers
        for (GymCenter gymCenter : gymCenters) {
            System.out.println("Gym ID: " + gymCenter.getGymID() + ", Gym Name: " + gymCenter.getGymName());
        }
    }

    public boolean searchGC(String gymID, List<GymCenter> gymCenters) {
//        boolean found = false;
        GymCenter gymC = null;
        for (GymCenter gymCenter : gymCenters) {
            if (gymCenter.getGymID().equals(gymID)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Edits the slots for the gym centers associated with the given user.
     */
    public void editSlots(GymOwner gymOwner) {
        System.out.println("Enter City: ");
        String city = scanner.nextLine();
        int c = 1;
        List<GymCenter> gymCenters = gymOwnerDAO.getGymCenters(gymOwner.getUserid());

//        GymOwner go = GymOwnerMap.get(user.getUserid());
        for (GymCenter gc : gymCenters) {
            if (gc.getCity().equals(city)) {
                System.out.println(c + ". Gym ID: " + gc.getGymID() + ", Gym Name: " + gc.getGymName());
//                System.out.println(c + ". " + gc.getGymName());
                c++;
            }
        }
        System.out.println("Enter Gym ID: ");
        String gid= scanner.nextLine();
        System.out.println("1. Add Slot");
        System.out.println("2. Remove Slot");
        int ch = scanner.nextInt();
        switch (ch) {
            case 1:
                if (searchGC(gid,gymCenters)) {
//                    GymCenter gc = searchGC(gid,gymCenters);
                    sharedState.incrementCntSlot();
                    String id = "S" + sharedState.getCntSlot();
                    System.out.println("Enter year(yyyy): ");
                    int year = scanner.nextInt();
                    System.out.println("Enter month(mm): ");
                    int month = scanner.nextInt();
                    System.out.println("Enter date(dd): ");
                    int date = scanner.nextInt();
                    System.out.println("Enter hour according to 24hrs clock: ");
                    int hr = scanner.nextInt();
                    LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                    System.out.println("Enter capacity of slot: ");
                    int cp = scanner.nextInt();
                    Slot slt = new Slot(id, st, st.plusHours(1),cp,gid);
                    gymOwnerDAO.addSlots(gid, slt);
//                    String result = gc.addSlot(id, st, st.plusHours(1), cp);
//                    System.out.println(result);
                } else {
                    System.out.println("Invalid Gym ID.");
                }
                break;
            case 2:
                if (searchGC(gid, gymCenters)) {
//                    GymCenter gc = searchGC(gid, gymCenters);
                    System.out.println("Enter year(yyyy): ");
                    int year = scanner.nextInt();
                    System.out.println("Enter month(mm): ");
                    int month = scanner.nextInt();
                    System.out.println("Enter date(dd): ");
                    int date = scanner.nextInt();
                    System.out.println("Enter hour according to 24hrs clock: ");
                    int hr = scanner.nextInt();
                    LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                    gymOwnerDAO.removeSlot(gid,st);
                } else {
                    System.out.println("Invalid Gym ID.");
                }
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}
