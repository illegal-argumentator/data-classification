package com.nick_brogden.data_classification.domain.site.type;

public enum Category {

    // MARKETING & SALES
    CRM("CRM", "Customer Relationship Management platforms, tools, strategies, and analytics"),
    B2B_MARKETING("B2B", "Business-to-business strategies, lead generation, account-based marketing, and campaigns"),
    B2C_MARKETING("B2C", "Business-to-consumer strategies, brand awareness, and direct marketing campaigns"),
    EMAIL_MARKETING("EMAIL", "Email campaigns, newsletters, automation, personalization, and analytics"),
    AFFILIATE_MARKETING("AFFILIATE", "Partner programs, commission-based marketing, and referral strategies"),
    CONTENT_MARKETING("CONTENT", "Blog posts, articles, videos, SEO-focused content, and storytelling"),
    SOCIAL_MEDIA_MARKETING("SOCIAL", "Campaigns on Facebook, Instagram, LinkedIn, Twitter, TikTok"),
    INFLUENCER_MARKETING("INFLUENCER", "Brand promotion via influencers, sponsorships, and collaborations"),
    SEO_SEM("SEO", "Search engine optimization, paid search, PPC, Google Ads, keyword strategies"),
    LEAD_GENERATION("LEAD", "Methods to acquire potential clients, landing pages, and forms"),
    SALES_AUTOMATION("SALES", "Tools to automate CRM, lead nurturing, and follow-ups"),
    BRANDING("BRAND", "Visual identity, logos, style guides, and design systems"),

    // FINANCE & BANKING
    BANKING("BANK", "Traditional banking services, digital banking platforms, and financial institutions"),
    FINTECH("FINTECH", "Innovative financial technology solutions, apps, payment systems, and digital wallets"),
    INVESTMENTS("INVEST", "Stocks, bonds, portfolio management, ETFs, mutual funds, robo-advisors"),
    PERSONAL_FINANCE("PERSONAL", "Budgeting, financial planning, money management, and saving tools"),
    ACCOUNTING("ACCOUNTING", "Accounting software, bookkeeping practices, tax compliance"),
    INSURANCE("INSURANCE", "Life, health, property, vehicle insurance products and platforms"),
    CRYPTOCURRENCY("CRYPTO", "Digital currencies, crypto wallets, exchanges, and DeFi"),
    LOANS("LOANS", "Personal loans, mortgages, credit cards, lending platforms"),
    STOCK_MARKET("STOCK", "Trading platforms, equity analysis, market data, and brokerage services"),
    TAX_SERVICES("TAX", "Tax preparation, filing services, planning, and consultancy"),

    // IT & SOFTWARE
    SOFTWARE_DEVELOPMENT("DEVELOPMENT", "Coding, programming languages, frameworks, and methodologies"),
    SAAS("SAAS", "Software as a Service platforms, cloud applications, and subscription-based software"),
    AI("AI", "Artificial intelligence, neural networks, predictive analytics, and automation"),
    CLOUD_COMPUTING("CLOUD", "Cloud platforms, infrastructure, storage, and deployment solutions"),
    CYBERSECURITY("SECURITY", "Network security, penetration testing, threat detection, and protection"),
    DATA_SCIENCE("DATA", "Data analytics, visualization, statistical modeling, data pipelines"),
    IOT("IOT", "Internet of Things devices, connectivity, smart home, and industrial IoT"),
    IT_CONSULTING("IT", "Strategy, system integration, infrastructure advisory, IT services"),
    WEB_HOSTING("HOSTING", "Hosting providers, domain registration, and server solutions"),
    MOBILE_APPS("MOBILE", "Application development for iOS, Android, and cross-platform frameworks"),

    // E-COMMERCE & RETAIL
    E_COMMERCE("ECOM", "Online stores, shopping cart solutions, and marketplace tools"),
    ONLINE_MARKETPLACES("MARKET", "Multi-vendor platforms like Amazon, eBay, Etsy"),
    RETAIL_TECH("RETAIL", "POS systems, inventory management, in-store technology solutions"),
    DROPSHIPPING("DROPSHIP", "Order fulfillment models, supplier integration, and logistics automation"),
    PAYMENT_GATEWAYS("PAYMENT", "Payment processing platforms, merchant accounts, and APIs"),
    SUBSCRIPTION_SERVICES("SUBSCRIBE", "Recurring billing platforms, subscription management"),
    PRODUCT_REVIEWS("REVIEWS", "Review platforms, comparison websites, ratings aggregation"),

    // ADDITIONAL TECHNOLOGY & BUSINESS CATEGORIES
    DIGITAL_MARKETING("DIGITAL", "Online advertising, content strategy, social media campaigns, SEO/SEM"),
    E_LEARNING("ELEARN", "Online courses, learning management systems, educational platforms"),
    HEALTH_TECH("HEALTH", "Digital health, telemedicine, wearable health devices, healthcare IT"),
    GREEN_TECH("GREEN", "Sustainable technology, renewable energy platforms, eco-friendly solutions"),
    LEGAL_TECH("LEGAL", "Legal document automation, online legal services, contract management"),
    HR_TECH("HR", "Human resources platforms, recruitment software, employee management"),
    LOGISTICS("LOGISTICS", "Shipping, delivery platforms, inventory management, tracking systems"),
    GAMING("GAMING", "Video games, platforms, streaming, eSports"),
    ENTERTAINMENT("ENTERTAIN", "Media streaming, movies, music, TV platforms, content creation"),
    TRAVEL_TECH("TRAVEL", "Booking platforms, travel management, airlines, tourism technology"),
    FOOD_TECH("FOOD", "Food delivery apps, meal kits, restaurant tech, online ordering systems"),
    SMART_HOME("SMART", "Home automation, smart devices, IoT control, security systems"),

    // OTHER
    NEWS_MEDIA("NEWS", "News and media platforms: online news, magazines, news agencies"),
    GOVERNMENT("GOV", "Governmental and international organizations: official sites, political institutions, international agencies"),
    EDUCATION("EDU", "Universities, educational and research platforms, scientific organizations"),
    COMMUNITY("COMM", "Online communities, forums, knowledge-sharing platforms, developer resources"),
    VIDEO_STREAMING("VIDEO", "Video sharing and streaming platforms, media content platforms"),
    TRAVEL_HOSPITALITY("TRAVEL", "Travel and hospitality services: bookings, accommodations, tourism platforms"),
    PAYMENT_SERVICES("PAY", "Online payment systems, transaction services, digital wallets"),
    SOCIAL_NETWORKS("SOCIAL", "Social networking platforms for user interaction, posting, and communication");

    private final String shortName;
    private final String displayDescription;

    Category(String shortName, String displayDescription) {
        this.shortName = shortName;
        this.displayDescription = displayDescription;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDisplayDescription() {
        return displayDescription;
    }
}