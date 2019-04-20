package jumia.pay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/audit")
public class AuditController {

    @GetMapping
    public ResponseEntity getAllLog(@RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok("");
    }
    @GetMapping("/user")
    public ResponseEntity getAllUserLog(@RequestParam Long userId,@RequestParam int pageNum, @RequestParam int pageSize){
        return ResponseEntity.ok("");
    }

}
