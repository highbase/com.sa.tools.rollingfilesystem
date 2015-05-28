def HOSTNAME = hostname  // scope 룰 때문에 nested block에서는 hostname 변수 사용불가
 
appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%-5level %d{yyyy-MM-dd HH:mm:ss.SSS} [${HOSTNAME}] [%thread] %logger{36} - %msg%n"
    }
}

//root(TRACE, ['console'])
root(INFO, ['console'])

// 참조. http://kwonnam.pe.kr/wiki/java/logback
