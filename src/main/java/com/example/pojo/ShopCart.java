package com.example.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ShopCart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private String name;
    private String cover;
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.count
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Integer count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.g_id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Integer gId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.uid
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.is_del
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.create_by
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_shop_cart.create_time
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.id
     *
     * @return the value of ss_shop_cart.id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.id
     *
     * @param id the value for ss_shop_cart.id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.count
     *
     * @return the value of ss_shop_cart.count
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.count
     *
     * @param count the value for ss_shop_cart.count
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.g_id
     *
     * @return the value of ss_shop_cart.g_id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Integer getgId() {
        return gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.g_id
     *
     * @param gId the value for ss_shop_cart.g_id
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setgId(Integer gId) {
        this.gId = gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.uid
     *
     * @return the value of ss_shop_cart.uid
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.uid
     *
     * @param uid the value for ss_shop_cart.uid
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.is_del
     *
     * @return the value of ss_shop_cart.is_del
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.is_del
     *
     * @param isDel the value for ss_shop_cart.is_del
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.create_by
     *
     * @return the value of ss_shop_cart.create_by
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.create_by
     *
     * @param createBy the value for ss_shop_cart.create_by
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_shop_cart.create_time
     *
     * @return the value of ss_shop_cart.create_time
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_shop_cart.create_time
     *
     * @param createTime the value for ss_shop_cart.create_time
     *
     * @mbg.generated Mon Nov 28 17:57:33 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}