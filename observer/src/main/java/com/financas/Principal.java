package com.financas;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.financas.job.LancamentosVencidosJob;
import com.financas.listeners.EmailListener;
import com.financas.listeners.Listener;
import com.financas.listeners.SMSListener;
import com.financas.notifier.Notificador;
import com.financas.notifier.NotificadorLancamentosVencidos;
import com.financas.repository.Lancamentos;

@SuppressWarnings("unused")
public class Principal {
    public static void main(String[] args) throws Exception {
        Notificador notificador = new NotificadorLancamentosVencidos();

        Listener enviadorEmail = new EmailListener(notificador);
        Listener enviadorSms = new SMSListener(notificador);

        JobDataMap jobDataMap = new JobDataMap();
        Lancamentos lancamentos = new Lancamentos();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("lancamentos", lancamentos);
        jobDataMap.put("notificador", notificador);

        JobDetail job = newJob(LancamentosVencidosJob.class)
                .setJobData(jobDataMap)
                .withIdentity("lancamentosVencidosJob", "lancamentosVencidosGroup")
                .build();

        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(220000);

        scheduler.shutdown(true);
    }
}