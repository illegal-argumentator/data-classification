FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /build

COPY pom.xml ./
RUN mvn dependency:resolve

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app

RUN apt-get update && apt-get install -y \
    locales \
    libglib2.0-0 \
    libnss3 \
    libnspr4 \
    libdbus-1-3 \
    libatk1.0-0 \
    libatk-bridge2.0-0 \
    libatspi2.0-0 \
    libx11-6 \
    libxcomposite1 \
    libxdamage1 \
    libxext6 \
    libxfixes3 \
    libxrandr2 \
    libgbm1 \
    libdrm2 \
    libxcb1 \
    libxkbcommon0 \
    libasound2t64 \
    libcairo2 \
    libpango-1.0-0 \
    libcups2 \
    libxcursor1 \
    libgtk-3-0t64 \
    libpangocairo-1.0-0 \
    libcairo-gobject2 \
    libgdk-pixbuf-2.0-0 \
    && rm -rf /var/lib/apt/lists/*

RUN locale-gen en_US.UTF-8 && update-locale LANG=en_US.UTF-8

ENV LANG=en_US.UTF-8
ENV LANGUAGE=en_US:en
ENV LC_ALL=en_US.UTF-8

COPY --from=build /build/target/data-classification*.jar app.jar

EXPOSE 9194

CMD ["java", "-jar", "app.jar"]