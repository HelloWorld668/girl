package com.xc.ProxyIp.domain;

import com.xc.model.Proxy;


/** 
 * @author xiong
 * @date：2017年12月11日 下午9:33:08 
 * @Description:
 */
public class Page {
    private String url;
    private int statusCode;//响应状态码
    private String html;//response content
    private Proxy proxy;
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
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    /**
     * @return the html
     */
    public String getHtml() {
        return html;
    }
    /**
     * @param html the html to set
     */
    public void setHtml(String html) {
        this.html = html;
    }
    /**
     * @return the proxy
     */
    public Proxy getProxy() {
        return proxy;
    }
    /**
     * @param proxy the proxy to set
     */
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [url=");
        builder.append(url);
        builder.append(", statusCode=");
        builder.append(statusCode);
        builder.append(", html=");
        builder.append(html);
        builder.append(", proxy=");
        builder.append(proxy);
        builder.append("]");
        return builder.toString();
    }
    
}
