package com.xc.ProxyIp.domain;

import java.util.ArrayList;
import java.util.List;

import com.xc.domain.ProxyIp;

/** 
 * @author xiong
 * @date：2017年10月28日 下午8:50:40 
 * @Description:
 */
public class XiCiInlandGaoNiIpPage {
    private Integer totalPage;
    private Integer currentPage;
    private String url;
    private List<ProxyIp> list = new ArrayList<ProxyIp>();
    /**
     * @return the totalPage
     */
    public Integer getTotalPage() {
        return totalPage;
    }
    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    /**
     * @return the currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }
    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return the list
     */
    public List<ProxyIp> getList() {
        return list;
    }
    /**
     * @param list the list to set
     */
    public void setList(List<ProxyIp> list) {
        this.list = list;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("XiCiInlandGaoNiIpPage [totalPage=");
        builder.append(totalPage);
        builder.append(", currentPage=");
        builder.append(currentPage);
        builder.append(", url=");
        builder.append(url);
        builder.append(", list=");
        builder.append(list);
        builder.append("]");
        return builder.toString();
    }
}
