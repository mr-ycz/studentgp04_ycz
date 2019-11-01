import com.ycz.dao.ClazMapper;
import com.ycz.dao.UserMapper;
import com.ycz.pojo.Claz;
import com.ycz.pojo.User;
import com.ycz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDao {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClazMapper clazMapper;
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        List<User> users = userMapper.selectAll();
        System.out.println(users.size());
    }

    @Test
    public void test2(){
        List<Claz> clazs = clazMapper.selectAll();
        System.out.println(clazs.size());
    }

    @Test
    public void test3(){
        List<User> users = userService.queryAll();
        System.out.println(users.size());
    }

}
