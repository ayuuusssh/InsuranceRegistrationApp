package Report_Generation_App.ReportGenerationApp.Service;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import Report_Generation_App.ReportGenerationApp.Request.SearchRequest;
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

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("plan-data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Citizen Name");
        headerRow.createCell(2).setCellValue("Plan Name");
        headerRow.createCell(3).setCellValue("Plan Status");
        headerRow.createCell(4).setCellValue("Gender");
        headerRow.createCell(5).setCellValue("Start Date");
        headerRow.createCell(6).setCellValue("End Date");
        headerRow.createCell(7).setCellValue("Benefit Amt");

        List<CitizenPlan> records = citizenPlanRepo.findAll();
        int dataRowIndex = 1;
        for(CitizenPlan plan : records){
           Row dataRow = sheet.createRow(dataRowIndex);
           dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(2).setCellValue(plan.getPlanName());
            dataRow.createCell(3).setCellValue(plan.getPlanStatus());
            dataRow.createCell(4).setCellValue(plan.getGender());
            if(null !=plan.getPlanStartDate()) {
                dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
            }else{
                dataRow.createCell(5).setCellValue("N/A");
            }
            if(null !=plan.getPlanEndDate()) {
                dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
            }else{
                dataRow.createCell(6).setCellValue("N/A");
            }
            if(null !=plan.getBenefitAmount()) {
                dataRow.createCell(7).setCellValue(plan.getBenefitAmount());
            }else{
                dataRow.createCell(7).setCellValue("N/A");
            }
            dataRowIndex++;
        }

//        FileOutputStream fileOutputStream = new FileOutputStream(new File("plan.xls"));
//        workbook.write(fileOutputStream);
//        workbook.close();

        ServletOutputStream outPutStream = response.getOutputStream();
        workbook.write(outPutStream);
        workbook.close();
        return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception{

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

        List<CitizenPlan> plans = citizenPlanRepo.findAll();
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

        return false;
    }
}
