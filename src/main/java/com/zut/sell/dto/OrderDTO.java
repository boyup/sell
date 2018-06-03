package com.zut.sell.dto;

import com.zut.sell.dataobject.OrderDetail;
import com.zut.sell.enums.OrderStatusEnum;
import com.zut.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Jason
 * @Date 2018/5/23 20:38
 * @Description
 */

@Data
public class OrderDTO {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /**
     * 订单状态，默认 0 为新下订单
     */
    private Integer orderStatus;

    /**
     * 默认为 0 未支付
     */
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;





}
