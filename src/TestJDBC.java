import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:c3p0config.xml")
public class TestJDBC {

    @Resource(name = "jdbcTemplet")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void jdbctest(){
        jdbcTemplate.update("INSERT INTO springjdbc VALUES (null,?,?)","wenjia",1000);
    }
}
