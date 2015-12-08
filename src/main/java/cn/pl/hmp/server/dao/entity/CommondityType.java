package cn.pl.hmp.server.dao.entity;

import java.math.BigDecimal;

public class CommondityType {
    private Long id;

    private String colorEn;

    private Long menuId;

    private BigDecimal price;

    private String sizes;

    private String type;

    private String colorCn;

    private BigDecimal vipPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorEn() {
        return colorEn;
    }

    public void setColorEn(String colorEn) {
        this.colorEn = colorEn == null ? null : colorEn.trim();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getColorCn() {
        return colorCn;
    }

    public void setColorCn(String colorCn) {
        this.colorCn = colorCn == null ? null : colorCn.trim();
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }
}