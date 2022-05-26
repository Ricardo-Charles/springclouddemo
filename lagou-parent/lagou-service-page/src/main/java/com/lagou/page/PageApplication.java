package com.lagou.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: IceBreaker
 * @Date: 2022-05-26 12:03
 * @Description: TODO
 * @Version: 0.0.1
 */

@Slf4j
@SpringBootApplication
public class PageApplication {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(PageApplication.class);
        Environment env = app.run(args).getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        port = port == null ? "8080" : port;
        String path = env.getProperty("server.servlet.context-path");
        path = path == null ? "" : path;
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Demo is running! Access URLs:\n\t" +
                "本地访问地址: \thttp://localhost:" + port + path + "/\n\t" +
                "外部访问地址: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

    // 向容器中注入一个RestTemplate，封装了HttpClient
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
