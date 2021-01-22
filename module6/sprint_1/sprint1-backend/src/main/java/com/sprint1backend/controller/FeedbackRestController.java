package com.sprint1backend.controller;

import com.sprint1backend.entity.Feedback;
import com.sprint1backend.service.feedback.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackRestController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/send-feedback")
    public ResponseEntity<Void> sendFeedBack(@RequestBody Feedback feedback) {
        feedback.setSendDate(LocalDate.now());
        feedback.setProcessStatus(false);
        if (feedback.getContent() != null && feedback.getTitle() != null) {
            this.feedBackService.sendFeedback(feedback);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
