package com.sillyhat.learningenglish.business.personalinformation.dto;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author 徐士宽
 * @date 2017/3/14 13:39
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 785070109836209587L;

    /**
     *  主键
     */
    private long id;

    /**
     *  账号
     */
    private String login;

    /**
     *  密码
     */
    private String password;

    /**
     *  用户名
     */
    private String userName;

    /**
     *  是否删除；0：未删除；1：删除
     */
    private int isDelete;

    /**
     *  是否超管；0：不是；1：是
     */
    private int isAdministrators;

    /**
     *  创建人
     */
    private long createdUser;

    /**
     *  创建时间
     */
    private String createdDate;

    /**
     *  修改人
     */
    private long updatedUser;

    /**
     *  修改时间
     */
    private String updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getIsAdministrators() {
        return isAdministrators;
    }

    public void setIsAdministrators(int isAdministrators) {
        this.isAdministrators = isAdministrators;
    }

    public long getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(long createdUser) {
        this.createdUser = createdUser;
    }

    public long getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(long updatedUser) {
        this.updatedUser = updatedUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", isDelete=" + isDelete +
                ", isAdministrators=" + isAdministrators +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
