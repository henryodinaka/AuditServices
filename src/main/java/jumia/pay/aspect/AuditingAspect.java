package jumia.pay.aspect;

import jumia.pay.enums.Actions;
import jumia.pay.interfaces.AuditService;
import jumia.pay.interfaces.Auditable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Aspect
@Component
public class AuditingAspect {
 @Autowired
 private AuditService auditService;

@AfterReturning(value = "@annotation(auditable)",returning = "object")
 @Transactional
 public void logAuditActivity(JoinPoint joinPoint, Auditable auditable,Object object) {
 Object[] args = joinPoint.getArgs();
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