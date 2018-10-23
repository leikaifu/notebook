import com.itheima.AccountService;
import com.itheima.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Accountconfig.xml")
public class Testaccount {
    @Resource(name = "accountService")
    private AccountService accountService;
    @Test
    public void test(){
        accountService.transfer("liming","wenjia",500);
    }
}
