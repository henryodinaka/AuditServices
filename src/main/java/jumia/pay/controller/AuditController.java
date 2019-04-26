package jumia.pay.controller;

import jumia.pay.dto.ActivityRequest;
import jumia.pay.dto.AuditRequest;
import jumia.pay.interfaces.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;
    @GetMapping("/all/log")
    public ResponseEntity getAllLog(@RequestParam String email, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok(auditService.getAllLog(new ActivityRequest(email,startDate,endDate),new PageRequest(pageNum,pageSize)));
    }
    @GetMapping("/all/logs")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(auditService.getLogs());
    }
    @GetMapping("/user/log")
    public ResponseEntity getAllUserLog(@RequestBody ActivityRequest request,@RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok(auditService.getUserLog(request,new PageRequest(pageNum,pageSize)));
    }

}
