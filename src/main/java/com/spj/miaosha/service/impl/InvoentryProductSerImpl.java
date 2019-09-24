package com.spj.miaosha.service.impl;

import com.spj.miaosha.dao.InvoentProductsDOMapper;
import com.spj.miaosha.dataobject.InvoentProductsDO;
import com.spj.miaosha.service.InvoentryProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvoentryProductSerImpl implements InvoentryProductService {

    @Autowired
    private InvoentProductsDOMapper invoentProductsDOMapper;

    @Override
    public boolean addInvoentryProduct(InvoentProductsDO invoentProductsDO) {
        if (invoentProductsDO == null)
            return false;
        return false;
    }

    @Override
    public boolean updateInvoentryProduct(InvoentProductsDO invoentProductsDO) {
        return false;
    }

    @Override
    public boolean deleteInvoentry(String id) {
        return false;
    }

    @Override
    public InvoentProductsDO getInvotetryProductDO(String id) {
        return null;
    }

    @Override
    public List<InvoentProductsDO> getInvoentrhyProductList() {
        return null;
    }
}
