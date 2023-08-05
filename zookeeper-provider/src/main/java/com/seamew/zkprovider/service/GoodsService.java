package com.seamew.zkprovider.service;

import com.seamew.domain.Goods;
import com.seamew.zkprovider.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public Goods getGoodsById(Integer goodsId) {
        return goodsDao.getGoodsById(goodsId);
    }
}
