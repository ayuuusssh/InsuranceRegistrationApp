package Report_Generation_App.ReportGenerationApp.Utils;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;


    public boolean email(String subject, String body, String to, File f) throws Exception{

        try{
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setSubject(subject);
            helper.setText(body,true);
            helper.setTo(to);
            helper.addAttachment("Plan-Info",f);
            javaMailSender.send(message);
        }catch(Exception e){
             e.printStackTrace();
        }

        return true;
    }
}
