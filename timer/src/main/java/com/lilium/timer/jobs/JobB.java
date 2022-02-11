package com.lilium.timer.jobs;

import java.sql.Timestamp;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobB implements Job {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Job ** {} with ID : {} ** fired @ {}", context.getJobDetail().getKey().getName(),
                context.getJobDetail().getJobDataMap().get("ID"), new Timestamp(System.currentTimeMillis()));
        try {
            Thread.sleep(5000);
            logger.info("Job ** {} ** fire finish @ {}", context.getJobDetail().getKey().getName(), new Timestamp(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
