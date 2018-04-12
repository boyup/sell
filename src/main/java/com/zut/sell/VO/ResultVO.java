package com.zut.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {

    /** 返回的状态码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 具体数据 */
    private T data;

}
