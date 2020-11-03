package com.slianOAsys.sysadmin.log;

import java.util.Arrays;




import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectForLog {

	private static Logger logger = Logger.getLogger(AspectForLog.class);
	OperateLevel OPERATE_LEVEL =new OperateLevel();
	ServerLevel SERVER_LEVEL =new ServerLevel();
	
	private void log_O(String message){
		logger.log(OPERATE_LEVEL, message);
	}
	private void log_S(String message){
		logger.log(SERVER_LEVEL, message);
	}
	
		
	@Around("execution(* com.slianOAsys.service.impl.*ServiceImpl.delet*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImpl.insert*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImpl.save*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImpl.update*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImp.insert*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImp.delet*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImp.update*(..))"
	+"||execution(* com.slianOAsys.service.impl.*ServiceImp.refresh*(..))")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
		String op=joinPoint.getTarget()+"."+joinPoint.getSignature().getName()+Arrays.toString(joinPoint.getArgs());
		String targetFunction=joinPoint.getSignature().getName();
		String targetClass=joinPoint.getTarget().getClass().getName();
		String parameters=Arrays.toString(joinPoint.getArgs());
		String type="analysis";

		System.out.println("----------------------------------------");
		System.out.println(parameters);
		System.out.println(op);
		
		
		if(MDC.get("UserId")==null)
			MDC.put("UserId",-1);
		if(MDC.get("IP")==null)
			MDC.put("IP","-.-.-.-");
		MDC.put("function",targetFunction.replace("'", "$S$"));
		MDC.put("class", targetClass.replace("'", "$S$"));
		MDC.put("parameters", parameters.replace("'", "$S$"));
		MDC.put("type", targetFunction.replace("'", "$S$"));//type
		try{
			Object result= joinPoint.proceed();
			String resultS=result.toString();
			if(resultS.length()>100){
				resultS=resultS.substring(0, 100);
			}
			MDC.put("result", resultS);
			log_O(op);
			
			return result;
		}catch(IllegalArgumentException e){
			log_S(op+"error:"+e);
			throw e;
		}	
	}
	
		
}
