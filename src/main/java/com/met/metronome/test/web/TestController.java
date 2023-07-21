package com.met.metronome.test.web;

import com.met.metronome.test.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ResponseBody
    @GetMapping(value = "/test-get")
    public String test() {
        return testService.selectTest();
    }
}
