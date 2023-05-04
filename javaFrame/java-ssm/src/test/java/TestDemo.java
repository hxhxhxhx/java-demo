import com.huaxiti.service.WebService;
import com.huaxiti.service.impl.WebServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDemo {

    @Autowired
    private WebService webService;

    @Test
    public void test1(){
//        webService.insertStudent("jj");
        WebServiceImpl webService = new WebServiceImpl();
        webService.insertTeacher("dd");
    }
}
