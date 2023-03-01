package com.wei.demo.db.service;

import com.wei.demo.db.entity.ConfigEntity;
import com.wei.demo.db.repository.ConfigRepository;
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
