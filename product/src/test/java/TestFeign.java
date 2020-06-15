import com.seckill.ProductApplication;
import com.seckill.ordercenter.OrderCenter2Api;
import com.seckill.ordercenter.OrderCenterApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ProductApplication.class)
@RunWith(SpringRunner.class)
public class TestFeign {

    @Autowired
    private OrderCenterApi orderCenterApi;

    @Test
    public void test(){
        System.out.println(orderCenterApi.getOrder("123"));
    }

}
