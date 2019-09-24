package com.spj.miaosha.dataobject;

import java.math.BigDecimal;

public class ProductDO {
    private String id;

    private String productName;

    private String descri;

    private String imgUrl;

    private BigDecimal price;

    private Integer recomRate;

    private String comment;

    private Integer cales;

    private Integer inventory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductname() {
        return productName;
    }

    public void setProductname(String productname) {
        this.productName = productname == null ? null : productname.trim();
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri == null ? null : descri.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRecomRate() {
        return recomRate;
    }

    public void setRecomRate(Integer recomRate) {
        this.recomRate = recomRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getCales() {
        return cales;
    }

    public void setCales(Integer cales) {
        this.cales = cales;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}