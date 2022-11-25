package sqgxy.xxydz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("sqgxy.xxydz.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SqgxyXxydzNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqgxyXxydzNewsApplication.class, args);
    }

}
