package Report_Generation_App.ReportGenerationApp.Utils;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
@Component
public class ExcelGenerator {
    public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {

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

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);

        ServletOutputStream outPutStream = response.getOutputStream();
        workbook.write(outPutStream);
        workbook.close();
    }
}
