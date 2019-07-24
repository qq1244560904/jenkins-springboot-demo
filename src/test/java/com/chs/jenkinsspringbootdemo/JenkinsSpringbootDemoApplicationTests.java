package com.chs.jenkinsspringbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ContextConfiguration
@AutoConfigureMockMvc
public class JenkinsSpringbootDemoApplicationTests {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        String jenkinsSpringbootDemo = mockMvc.perform(MockMvcRequestBuilders.get("/jenkinsSpringbootDemo")).andReturn()
                .getResponse().getContentAsString();
        log.info("jenkinsSpringbootDemo:{}",jenkinsSpringbootDemo);
        System.out.println(jenkinsSpringbootDemo);
    }

}
