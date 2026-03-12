package com.nick_brogden.data_classification.domain.site.type;

public enum Category {

    // MARKETING & SALES
    CRM("CRM: Customer Relationship Management platforms, tools, strategies, and analytics"),
    B2B_MARKETING("B2B Marketing: Business-to-business strategies, lead generation, account-based marketing, and campaigns"),
    B2C_MARKETING("B2C Marketing: Business-to-consumer strategies, brand awareness, and direct marketing campaigns"),
    EMAIL_MARKETING("Email Marketing: Email campaigns, newsletters, automation, personalization, and analytics"),
    AFFILIATE_MARKETING("Affiliate Marketing: Partner programs, commission-based marketing, and referral strategies"),
    CONTENT_MARKETING("Content Marketing: Blog posts, articles, videos, SEO-focused content, and storytelling"),
    SOCIAL_MEDIA_MARKETING("Social Media Marketing: Campaigns on Facebook, Instagram, LinkedIn, Twitter, TikTok"),
    INFLUENCER_MARKETING("Influencer Marketing: Brand promotion via influencers, sponsorships, and collaborations"),
    SEO_SEM("SEO / SEM: Search engine optimization, paid search, PPC, Google Ads, keyword strategies"),
    LEAD_GENERATION("Lead Generation: Methods to acquire potential clients, landing pages, and forms"),
    SALES_AUTOMATION("Sales Automation: Tools to automate CRM, lead nurturing, and follow-ups"),
    BRANDING("Branding & Design: Visual identity, logos, style guides, and design systems"),

    // FINANCE & BANKING
    BANKING("Banking: Traditional banking services, digital banking platforms, and financial institutions"),
    FINTECH("FinTech: Innovative financial technology solutions, apps, payment systems, and digital wallets"),
    INVESTMENTS("Investments: Stocks, bonds, portfolio management, ETFs, mutual funds, robo-advisors"),
    PERSONAL_FINANCE("Personal Finance: Budgeting, financial planning, money management, and saving tools"),
    ACCOUNTING("Accounting & Bookkeeping: Accounting software, bookkeeping practices, tax compliance"),
    INSURANCE("Insurance: Life, health, property, vehicle insurance products and platforms"),
    CRYPTOCURRENCY("Cryptocurrency / Blockchain: Digital currencies, crypto wallets, exchanges, and DeFi"),
    LOANS("Loans & Credit: Personal loans, mortgages, credit cards, lending platforms"),
    STOCK_MARKET("Stock Market: Trading platforms, equity analysis, market data, and brokerage services"),
    TAX_SERVICES("Tax Services: Tax preparation, filing services, planning, and consultancy"),

    // IT & SOFTWARE
    SOFTWARE_DEVELOPMENT("Software Development: Coding, programming languages, frameworks, and methodologies"),
    SAAS("SaaS: Software as a Service platforms, cloud applications, and subscription-based software"),
    AI("AI / Machine Learning: Artificial intelligence, neural networks, predictive analytics, and automation"),
    CLOUD_COMPUTING("Cloud Computing: Cloud platforms, infrastructure, storage, and deployment solutions"),
    CYBERSECURITY("Cybersecurity: Network security, penetration testing, threat detection, and protection"),
    DATA_SCIENCE("Data Science & Big Data: Data analytics, visualization, statistical modeling, data pipelines"),
    IOT("IoT: Internet of Things devices, connectivity, smart home, and industrial IoT"),
    IT_CONSULTING("IT Consulting: Strategy, system integration, infrastructure advisory, IT services"),
    WEB_HOSTING("Web Hosting / Domain Services: Hosting providers, domain registration, and server solutions"),
    MOBILE_APPS("Mobile Apps: Application development for iOS, Android, and cross-platform frameworks"),

    // E-COMMERCE & RETAIL
    E_COMMERCE("E-commerce Platforms: Online stores, shopping cart solutions, and marketplace tools"),
    ONLINE_MARKETPLACES("Online Marketplaces: Multi-vendor platforms like Amazon, eBay, Etsy"),
    RETAIL_TECH("Retail Tech: POS systems, inventory management, in-store technology solutions"),
    DROPSHIPPING("Dropshipping: Order fulfillment models, supplier integration, and logistics automation"),
    PAYMENT_GATEWAYS("Payment Gateways: Payment processing platforms, merchant accounts, and APIs"),
    SUBSCRIPTION_SERVICES("Subscription Services: Recurring billing platforms, subscription management"),
    PRODUCT_REVIEWS("Product Reviews / Comparison: Review platforms, comparison websites, ratings aggregation"),

    // ADDITIONAL TECHNOLOGY & BUSINESS CATEGORIES
    DIGITAL_MARKETING("Digital Marketing: Online advertising, content strategy, social media campaigns, SEO/SEM"),
    E_LEARNING("E-Learning: Online courses, learning management systems, educational platforms"),
    HEALTH_TECH("Health Tech: Digital health, telemedicine, wearable health devices, healthcare IT"),
    GREEN_TECH("Green Tech: Sustainable technology, renewable energy platforms, eco-friendly solutions"),
    LEGAL_TECH("Legal Tech: Legal document automation, online legal services, contract management"),
    HR_TECH("HR Tech: Human resources platforms, recruitment software, employee management"),
    LOGISTICS("Logistics & Supply Chain: Shipping, delivery platforms, inventory management, tracking systems"),
    GAMING("Gaming: Video games, platforms, streaming, eSports"),
    ENTERTAINMENT("Entertainment: Media streaming, movies, music, TV platforms, content creation"),
    TRAVEL_TECH("Travel Tech: Booking platforms, travel management, airlines, tourism technology"),
    FOOD_TECH("Food Tech: Food delivery apps, meal kits, restaurant tech, online ordering systems"),
    SMART_HOME("Smart Home: Home automation, smart devices, IoT control, security systems");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}