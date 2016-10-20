package com.wjf.mywjf.home.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/6/17 0017.
 */
public class HeadAdvertisements implements Serializable {

    //点击暂停的时候的状态
    public static final int PAUSED = 30;
    //下载成功的时候的状态
    public static final int SUCCEES = 10;
    //下载中的时候的状态
    public static final int DOWNING = 20;

    public static final int FINISHED = 40;

    //是否缓存视频

    public static final int VIDEO_CONPLETE = 50;//缓存完成
    public static final int VIDEO_DOWNING = 60;//正在缓存
    public static final int VIDEO_WAIT = 70;//没有缓存

    //停止下载还是继续下载
    public static final int VIDEO_STOP = 80;
    public static final int VIDEO_CONTINUE = 90;
    public int stop;

    public int downwait;
    public int id;
    public String adId;
    public String name;
    public String adType;
    public String adHomepage;
    public String descr;
    public String duration;
    public String adSize;
    public String pictureNum;
    //    public List<String> mobileVersionUrl;
    public String mobileVersionUrl;
    public String createTime;
    public String updateTime;
    public String validityPeriod;
    public String playNum;
    public String price;

    public String advUrl;
    public String videpath;

    public int status;

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getDownwait() {
        return downwait;
    }

    public void setDownwait(int downwait) {
        this.downwait = downwait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getSUCCEES() {
        return SUCCEES;
    }

    public static int getDOWNING() {
        return DOWNING;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAdHomepage() {
        return adHomepage;
    }

    public void setAdHomepage(String adHomepage) {
        this.adHomepage = adHomepage;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAdSize() {
        return adSize;
    }

    public void setAdSize(String adSize) {
        this.adSize = adSize;
    }

    public String getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(String pictureNum) {
        this.pictureNum = pictureNum;
    }

    public String getMobileVersionUrl() {
        return mobileVersionUrl;
    }

    public void setMobileVersionUrl(String mobileVersionUrl) {
        this.mobileVersionUrl = mobileVersionUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getPlayNum() {
        return playNum;
    }

    public void setPlayNum(String playNum) {
        this.playNum = playNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVidepath() {
        return videpath;
    }

    public void setVidepath(String videpath) {
        this.videpath = videpath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
