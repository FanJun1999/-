package com.hdax.service.impl;

import com.hdax.entity.SmbmsProvider;
import com.hdax.mappers.SmbmsProviderMapper;
import com.hdax.service.SmbmsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {

    @Autowired
    private SmbmsProviderMapper smbmsProviderMapper;

    @Override
    public List<SmbmsProvider> findAll() throws Exception {
        List<SmbmsProvider> providers = null;
        try {
            providers = smbmsProviderMapper.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return providers;
    }
}
