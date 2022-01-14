package com.wei.transfer.db.service;

import com.wei.transfer.db.entity.ConfigEntity;
import com.wei.transfer.db.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    public ConfigEntity findConfigByName(String name){return  configRepository.findConfigByName(name);}
}
