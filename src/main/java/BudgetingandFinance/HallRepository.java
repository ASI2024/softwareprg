package BudgetingandFinance;

import java.util.Date;
import java.util.List;

public interface HallRepository {

    // Updated method signature: Removed eventType parameter
    List<Hall> findHallsByCriteria(int budget, Date date);

}
