package com.lilium.timer.jobs;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobA implements Job {
    Logger logger = LoggerFactory.getLogger(getClass());
   /* @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {



    }*/

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}
