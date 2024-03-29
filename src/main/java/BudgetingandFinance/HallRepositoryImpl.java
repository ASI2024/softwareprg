package BudgetingandFinance;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class HallRepositoryImpl implements HallRepository {
    private Map<Integer, Hall> hallDatabase = new HashMap<>();

    public HallRepositoryImpl() {
        // Initialize with some halls...
        hallDatabase.put(1, new Hall(1, "Grand Ballroom", 3000, 200, new Date()));
        hallDatabase.put(2, new Hall(2, "Conference Center", 1500, 100, new Date()));
        // Add more as needed...
    }

    @Override
    public List<Hall> findHallsByCriteria(int budget, Date date) {
        // Debugging output
        System.out.println("Searching for halls with budget <= " + budget + " and date == " + date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Hall> matchingHalls = new ArrayList<>();
        for (Hall hall : hallDatabase.values()) {
            System.out.println("Hall: " + hall.getName() + ", Rent: " + hall.getRent() + ", Date: " + hall.getAvailableDate());
            if (hall.getRent() <= budget && hall.getAvailableDate().compareTo(date) == 0) {
                matchingHalls.add(hall);
            }
        }



        return matchingHalls;
    }

    public abstract List<Hall> findHallsByCriteria(int budget, String eventType, Date date);
}
