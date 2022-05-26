package com.lagou.product;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: IceBreaker
 * @Date: 2022-05-26 10:35
 * @Description: TODO
 * @Version: 0.0.1
 */

@Slf4j
@SpringBootApplication
@MapperScan("com.lagou.product.mapper")
public class ProductApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(ProductApplication.class);
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
