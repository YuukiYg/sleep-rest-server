package com.yuukiyg.sleeprestserver.app;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTPリクエストで指定された時間、Sleepするサーバ.
 */
@RestController
public class SleerRestServerController {

    @RequestMapping(value = "/wait", method = RequestMethod.GET)
    public String wait(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "time", required = false) String waitTime) {

        final String name4logging = "".equals(name)? UUID.randomUUID().toString() : name;
        final int waitTimeMills = "".equals(waitTime)? 10000 : Integer.parseInt(waitTime);

        String retMsg = "";
        try {
            System.out.println("[" + name4logging + "] start waiting... (waitTime: "
                    + waitTime + ")");

            Thread.sleep(waitTimeMills);

            System.out.println("[" + name4logging + "] end waiting. ");

            retMsg = "[" + name4logging + "] waited: " + waitTimeMills;
        } catch (InterruptedException e) {
            retMsg = "error";
            // e.printStackTrace();
        }

        return retMsg;
    }

}
