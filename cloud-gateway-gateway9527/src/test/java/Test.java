import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/22 9:45
 */
public class Test {

    @org.junit.Test
    public void a(){
        ZonedDateTime now = ZonedDateTime.now(); //获取默认时区
        System.out.println(now);



    }
}
