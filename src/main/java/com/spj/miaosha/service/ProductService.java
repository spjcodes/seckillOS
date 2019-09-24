package com.spj.miaosha.service;

import com.spj.miaosha.dataobject.ProductDO;
import com.spj.miaosha.service.model.ProductModel;

import java.util.List;

public interface ProductService  {

    public ProductDO getProduct(String id);
    public List<ProductDO> getProductList();
    public boolean addProductDO(ProductModel productModel);
    public boolean deleteProductDO(String id);
    public boolean updateProductDO(ProductModel productModel);

}
