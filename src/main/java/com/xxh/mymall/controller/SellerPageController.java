package com.xxh.mymall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerPageController {
    @GetMapping("/SellerPage")
    public  String Seller(String userId){
        return "Seller";
    }
}
