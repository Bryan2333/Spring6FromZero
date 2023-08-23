package com.bryan017.spring6.biz;

import org.springframework.stereotype.Service;

@Service("vipService")
public class VipService {
    public void saveVip() {
        System.out.println("新增VIP信息");
    }

    public void deleteVip() {
        System.out.println("删除VIP信息");
    }

    public void modifyVip() {
        System.out.println("更新VIP信息");
    }

    public void getVip() {
        System.out.println("获取VIP信息");
    }
}
