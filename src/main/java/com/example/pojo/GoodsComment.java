package com.example.pojo;

import java.util.Date;

public class GoodsComment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.uid
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.g_id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private Integer gId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.is_del
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.create_time
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.create_by
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ss_goods_comment.content
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.id
     *
     * @return the value of ss_goods_comment.id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.id
     *
     * @param id the value for ss_goods_comment.id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.uid
     *
     * @return the value of ss_goods_comment.uid
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.uid
     *
     * @param uid the value for ss_goods_comment.uid
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.g_id
     *
     * @return the value of ss_goods_comment.g_id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public Integer getgId() {
        return gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.g_id
     *
     * @param gId the value for ss_goods_comment.g_id
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setgId(Integer gId) {
        this.gId = gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.is_del
     *
     * @return the value of ss_goods_comment.is_del
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.is_del
     *
     * @param isDel the value for ss_goods_comment.is_del
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.create_time
     *
     * @return the value of ss_goods_comment.create_time
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.create_time
     *
     * @param createTime the value for ss_goods_comment.create_time
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.create_by
     *
     * @return the value of ss_goods_comment.create_by
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.create_by
     *
     * @param createBy the value for ss_goods_comment.create_by
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ss_goods_comment.content
     *
     * @return the value of ss_goods_comment.content
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ss_goods_comment.content
     *
     * @param content the value for ss_goods_comment.content
     *
     * @mbg.generated Mon Nov 28 14:35:32 CST 2022
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String nickname;
    private String avatar;


    @Override
    public String toString() {
        return "GoodsComment{" +
                "id=" + id +
                ", uid=" + uid +
                '}';
    }
}