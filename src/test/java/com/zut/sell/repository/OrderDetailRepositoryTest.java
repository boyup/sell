package com.zut.sell.repository;

import com.zut.sell.dataobject.OrderDetail;
import com.zut.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345679");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("111123");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal("1.2"));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList= repository.findByOrderId("11111111");
        Assert.assertNotEquals(0,orderDetailList.size());

    }
}