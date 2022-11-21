package com.example.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Goods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.id
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.name
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.price
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.uid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.desc
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.view
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer view;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.count
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.cover
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer cover;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.g_cid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer gCid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.g_scid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer gScid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.is_del
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.create_time
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods.create_by
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    private String createBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.id
     *
     * @return the value of ss_goods.id
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.id
     *
     * @param id the value for ss_goods.id
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.name
     *
     * @return the value of ss_goods.name
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.name
     *
     * @param name the value for ss_goods.name
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.price
     *
     * @return the value of ss_goods.price
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.price
     *
     * @param price the value for ss_goods.price
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.uid
     *
     * @return the value of ss_goods.uid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.uid
     *
     * @param uid the value for ss_goods.uid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.desc
     *
     * @return the value of ss_goods.desc
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.desc
     *
     * @param desc the value for ss_goods.desc
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.view
     *
     * @return the value of ss_goods.view
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getView() {
        return view;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.view
     *
     * @param view the value for ss_goods.view
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setView(Integer view) {
        this.view = view;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.count
     *
     * @return the value of ss_goods.count
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.count
     *
     * @param count the value for ss_goods.count
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.cover
     *
     * @return the value of ss_goods.cover
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getCover() {
        return cover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.g_coverid
     *
     * @param cover the value for ss_goods.g_coverid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setCover(Integer cover) {
        this.cover = cover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.g_cid
     *
     * @return the value of ss_goods.g_cid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getgCid() {
        return gCid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.g_cid
     *
     * @param gCid the value for ss_goods.g_cid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setgCid(Integer gCid) {
        this.gCid = gCid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.g_scid
     *
     * @return the value of ss_goods.g_scid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getgScid() {
        return gScid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.g_scid
     *
     * @param gScid the value for ss_goods.g_scid
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setgScid(Integer gScid) {
        this.gScid = gScid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.is_del
     *
     * @return the value of ss_goods.is_del
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.is_del
     *
     * @param isDel the value for ss_goods.is_del
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.create_time
     *
     * @return the value of ss_goods.create_time
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.create_time
     *
     * @param createTime the value for ss_goods.create_time
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods.create_by
     *
     * @return the value of ss_goods.create_by
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods.create_by
     *
     * @param createBy the value for ss_goods.create_by
     *
     * @mbg.generated Sun Nov 20 19:55:35 CST 2022
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

}