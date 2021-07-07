package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

    /**
     *  인텔리제이 이슈
     *  css 갖다 붙이고 다시 실행했을 때 접근 안 되면 out 디렉토리 날리고 다시 서버띄우기
     */

}
