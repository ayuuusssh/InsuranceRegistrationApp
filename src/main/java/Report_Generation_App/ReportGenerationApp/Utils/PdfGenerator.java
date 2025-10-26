package Report_Generation_App.ReportGenerationApp.Utils;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PdfGenerator {

    public void generate(HttpServletResponse response, List<CitizenPlan> plans)throws Exception{

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        Paragraph p = new Paragraph("Citizen Information");
        document.add(p);
        PdfPTable table = new PdfPTable(8);


        table.addCell("id");
        table.addCell("Citizen Name");
        table.addCell("Plan Name");
        table.addCell("Plan Status");
        table.addCell("Gender");
        table.addCell("Start Date");
        table.addCell("End Date");
        table.addCell("Benefit Amt");

        for(CitizenPlan plan : plans){
            table.addCell(String.valueOf(plan.getCitizenId()));
            table.addCell(String.valueOf(plan.getCitizenName()));
            table.addCell(String.valueOf(plan.getPlanName()));
            table.addCell(String.valueOf(plan.getPlanStatus()));
            table.addCell(String.valueOf(plan.getGender()));
            table.addCell(String.valueOf(plan.getPlanStartDate()));
            table.addCell(String.valueOf(plan.getPlanEndDate()));
            table.addCell(String.valueOf(plan.getBenefitAmount()));
        }

        document.add(table);
        document.close();
    }
}
