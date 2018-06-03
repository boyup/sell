package com.zut.sell.controller;

import com.zut.sell.VO.ProductInfoVO;
import com.zut.sell.VO.ProductVO;
import com.zut.sell.VO.ResultVO;
import com.zut.sell.dataobject.ProductCategory;
import com.zut.sell.dataobject.ProductInfo;
import com.zut.sell.service.CategoryService;
import com.zut.sell.service.ProductService;
import com.zut.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jason
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有上架商品
        List<ProductInfo> productInfolist = productService.findUpAll();

        // 2. 查询类目（一次性查询）
        // List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
        /*for (ProductInfo productInfo : productInfolist){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        // 精简方法（lambda表达式）
        List<Integer> categoryTypeList = productInfolist.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfolist){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
