package jumia.pay.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import jumia.pay.dto.AuditRequest;
import jumia.pay.enums.Actions;
import jumia.pay.enums.RoleName;
import jumia.pay.interfaces.Auditable;
import jumia.pay.service.AuditServiceImp;
import jumia.pay.util.JsonBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Aspect
@Component
public class AuditingAspect {
     @Autowired
     private AuditServiceImp auditServiceImp;

//     @Pointcut(value = "@annotation(auditable)")
//     public void pointCut(Auditable auditable){
//         //This cuts all the points where methods are annotated with @Auditable
//     }
//
//     @After("args(email)")
//     public void logUserEmail(String email){
//         //This method makes available the method argument
//     }

    /**
     * This advice is ran after a method annotated with @auditable has returned
     * @param joinPoint
     * @param auditable
     * @param object
     */
     @AfterReturning(value = "@annotation(auditable)",returning = "object")
     @Transactional
     public void logAuditActivity(JoinPoint joinPoint, Auditable auditable,Object object)
     {
         String targetObject = null;
         String auditorUsername;
         RoleName auditorRoleName;
         Actions actionType = auditable.actionType();
        try {
            if (object instanceof Collection<?>) {
                if (!((Collection) object).isEmpty())
                    targetObject = JsonBuilder.generateJson(object);
            }
            else {
                if (object !=null)
                    targetObject = JsonBuilder.generateJson(object);
            }
        }catch (JsonProcessingException e) {
         e.printStackTrace();
     }
         Object  obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         if (obj instanceof UserDetails)
         {
              UserDetails auditingUser = (UserDetails) obj;
              auditorUsername = auditingUser.getUsername();
              Collection<? extends GrantedAuthority> authorities = auditingUser.getAuthorities();
              String  logginUserRole = authorities.stream().findAny().get().getAuthority();
              auditorRoleName = RoleName.valueOf(logginUserRole);
             auditServiceImp.logActivity(new AuditRequest(actionType,auditorUsername,targetObject,auditorRoleName));

         }
         else auditorUsername = obj.toString();
     }

}