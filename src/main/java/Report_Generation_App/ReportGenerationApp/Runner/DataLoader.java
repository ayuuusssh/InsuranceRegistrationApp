package Report_Generation_App.ReportGenerationApp.Runner;

import Report_Generation_App.ReportGenerationApp.Entity.CitizenPlan;
import Report_Generation_App.ReportGenerationApp.Repository.CitizenPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private CitizenPlanRepo citizenPlanRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        citizenPlanRepo.deleteAll();
        // CashPlan Data

        CitizenPlan c1 = new CitizenPlan();
        c1.setCitizenName("Ayush Tiwari");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenefitAmount(5000.00);


        CitizenPlan c2 = new CitizenPlan();
        c2.setCitizenName("Sunny Tiwari");
        c2.setGender("Male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Rental Income");

        CitizenPlan c3 = new CitizenPlan();
        c3.setCitizenName("John Wick");
        c3.setGender("Male");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setPlanStartDate(LocalDate.now().minusMonths(2));
        c3.setPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setBenefitAmount(5000.00);
        c3.setTerminatedDate(LocalDate.now());
        c3.setTerminationReason("Employed");

        // Food Plan Data

        CitizenPlan c4 = new CitizenPlan();
        c4.setCitizenName("Jonathan");
        c4.setGender("Male");
        c4.setPlanName("Food");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now());
        c4.setPlanEndDate(LocalDate.now().plusMonths(6));
        c4.setBenefitAmount(5000.00);


        CitizenPlan c5 = new CitizenPlan();
        c5.setCitizenName("Aaru");
        c5.setGender("Male");
        c5.setPlanName("Food");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("Property Income");

        CitizenPlan c6 = new CitizenPlan();
        c6.setCitizenName("AkOp");
        c6.setGender("Male");
        c6.setPlanName("Food");
        c6.setPlanStatus("Terminated");
        c6.setPlanStartDate(LocalDate.now().minusMonths(2));
        c6.setPlanEndDate(LocalDate.now().plusMonths(6));
        c6.setBenefitAmount(5000.00);
        c6.setTerminatedDate(LocalDate.now());
        c6.setTerminationReason("Employed");

        // Medical Plan Data

        CitizenPlan c7 = new CitizenPlan();
        c7.setCitizenName("Shadow");
        c7.setGender("Male");
        c7.setPlanName("Medical");
        c7.setPlanStatus("Approved");
        c7.setPlanStartDate(LocalDate.now());
        c7.setPlanEndDate(LocalDate.now().plusMonths(6));
        c7.setBenefitAmount(5000.00);


        CitizenPlan c8 = new CitizenPlan();
        c8.setCitizenName("Omega");
        c8.setGender("Male");
        c8.setPlanName("Medical");
        c8.setPlanStatus("Denied");
        c8.setDenialReason("Govt Income");

        CitizenPlan c9 = new CitizenPlan();
        c9.setCitizenName("Jelly");
        c9.setGender("Male");
        c9.setPlanName("Medical");
        c9.setPlanStatus("Terminated");
        c9.setPlanStartDate(LocalDate.now().minusMonths(2));
        c9.setPlanEndDate(LocalDate.now().plusMonths(6));
        c9.setBenefitAmount(5000.00);
        c9.setTerminatedDate(LocalDate.now());
        c9.setTerminationReason("Govt Job");

        // Employment Plan Data

        CitizenPlan c10 = new CitizenPlan();
        c10.setCitizenName("Aadi");
        c10.setGender("Male");
        c10.setPlanName("Employment");
        c10.setPlanStatus("Approved");
        c10.setPlanStartDate(LocalDate.now());
        c10.setPlanEndDate(LocalDate.now().plusMonths(6));
        c10.setBenefitAmount(5000.00);


        CitizenPlan c11 = new CitizenPlan();
        c11.setCitizenName("Destro");
        c11.setGender("Male");
        c11.setPlanName("Employment");
        c11.setPlanStatus("Denied");
        c11.setDenialReason("Rental Income");

        CitizenPlan c12 = new CitizenPlan();
        c12.setCitizenName("Nakul");
        c12.setGender("Male");
        c12.setPlanName("Employment");
        c12.setPlanStatus("Terminated");
        c12.setPlanStartDate(LocalDate.now().minusMonths(2));
        c12.setPlanEndDate(LocalDate.now().plusMonths(6));
        c12.setBenefitAmount(5000.00);
        c12.setTerminatedDate(LocalDate.now());
        c12.setTerminationReason("Employed");

        List<CitizenPlan> list =  Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
        citizenPlanRepo.saveAll(list);
    }
}
