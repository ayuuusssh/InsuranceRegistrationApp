package Report_Generation_App.ReportGenerationApp.Repository;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenPlanRepo extends JpaRepository<CitizenPlan,Integer> {
    @Query("select distinct (planName) from CitizenPlan")
    public List<String> getPlanNames();
    @Query("select distinct (planStatus) from CitizenPlan")
    public List<String> getPlanStatus();
}
