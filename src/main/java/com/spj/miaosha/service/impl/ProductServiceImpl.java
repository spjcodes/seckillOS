package com.spj.miaosha.service.impl;

import com.spj.miaosha.dao.InvoentProductsDOMapper;
import com.spj.miaosha.dao.ProductDOMapper;
import com.spj.miaosha.dataobject.InvoentProductsDO;
import com.spj.miaosha.dataobject.ProductDO;
import com.spj.miaosha.service.ProductService;
import com.spj.miaosha.service.model.ProductModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDOMapper productDOMapper;
    @Autowired
    private InvoentProductsDOMapper invoentProductsDOMapper;

    @Override
    public ProductDO getProduct(String id) {
        return null;
    }

    @Override
    public List<ProductDO> getProductList() {
        return null;
    }

    @Transactional
    @Override
    public boolean addProductDO(ProductModel productModel) {
        if (productModel == null)
            return false;
        ProductDO productDO = convertFromProductModel(productModel);
        int flage = productDOMapper.insertSelective(productDO);

       InvoentProductsDO invoentProductsDO = InvProconvertFromProductModel(productDO);
       int flage0 = invoentProductsDOMapper.insertSelective(invoentProductsDO);
       if (flage>0 & flage0>0)
            return true;
        return false;
    }

    private InvoentProductsDO InvProconvertFromProductModel(ProductDO productDO) {
        if (productDO == null)
            return null;
        String produId = productDOMapper.selectIdByName(productDO.getProductname());
        InvoentProductsDO invoentProductsDO = new InvoentProductsDO();
        invoentProductsDO.setProductId(produId);
        invoentProductsDO.setInventory(productDO.getInventory());
        return invoentProductsDO;
    }

    private ProductDO convertFromProductModel(ProductModel productModel) {
        if(productModel == null)
            return null;
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(productModel,productDO);
        productDO.setProductname(productModel.getProductName());
        productDO.setPrice(BigDecimal.valueOf(productModel.getPrice()));
        return productDO;
    }

    @Override
    public boolean deleteProductDO(String id) {
        return false;
    }

    @Override
    public boolean updateProductDO(ProductModel productModel) {
        return false;
    }
}
