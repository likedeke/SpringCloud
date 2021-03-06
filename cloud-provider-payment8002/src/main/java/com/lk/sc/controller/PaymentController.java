package com.lk.sc.controller;

import com.lk.sc.entity.Payment;
import com.lk.sc.entity.Result;
import com.lk.sc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author likeLove
 * @time 2020-08-30  10:57
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }



    /**
     * 根据id获取payment
     *
     * @param id 需要查询的payment对象的id
     * @return Result.data
     */
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable String id) {
        Payment paymentServiceById = paymentService.getById(id);
        log.info("payment.get.id:" + id);
        if (paymentServiceById != null) {
            return Result.ok().data("payment", paymentServiceById).message("查询成功+serverPort:"+serverPort);
        }
        return Result.error().message("查询失败，查询id:" + id+"+serverPort:"+serverPort);
    }

    /**
     * 添加payment到数据库
     *
     * @param payment 需要添加的payment
     * @return Result
     */
    @PostMapping("/save")
    public Result save(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        System.out.println(payment);
        if (save) {
            return Result.ok().success(save).message("保存成功+serverPort:"+serverPort).data("payment", payment);
        }
        return Result.error().message("保存失败，数据库中可能已经存在这个对象,保存对象:" + payment+"+serverPort:"+serverPort);
    }
}
