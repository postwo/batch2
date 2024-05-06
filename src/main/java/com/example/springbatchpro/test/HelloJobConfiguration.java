package com.example.springbatchpro.test;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloJobConfiguration {

    //스프링 배치5,스프링3.xx  부터는 설정부분이 다라졌기 때문에 이방식으로 하기

//    @Bean
//    public Job helloJob(JobRepository jobRepository, Step helloStep1, Step helloStep2) {
//        return new JobBuilder("helloJob", jobRepository)// job의 이름이다
//                .start(helloStep1)
//                .next(helloStep2)
//                .build();
//    }
//
//    /*PlatformTransactionManager은 스프링 프레임워크에서 트랜잭션 관리를 추상화한 인터페이스입니다.
//     이 인터페이스는 스프링에서 트랜잭션을 시작, 커밋, 롤백하는 등의 트랜잭션 관리 기능을 제공합*/
//    /*
//     PlatformTransactionManager를 사용하지 않고 트랜잭션을 빼면 왜 동작하지 않는지 이해하는 데 도움이 될 것입니다.
//    일반적으로 스프링 배치에서 각 스텝은 트랜잭션 내에서 실행됩니다. 그렇기 때문에 스프링 배치의 각 단계에는 트랜잭션 관리자가 필요합니다.
//    주어진 코드에서 helloStep1 메서드는 StepBuilder를 사용하여 스텝을 생성하고, 해당 스텝에서 트랜잭션을 관리하기 위해
//    PlatformTransactionManager를 사용합니다. 만약 트랜잭션 관리자를 제공하지 않으면 스프링 배치는 트랜잭션을 시작할
//    수 없으며 따라서 스텝이 실행되지 않습니다.
//    따라서 트랜잭션 관리자가 필요한 이유는 각 스텝이 데이터베이스 작업을 수행할 때 데이터의 일관성을
//    보장하고 롤백할 수 있도록 하는 것입니다.*/
//    @Bean
//    public Step helloStep1(JobRepository jobRepository, PlatformTransactionManager tx) {
//        return new StepBuilder( "helloStep1", jobRepository)
//                .tasklet((contribution, chunkContext) -> {  //tasklet 무한반복 시킨다
//                    System.out.println("====================================");
//                    System.out.println(" helloStep1 executed ");
//                    System.out.println("====================================");
//                    return RepeatStatus.FINISHED; //tasklet의 기능을 한번만 실행시키고 종료시킨다
//                }, tx).build();
//    }
//
//    @Bean
//    public Step helloStep2(JobRepository jobRepository, PlatformTransactionManager tx) {
//        return new StepBuilder( "helloStep2", jobRepository)
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("====================================");
//                    System.out.println(" helloStep2 executed ");
//                    System.out.println("====================================");
//                    return RepeatStatus.FINISHED;
//                }, tx).build();
//    }


}
