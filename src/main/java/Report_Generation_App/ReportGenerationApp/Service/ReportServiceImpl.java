package Report_Generation_App.ReportGenerationApp.Service;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
import Report_Generation_App.ReportGenerationApp.Utils.EmailSender;
import Report_Generation_App.ReportGenerationApp.Utils.ExcelGenerator;
import Report_Generation_App.ReportGenerationApp.Utils.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private CitizenPlanRepo citizenPlanRepo;
    @Autowired
    private ExcelGenerator excelGenerator;
    @Autowired
    private PdfGenerator pdfGenerator;
    @Autowired
    private EmailSender emailSender;
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
    public boolean exportExcel(HttpServletResponse response) throws Exception{
        File file = new File("Plan.xls");
        List<CitizenPlan> plans = citizenPlanRepo.findAll();
        excelGenerator.generate(response,plans,file);
        String subject = "Test Mail";
        String body = "Hey This my acc";
        String to = "ayushtiwari.gta@gmail.com";
        File f = new File("Plans.xls");
        emailSender.email(subject,body,to,f);
        file.delete();
        return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception{
        List<CitizenPlan> plans = citizenPlanRepo.findAll();
        pdfGenerator.generate(response,plans);
        return false;
    }


}
