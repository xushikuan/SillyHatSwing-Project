package com.sillyhat.learningenglish.business.backups.dto;

import java.io.Serializable;

/**
 * 今日计划单词列表
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class TodayPlanDetailDTO implements Serializable {

    private static final long serialVersionUID = 1545917272572810508L;

    /**
     *  主键
     */
    private String id;

    /**
     *  今日计划ID
     */
    private String todayPlanId;

    /**
     *  单词ID
     */
    private String wordId;

    /**
     * 记忆过程中发生错误次数
     */
    private int isError;

    /**
     * 出现次数
     */
    private int occurrenceNum;

    /**
     *  排序
     */
    private int sortNum;

    /**
     *  创建人
     */
    private String createdUser;

    /**
     *  创建时间
     */
    private String createdDate;

    /**
     *  修改人
     */
    private String updatedUser;

    /**
     *  修改时间
     */
    private String updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodayPlanId() {
        return todayPlanId;
    }

    public void setTodayPlanId(String todayPlanId) {
        this.todayPlanId = todayPlanId;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public int getIsError() {
        return isError;
    }

    public void setIsError(int isError) {
        this.isError = isError;
    }

    public int getOccurrenceNum() {
        return occurrenceNum;
    }

    public void setOccurrenceNum(int occurrenceNum) {
        this.occurrenceNum = occurrenceNum;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "TodayPlanDetail{" +
                "id='" + id + '\'' +
                ", todayPlanId='" + todayPlanId + '\'' +
                ", wordId='" + wordId + '\'' +
                ", isError=" + isError +
                ", occurrenceNum=" + occurrenceNum +
                ", sortNum=" + sortNum +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}