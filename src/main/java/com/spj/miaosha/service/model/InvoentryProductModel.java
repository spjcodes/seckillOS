package com.spj.miaosha.service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class InvoentryProductModel {

    @Getter
    @Setter
    String id;

    @Getter
    @Setter
    Integer inventory;

    @Getter
    @Setter
    String productId;
}
