package com.example.spring_aop_log.aspect;

import com.alibaba.fastjson.JSON;

import com.example.spring_aop_log.annotation.SystemControllerLog;
import com.example.spring_aop_log.annotation.SystemServiceLog;
import com.example.spring_aop_log.sevice.impl.SystemLogStrategy;
import com.example.spring_aop_log.util.JsonUtil;
import com.example.spring_aop_log.util.ThreadUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(SystemLogAspect.class);

    public SystemLogAspect() {
    }

    /**
     * 切点
     */
    @Pointcut("@annotation(com.example.spring_aop_log.annotation.SystemControllerLog) || @annotation(com.example.spring_aop_log.annotation.SystemServiceLog)")
    public void pointcut() {
    }

    /**
     * 切面
     *
     * @param pjp
     * @return
     */
    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            LOG.error(throwable.getMessage(), throwable);

            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            long m = elapsedTime / 1000;

            //  打印日志
            printLog(pjp, result, m);
        }

        return result;
    }

    /**
     * 打印日志
     *
     * @param pjp         连接点
     * @param result      方法调用返回结果
     * @param elapsedTime 方法调用花费时间
     */
    private void printLog(ProceedingJoinPoint pjp, Object result, long elapsedTime) {
        SystemLogStrategy strategy = getFocus(pjp);

        if (null != strategy) {
            strategy.setThreadId(ThreadUtil.getThreadId());
            strategy.setResult(JsonUtil.toJSONString(result));
            strategy.setElapsedTime(elapsedTime);
            if (strategy.isAsync()) {
                new Thread(() -> LOG.info(strategy.format(), strategy.args())).start();
            } else {
                LOG.info(strategy.format(), strategy.args());
            }
        }
    }

    /**
     * 获取注解
     */
    private SystemLogStrategy getFocus(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        Object[] args = pjp.getArgs();
        String targetClassName = pjp.getTarget().getClass().getName();
        try {
            Class<?> clazz = Class.forName(targetClassName);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    if (args.length == method.getParameterCount()) {

                        SystemLogStrategy strategy = new SystemLogStrategy();
                        strategy.setClassName(className);
                        strategy.setMethodName(methodName);

                        SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);
                        if (null != systemControllerLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemControllerLog.description());
                            strategy.setAsync(systemControllerLog.async());
//                            strategy.setLocation(AnnotationTypeEnum.CONTROLLER.getName());
                            return strategy;
                        }
                        SystemServiceLog systemServiceLog = method.getAnnotation(SystemServiceLog.class);
                        if (null != systemServiceLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemServiceLog.description());
                            strategy.setAsync(systemServiceLog.async());
//                            strategy.setLocation(AnnotationTypeEnum.SERVICE.getName());
                            return strategy;
                        }

                        return null;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

}
