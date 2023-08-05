package com.seamew.consulprovider.service;

import com.seamew.consulprovider.dao.GoodsDao;
import com.seamew.domain.Goods;
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
