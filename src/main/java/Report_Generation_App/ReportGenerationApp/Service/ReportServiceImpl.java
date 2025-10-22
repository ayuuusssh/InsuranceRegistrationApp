package Report_Generation_App.ReportGenerationApp.Service;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private CitizenPlanRepo citizenPlanRepo;
    @Override
    public List<String> getPlanNames() {
        return null;
    }

    @Override
    public List<String> getPlanStatus() {
        return null;
    }

    @Override
    public List<CitizenPlan> search(SearchRequest request) {
        return null;
    }

    @Override
    public boolean exportExcel() {
        return false;
    }

    @Override
    public boolean exportPdf() {
        return false;
    }
}
