package BudgetingandFinance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface HallRepository {
    List<Hall> findHallsByCriteria(int budget, String eventType, Date date);
}
public abstract class HallRepositoryImpl implements HallRepository  {
    private Map<Integer, Hall> hallDatabase = new HashMap<>();

    // Constructor or a method to populate the "database"
    public HallRepositoryImpl() {
        // Populate the hallDatabase map with some sample halls.
        // In a real scenario, this could be replaced with data from a file, user input, etc.
        hallDatabase.put(1, new Hall(1, "Grand Ballroom", 3000, 200, new Date())); // Assuming constructor is adjusted too
        hallDatabase.put(2, new Hall(2, "Conference Center", 1500, 100, new Date())); // Same here
        // Add more sample halls as needed...
    }

    public List<Hall> findHallsByCriteria(int budget, Date date) {
        int minBudget = budget - 999;
        int maxBudget = budget + 999;

        // Stream the values of the map, filter them according to the criteria, and collect the results
        return hallDatabase.values().stream()
                .filter(hall -> hall.getRent() >= minBudget && hall.getRent() <= maxBudget)
                .filter(hall -> hall.getAvailableDate().equals(date))
                .collect(Collectors.toList());
    }
}
