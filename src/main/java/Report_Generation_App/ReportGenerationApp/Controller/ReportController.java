package Report_Generation_App.ReportGenerationApp.Controller;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
import Report_Generation_App.ReportGenerationApp.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    @PostMapping("/search")
    public String handleSearch(SearchRequest searchRequest ,Model model){

        List<CitizenPlan> plans = reportService.search(searchRequest);
        model.addAttribute("plans",plans);
        model.addAttribute("search", searchRequest);
        init(model);
        return "index";
    }
    
    @GetMapping("/")
    public String indexPage(Model model){

        SearchRequest searchObj = new SearchRequest();
        model.addAttribute("search",searchObj);
        init(model);
        return "index";
    }

    private void init(Model model) {
        model.addAttribute("names",reportService.getPlanNames());
        model.addAttribute("statuses",reportService.getPlanStatus());
    }

}
