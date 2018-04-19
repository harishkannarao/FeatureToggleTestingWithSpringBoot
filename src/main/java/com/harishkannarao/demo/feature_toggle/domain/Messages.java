package com.harishkannarao.demo.feature_toggle.domain;

public class Messages {
    private final String productMessage;
    private final String bannerMessage;

    public Messages(String productMessage, String bannerMessage) {
        this.productMessage = productMessage;
        this.bannerMessage = bannerMessage;
    }

    public Messages(String productMessage) {
        this.productMessage = productMessage;
        this.bannerMessage = null;
    }

    public String getProductMessage() {
        return productMessage;
    }

    public String getBannerMessage() {
        return bannerMessage;
    }
}
