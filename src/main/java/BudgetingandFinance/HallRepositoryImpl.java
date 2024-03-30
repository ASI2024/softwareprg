package BudgetingandFinance;

import java.text.SimpleDateFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HallRepositoryImpl implements HallRepository {
    private Map<Integer, Hall> hallDatabase = new HashMap<>();

   protected HallRepositoryImpl(){
        hallDatabase.put(1, new Hall(1, "Grand Ballroom", 3000, 200, new Date()));
        hallDatabase.put(2, new Hall(2, "Conference Center", 1500, 100, new Date()));
    }

    @Override
    public List<Hall> findHallsByCriteria(int budget, Date date) {
        // Log the search criteria
        logger.info("Searching for halls with budget <= {} and date == {}", budget, date);
        
        List<Hall> matchingHalls = new ArrayList<>();
        for (Hall hall : hallDatabase.values()) {
            // Log each hall's details
            logger.info("Hall: {}, Rent: {}, Date: {}", hall.getName(), hall.getRent(), hall.getAvailableDate());
            
            if (hall.getRent() <= budget && hall.getAvailableDate().compareTo(date) == 0) {
                matchingHalls.add(hall);
            }
        }
        return matchingHalls;
    }
}
