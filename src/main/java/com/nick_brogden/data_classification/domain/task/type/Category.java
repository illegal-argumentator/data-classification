package com.nick_brogden.data_classification.domain.task.type;

public enum Category {

    CRM("CRM"),
    B2B_MARKETING("B2B Marketing"),
    B2C_MARKETING("B2C Marketing"),
    EMAIL_MARKETING("Email Marketing"),
    AFFILIATE_MARKETING("Affiliate Marketing"),
    CONTENT_MARKETING("Content Marketing"),
    SOCIAL_MEDIA_MARKETING("Social Media Marketing"),
    INFLUENCER_MARKETING("Influencer Marketing"),
    SEO_SEM("SEO / SEM"),
    LEAD_GENERATION("Lead Generation"),
    SALES_AUTOMATION("Sales Automation"),
    BRANDING("Branding & Design"),

    BANKING("Banking"),
    FINTECH("FinTech"),
    INVESTMENTS("Investments"),
    PERSONAL_FINANCE("Personal Finance"),
    ACCOUNTING("Accounting & Bookkeeping"),
    INSURANCE("Insurance"),
    CRYPTOCURRENCY("Cryptocurrency / Blockchain"),
    LOANS("Loans & Credit"),
    STOCK_MARKET("Stock Market"),
    TAX_SERVICES("Tax Services"),

    SOFTWARE_DEVELOPMENT("Software Development"),
    SAAS("SaaS"),
    AI("AI / Machine Learning"),
    CLOUD_COMPUTING("Cloud Computing"),
    CYBERSECURITY("Cybersecurity"),
    DATA_SCIENCE("Data Science & Big Data"),
    IOT("IoT"),
    IT_CONSULTING("IT Consulting"),
    WEB_HOSTING("Web Hosting / Domain Services"),
    MOBILE_APPS("Mobile Apps"),

    E_COMMERCE("E-commerce Platforms"),
    ONLINE_MARKETPLACES("Online Marketplaces"),
    RETAIL_TECH("Retail Tech"),
    DROPSHIPPING("Dropshipping"),
    PAYMENT_GATEWAYS("Payment Gateways"),
    SUBSCRIPTION_SERVICES("Subscription Services"),
    PRODUCT_REVIEWS("Product Reviews / Comparison");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
