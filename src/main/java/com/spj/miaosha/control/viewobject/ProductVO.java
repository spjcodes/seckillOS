package com.spj.miaosha.control.viewobject;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductVO {

    //主键
    @Getter
    @Setter
    String id;
    //商品名
    @Getter
    @Setter
    String productName;
    //商品描述
    @Getter
    @Setter
    String descri;
    //图片url
    @Getter
    @Setter
    String imgUrl;
    //价格
    @Getter
    @Setter
    double price;
    //推荐星数 recommendation reate
    @Getter
    @Setter
    Integer recomRate;
    //评论
    @Getter
    @Setter
    String comment;
    //销量
    @Getter
    @Setter
    Integer cales;
    //库存
    @Getter
    @Setter
    Integer inventory;
}
