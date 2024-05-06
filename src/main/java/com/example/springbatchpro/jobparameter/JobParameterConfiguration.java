package com.example.springbatchpro.jobparameter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
public class JobParameterConfiguration {

    @Bean
    public Job job(JobRepository jobRepository, Step step1, Step step2){
        return new JobBuilder("job",jobRepository)
                .start(step1)
                .next(step2)
                .build();
    }




    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder("step1",jobRepository)
                .tasklet((contribution,chunkContext)->{

                    //두가지 방식다 값은 확인할 수 있다

                    //이방식이 JobParameterTest에서 설정한값을 반환 하는 방식이다
                   JobParameters jobParameters =  contribution.getStepExecution().getJobExecution().getJobParameters();
                   jobParameters.getString("name");
                   jobParameters.getLong("seq");
                   jobParameters.getDate("date");
                   jobParameters.getDouble("age");

                   //이방식은 동일한 값을 얻을수 있겠지만 map을 통해서 얻을수있다 =값만 확인 가능
                    Map<String, Object> jobParameters1 = chunkContext.getStepContext().getJobParameters();

                    System.out.println("step1 has executed");
                    return RepeatStatus.FINISHED;
                },tx).build();
    }


    @Bean
    public Step step2(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder("step2", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step2 has executed");
                    return RepeatStatus.FINISHED;
                }, tx).build();
    }
}
