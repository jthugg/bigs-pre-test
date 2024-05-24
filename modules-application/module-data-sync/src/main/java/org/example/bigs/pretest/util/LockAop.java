package org.example.bigs.pretest.util;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.bigs.pretest.core.util.exception.LockedOperationException;
import org.example.bigs.pretest.core.util.util.ApplicationLockProvider;
import org.springframework.stereotype.Component;

/**
 * ApplicationLockProvider를 사용해 프로세스 내에서 동시성 처리.
 * 추후 분산락 구현 시 내부 로직 변경.
 */
@Aspect
@Component
@RequiredArgsConstructor
public class LockAop {

    private final ApplicationLockProvider lockProvider;
    private final AopTransactionExecutor transactionExecutor;

    @Around("@annotation(org.example.bigs.pretest.core.util.annotation.CustomLock)")
    public Object executeIfNotLocked(final ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            boolean isLocked = lockProvider.tryLock();
            if (isLocked) {
                return transactionExecutor.proceed(joinPoint);
            }
            throw new LockedOperationException();
        } finally {
            try {
                lockProvider.unlock();
            } catch (IllegalMonitorStateException exception) {
                // ignore...
            }
        }
    }

}
