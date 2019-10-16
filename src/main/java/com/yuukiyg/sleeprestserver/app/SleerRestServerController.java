package com.yuukiyg.sleeprestserver.app;

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
    public String wait(@RequestParam("name") String name, @RequestParam("time") String waitTime) {

        int waitTimeMills = Integer.parseInt(waitTime);

        //String uuid = UUID.randomUUID().toString();

        String retMsg = "";
        try {
            System.out.println("["+ name +"] start waiting... (waitTime: " + waitTime + ")");

            Thread.sleep(waitTimeMills);

            System.out.println("["+ name +"] end waiting. ");

            retMsg = "waited: " + waitTimeMills;
        } catch (InterruptedException e) {
            retMsg = "error";
            // e.printStackTrace();
        }

        return retMsg;
    }

}
