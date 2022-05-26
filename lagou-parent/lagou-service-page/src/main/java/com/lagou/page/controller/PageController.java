package com.lagou.page.controller;

import com.lagou.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: IceBreaker
 * @Date: 2022-05-26 12:11
 * @Description: TODO
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id) {

        // 发送 HTTP请求给商品微服务(生产者,通过访问生产者的controller的http://localhost:9000/product/query/),
        // 把id传过去, 然后获取到id对应的product对象
        Products products =
                restTemplate.getForObject("http://localhost:9000/product/query/" + id,
                        Products.class);
        System.out.println("从lagou-service-product获得product对象:" + products);
        return products;
    }
}
