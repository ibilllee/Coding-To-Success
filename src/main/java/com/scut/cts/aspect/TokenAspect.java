package com.scut.cts.aspect;

import com.scut.cts.utils.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
public class TokenAspect {
    private static Set<String> noTokenMethods = new HashSet<String>() {
        {
//            add("login");
//            add("register");
        }
    };


    @Before("execution(* com.scut.cts.controller.*.*(..))")
    public void checkToken(JoinPoint joinPoint) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        if (!noTokenMethods.contains(methodName)) {
//            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
//                    getRequest().getHeader("Authorization");
//            if (!TokenUtils.verify(token)) {
//                throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED, "Your token is invalid");
//            }
//        }
    }
}
