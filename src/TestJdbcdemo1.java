import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:c3p0config.xml")
public class TestJdbcdemo1 {
    @Test
    public void  test(){
        //创建地址池
      DriverManagerDataSource  dataSource=new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://45.32.66.58:3306/mybatis");
      dataSource.setUsername("heke");
      dataSource.setPassword("1380813582");

      //创建jdbc模板
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO springjdbc VALUES (NULL ,?,?)","杨洁",100);

    }


    @Resource(name = "jdbcTemplet")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void jdbctest(){
        jdbcTemplate.update("INSERT INTO springjdbc VALUES (null,?,?)","wenjia",1000);
    }

    @Test
    public  void  Testupdate(){
        jdbcTemplate.update("INSERT INTO springjdbc VALUES (NULL ,?,?)","yang",20000);

    }

    @Test
    public void demo(){
        jdbcTemplate.update("UPDATE springjdbc SET name=?,money=? WHERE id=?","xiaoming",30000,9);
    }

    @Test
    public void demo2(){
        jdbcTemplate.update("DELETE FROM springjdbc WHERE id=?",1);
    }

    @Test
    public void demo3(){

        String user = jdbcTemplate.queryForObject("select name from springjdbc where id=?", String.class, 5);
        System.out.println("查询出的用户名："+user);
    }

    @Test
    //统计查询
    public void demo4(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from springjdbc ", long.class);
        System.out.println("统计数据："+aLong);
    }



}
