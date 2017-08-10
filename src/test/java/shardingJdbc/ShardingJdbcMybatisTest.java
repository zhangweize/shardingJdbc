package shardingJdbc;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.dangdang.sharding.jdbc.entity.Company;
import com.study.dangdang.sharding.jdbc.entity.User;
import com.study.dangdang.sharding.jdbc.service.CompanyService;
import com.study.dangdang.sharding.jdbc.service.UserService;
import com.study.dangdang.sharding.jdbc.unit.SnowflakeIdWorker;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:config/spring/spring-database.xml",  
        "classpath*:config/spring/spring-sharding.xml" })  
public class ShardingJdbcMybatisTest {
    @Autowired
    public UserService userService;
    
    @Autowired
    private CompanyService companyService;
    
    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @Test
    public void testUserInsert() {
        User u = new User();
        u.setId(idWorker.nextId());
        u.setCompanyId(342670793747988480L);
        u.setAge(25);
        u.setName("github");
        Assert.assertEquals(userService.insert(u), true);
    }
    
    
    @Test
    public void testFindAll(){
        List<User> users = userService.findAll(Arrays.asList(342670793747988480L));
        System.out.println(users.size());
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testSQLIN(){
        List<User> users = userService.findByUserIds(Arrays.asList(342670793747988480L));
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testTransactionTestSucess(){
        userService.transactionTestSucess();
    }
    
    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{
        userService.transactionTestFailure();
    } 
    
    @Test
    public void testInsertCompany() {
        Company c = new Company();
        c.setId(idWorker.nextId());
        c.setName("创业软件");
        companyService.insert(c);
    }
    
    @Test
    public void testInsertUser() {
        for(int i=7;i<10;i++) {
            User u = new User();
            u.setId(idWorker.nextId());
            u.setCompanyId(342671314403721216L);
            u.setAge(1);
            u.setName("张"+i);
            userService.insert(u);
        }
        
    }
    
    @Test
    public void testCountUser() {
        Integer count = userService.countUser(Arrays.asList(342670793747988480L));
        System.out.println(count);
//        Date date = new Date(4398046511103l);
//        System.out.println(1L&4095L);
    }
    
    @Test
    public void testCountAllCompany() {
        Integer count = companyService.countAllCompany();
        System.out.println(count);
    }
    
    
    
    
}
