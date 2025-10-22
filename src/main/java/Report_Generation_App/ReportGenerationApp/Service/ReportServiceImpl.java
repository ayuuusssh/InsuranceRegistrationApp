package Report_Generation_App.ReportGenerationApp.Service;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private CitizenPlanRepo citizenPlanRepo;
    @Override
    public List<String> getPlanNames() {
        List<String> planNames =  citizenPlanRepo.getPlanNames();
        return planNames;
    }

    @Override
    public List<String> getPlanStatus() {
        return citizenPlanRepo.getPlanStatus();
    }

    @Override
    public List<CitizenPlan> search(SearchRequest request) {
        CitizenPlan entity = new CitizenPlan();
        if(null!= request.getPlanName() && !"".equals(request.getPlanName())) {
            entity.setPlanName(request.getPlanName());
        }
        if(null!= request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
            entity.setPlanStatus(request.getPlanStatus());
        }
        if(null!= request.getGender() && !"".equals(request.getGender())) {
            entity.setGender(request.getGender());
        }
        return citizenPlanRepo.findAll(Example.of(entity));
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
