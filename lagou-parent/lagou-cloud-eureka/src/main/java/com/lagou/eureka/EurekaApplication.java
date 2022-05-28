package com.lagou.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: IceBreaker
 * @Date: 2022-05-27 17:41
 * @Description: TODO
 * @Version: 0.0.1
 */
@SpringBootApplication
// @EnableEurekaServer // 声明本module是一个Eureka服务
@EnableDiscoveryClient // (可用于Nacos和Eureka等等其他注册中心)通用的, 把当前服务表示为注册中心的client
@Slf4j
public class EurekaApplication {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(EurekaApplication.class);
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
}
