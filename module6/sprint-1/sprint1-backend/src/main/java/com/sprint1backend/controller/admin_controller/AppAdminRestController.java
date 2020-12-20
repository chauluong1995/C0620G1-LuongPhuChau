package com.sprint1backend.controller.admin_controller;

import com.sprint1backend.entity.AppAdmin;
import com.sprint1backend.service.app_admin.AppAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AppAdminRestController {
    @Autowired
    private AppAdminService appAdminService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<AppAdmin> getAdminById(@PathVariable Long id) {
        AppAdmin appAdmin = this.appAdminService.findById(id);
        return new ResponseEntity<>(appAdmin, HttpStatus.OK);
    }

}
