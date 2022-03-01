package mdao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("mdao.mapper")
public class MdaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MdaoApplication.class, args);
    }
}
