package com.spj.miaosha.control;

import com.spj.miaosha.control.viewobject.ProductVO;
import com.spj.miaosha.dataobject.ProductDO;
import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.response.CommonReturnType;
import com.spj.miaosha.service.ProductService;
import com.spj.miaosha.service.model.ProductModel;
import com.spj.miaosha.validator.ValidationResult;
import com.spj.miaosha.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("product")
public class ProductControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private ValidatorImpl validator;

    @PostMapping("addProduct")
    @ResponseBody
    public CommonReturnType addProduct(@RequestBody ProductVO productVO) throws BusinessException {

        ValidationResult result;
        result = validator.validate(productVO);
        if (result.isHasErros())
            throw new BusinessException(EmBusinssError.PARAMTER_NOT_VALID);
        ProductModel productModel = convertFromProductVO(productVO);
        boolean flage = productService.addProductDO(productModel);
        return CommonReturnType.create(flage);

    }

    private ProductModel convertFromProductVO(ProductVO productVO) {
        if(productVO == null)
            return null;
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productVO, productModel);
        return productModel;
    }
}
