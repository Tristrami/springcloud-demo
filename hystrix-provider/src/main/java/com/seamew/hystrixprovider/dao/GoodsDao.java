package com.seamew.hystrixprovider.dao;

import com.seamew.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao
{
    public Goods getGoodsById(Integer goodsId)
    {
        return new Goods(goodsId, "剃须刀", 20D, 100);
    }
}
