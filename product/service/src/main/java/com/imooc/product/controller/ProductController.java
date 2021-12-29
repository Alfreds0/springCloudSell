package com.imooc.product.controller;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutPut;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dataobject.vo.ProductCategoryVo;
import com.imooc.product.dataobject.vo.ProductInfoVo;
import com.imooc.product.dataobject.vo.ResultVo;

import com.imooc.product.service.ProductCategoryService;
import com.imooc.product.service.ProductInfoService;
import com.imooc.product.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 1.查询所有的在架商品
     * 2.获取类目typeList
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    private ResultVo<ProductCategoryVo> list() {
        //1.查询所有的在架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.获取类目typeList
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //4.构造数据
        List<ProductCategoryVo> productCategoryVoList=new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductCategoryVo productCategoryVo = new ProductCategoryVo();
            productCategoryVo.setCategoryName(productCategory.getCategoryName());
            productCategoryVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList=new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
                productCategoryVo.setProductInfoVoList(productInfoVoList);
                productCategoryVoList.add(productCategoryVo);
            }

        }

        return ResultVoUtil.success(productCategoryVoList);

    }

    /**
     * 获取商品列表给订单服务用
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    private List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productIdList) {
        List<ProductInfoOutPut> productInfoOutPutList= productInfoService.findList(productIdList);
        return productInfoOutPutList;
    }

    /**
     * 扣库存
     * @param decreaseStockInputList
     * @return
     */
    @PostMapping("/decreaseStock")
    private void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productInfoService.decreaseStock(decreaseStockInputList);
    }
}
