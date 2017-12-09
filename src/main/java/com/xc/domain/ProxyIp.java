package com.xc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author xiong
 * @date：2017年10月28日 下午8:38:34
 * @Description:
 */
@Entity
public class ProxyIp {

    @Id
    @GeneratedValue
    private Integer id;
    private String country;
    private String ipAddress;
    private String port;
    private String serverAddress;
    private Boolean gaoni;
    private String type;
    private String speed;
    private String connectionTime;
    private String aliveDays;
    private String verifyMinutes;
    private Integer status;

    @Column(insertable = false, updatable = false,columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date gmtModified;

    @Column(insertable = false, updatable = false,columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP")
    private Date gmtCreate;

   
    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * @param speed
     *            the speed to set
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * @return the connectionTime
     */
    public String getConnectionTime() {
        return connectionTime;
    }

    /**
     * @param connectionTime
     *            the connectionTime to set
     */
    public void setConnectionTime(String connectionTime) {
        this.connectionTime = connectionTime;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     *            the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port
     *            the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the serverAddress
     */
    public String getServerAddress() {
        return serverAddress;
    }

    /**
     * @param serverAddress
     *            the serverAddress to set
     */
    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    /**
     * @return the gaoni
     */
    public Boolean getGaoni() {
        return gaoni;
    }

    /**
     * @param gaoni
     *            the gaoni to set
     */
    public void setGaoni(Boolean gaoni) {
        this.gaoni = gaoni;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the aliveDays
     */
    public String getAliveDays() {
        return aliveDays;
    }

    /**
     * @param aliveDays
     *            the aliveDays to set
     */
    public void setAliveDays(String aliveDays) {
        this.aliveDays = aliveDays;
    }

    /**
     * @return the verifyMinutes
     */
    public String getVerifyMinutes() {
        return verifyMinutes;
    }

    /**
     * @param verifyMinutes
     *            the verifyMinutes to set
     */
    public void setVerifyMinutes(String verifyMinutes) {
        this.verifyMinutes = verifyMinutes;
    }

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     *            the gmtModified to set
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = new Date();
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     *            the gmtCreate to set
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = new Date();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProxyIp [id=");
        builder.append(id);
        builder.append(", country=");
        builder.append(country);
        builder.append(", ipAddress=");
        builder.append(ipAddress);
        builder.append(", port=");
        builder.append(port);
        builder.append(", serverAddress=");
        builder.append(serverAddress);
        builder.append(", gaoni=");
        builder.append(gaoni);
        builder.append(", type=");
        builder.append(type);
        builder.append(", speed=");
        builder.append(speed);
        builder.append(", connectionTime=");
        builder.append(connectionTime);
        builder.append(", aliveDays=");
        builder.append(aliveDays);
        builder.append(", verifyMinutes=");
        builder.append(verifyMinutes);
        builder.append(", gmtModified=");
        builder.append(gmtModified);
        builder.append(", gmtCreate=");
        builder.append(gmtCreate);
        builder.append("]");
        return builder.toString();
    }

}
