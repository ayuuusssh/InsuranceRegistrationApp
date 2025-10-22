package Report_Generation_App.ReportGenerationApp.Controller;

import Report_Generation_App.ReportGenerationApp.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

}
