package sqgxy.xxydz;

import sqgxy.xxydz.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqgxyXxydzNewsApplicationTests {

    @Autowired
    NewsService newsService;

    @Test
    void contextLoads() {
    }

}
