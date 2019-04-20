package jumia.pay.aspect;

import jumia.pay.enums.Actions;
import jumia.pay.interfaces.AuditService;
import jumia.pay.interfaces.Auditable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Aspect
public class AuditingAspect {
 @Autowired
 private AuditService auditService;

@After("@annotation(auditable)")
 @Transactional
 public void logAuditActivity(JoinPoint jp, Auditable auditable) {
 String targetAuditingUser;
 Actions actionType = auditable.actionType();
 
 /*String auditingUsername = Authentication auth = SecurityContextHolder.getContext().getAuthentication().getName()
 role = userService.getCurrentUser(false).getPermissionsList().toString();
 auditingUsernameIp = request.getRemoteAddr();*/

/* logger.info(
 "Auditing information. auditingUsername=" + auditingUsername + ", actionType=" + actionType + ", role=" + role + ", targetAuditingUser="
 + targetAuditingUser + " auditingUsernameIp=" + auditingUsernameIp
 );*/
// auditService.logActivity(actionType,);
}

}