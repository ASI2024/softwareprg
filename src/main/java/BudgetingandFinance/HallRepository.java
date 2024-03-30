package BudgetingandFinance;

import java.util.Date;
import java.util.List;

public interface HallRepository {

    List<Hall> findHallsByCriteria(int budget, Date date);

}
