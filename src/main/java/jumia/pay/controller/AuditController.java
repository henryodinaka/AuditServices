package jumia.pay.controller;

import jumia.pay.dto.ActivityRequest;
import jumia.pay.interfaces.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;
    @GetMapping("/all/log")
    public ResponseEntity getAllLog(@RequestBody ActivityRequest request, @RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok(auditService.getAllLog(request,new PageRequest(pageNum,pageSize)));
    }
    @GetMapping("/user/log")
    public ResponseEntity getAllUserLog(@RequestBody ActivityRequest request,@RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok(auditService.getUserLog(request,new PageRequest(pageNum,pageSize)));
    }

}
