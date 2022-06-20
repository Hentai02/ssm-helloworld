package com.example.pojo;

import java.sql.Timestamp;

public class SsUser {

  private long id;
  private String nickname;
  private String username;
  private String password;
  private String avatar;
  private long gender;
  private long is_del;
  private String create_by;
  private java.sql.Timestamp create_time;
  private String update_by;
  private java.sql.Timestamp update_time;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }

  public long getIs_del() {
    return is_del;
  }

  public void setIs_del(long is_del) {
    this.is_del = is_del;
  }

  public String getCreate_by() {
    return create_by;
  }

  public void setCreate_by(String create_by) {
    this.create_by = create_by;
  }

  public Timestamp getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Timestamp create_time) {
    this.create_time = create_time;
  }

  public String getUpdate_by() {
    return update_by;
  }

  public void setUpdate_by(String update_by) {
    this.update_by = update_by;
  }

  public Timestamp getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(Timestamp update_time) {
    this.update_time = update_time;
  }

  @Override
  public String toString() {
    return "SsUser{" +
            "id=" + id +
            ", nickname='" + nickname + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", avatar='" + avatar + '\'' +
            ", gender=" + gender +
            ", is_del=" + is_del +
            ", create_by='" + create_by + '\'' +
            ", create_time=" + create_time +
            ", update_by='" + update_by + '\'' +
            ", update_time=" + update_time +
            '}';
  }
}
