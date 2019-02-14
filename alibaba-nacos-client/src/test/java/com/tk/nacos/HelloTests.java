package com.tk.nacos;

import com.tk.nacos.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Description：describe this class function
 * Author；JinHuatao
 * Date: 2019/2/14 12:01
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = HelloController.class)
public class HelloTests {

    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }

}
