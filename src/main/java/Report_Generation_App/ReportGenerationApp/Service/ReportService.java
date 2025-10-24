package Report_Generation_App.ReportGenerationApp.Service;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface ReportService {

    public List<String> getPlanNames();

    public List<String> getPlanStatus();

    public List<CitizenPlan> search(SearchRequest request);

    public boolean exportExcel(HttpServletResponse response) throws Exception;

    public boolean exportPdf(HttpServletResponse response) throws Exception;
}
