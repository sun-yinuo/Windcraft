package com.sunyinuo.bancrud.service.api.impl;

import com.sunyinuo.bancrud.model.Ban;
import com.sunyinuo.bancrud.service.api.GetBanListService;
import com.sunyinuo.bancrud.service.db.impl.BanServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetBanListService层实现类
 * @author sunyinuo
 */
@Service
public class GetBanListServiceImpl implements GetBanListService {
    private final BanServiceImpl banService;

    public GetBanListServiceImpl(BanServiceImpl banService) {
        this.banService = banService;
    }

    /**
     * 获取所有被ban用户的信息
     * @return 实体类集合
     */
    @Override
    public List<Ban> getBanList() {
        return banService.getBanList();
    }
}
