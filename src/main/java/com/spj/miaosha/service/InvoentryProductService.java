package com.spj.miaosha.service;

import com.spj.miaosha.dataobject.InvoentProductsDO;

import java.util.List;

public interface InvoentryProductService {

    public boolean addInvoentryProduct(InvoentProductsDO invoentProductsDO);
    public boolean updateInvoentryProduct(InvoentProductsDO invoentProductsDO);
    public boolean deleteInvoentry(String id);
    public InvoentProductsDO getInvotetryProductDO(String id);
    public List<InvoentProductsDO> getInvoentrhyProductList();
}
