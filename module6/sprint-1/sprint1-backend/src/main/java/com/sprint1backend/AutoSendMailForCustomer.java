package com.sprint1backend;

import com.sprint1backend.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class AutoSendMailForCustomer {
//    @Autowired
//    private EmailService emailService;
//
//    @Bean
//    public TaskScheduler taskScheduler() {
//        final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//        scheduler.setPoolSize(10);
//        return scheduler;
//    }
//
//    @Scheduled(fixedDelay = 1000*60*60*24)
//    public void scheduleFixedDelayTask() {
//        System.out.println("ok chưa !");
//
//        SimpleMailMessage sendEmailForCustomer = new SimpleMailMessage();
//        sendEmailForCustomer.setFrom("SuPeaJr");
//        sendEmailForCustomer.setTo("hoquynhmai1505@gmail.com");
//        sendEmailForCustomer.setSubject("Thông báo từ C06Parking");
//        sendEmailForCustomer.setText("Vé xe của bạn sẽ hết hạn vào ngày 27/12/2020! Đề nghị bạn gia hạn nếu không " +
//                "vé xe sẽ bị hủy! Đây là tin nhắn tự động của hệ thống! Bạn không cần phải phản hồi! Xin cảm ơn!");
//        emailService.sendEmail(sendEmailForCustomer);
//    }
}
