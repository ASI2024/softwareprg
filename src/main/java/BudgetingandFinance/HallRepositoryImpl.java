package BudgetingandFinance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public abstract class HallRepositoryImpl implements HallRepository {
    private static final Logger logger = LoggerFactory.getLogger(HallRepositoryImpl.class);
    private Map<Integer, Hall> hallDatabase = new HashMap<>();

    protected HallRepositoryImpl() { 
        hallDatabase.put(1, new Hall(1, "Grand Ballroom", 3000, 200, new Date()));
        hallDatabase.put(2, new Hall(2, "Conference Center", 1500, 100, new Date()));
    }

    @Override
    public List<Hall> findHallsByCriteria(int budget, Date date) {
       
        logger.info("Searching for halls with budget <= {} and date == {}", budget, date);
        
        List<Hall> matchingHalls = new ArrayList<>();
        for (Hall hall : hallDatabase.values()) {
            logger.info("Hall: {}, Rent: {}, Date: {}", hall.getName(), hall.getRent(), hall.getAvailableDate());
            if (hall.getRent() <= budget && hall.getAvailableDate().compareTo(date) == 0) {
                matchingHalls.add(hall);
            }
        }
        return matchingHalls;
    }
    
    public abstract List<Hall> findHallsByCriteria(int budget, String eventType, Date date);
}
