package com.seamew.ribbonprovider.service;

import com.seamew.domain.Goods;
import com.seamew.ribbonprovider.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService
{
    @Autowired
    private GoodsDao goodsDao;

    public Goods getGoodsById(Integer goodsId)
    {
        return goodsDao.getGoodsById(goodsId);
    }
}
