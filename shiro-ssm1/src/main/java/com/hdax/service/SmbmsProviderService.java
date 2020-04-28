package com.hdax.service;

import com.hdax.entity.SmbmsProvider;

import java.util.List;

public interface SmbmsProviderService {

    List<SmbmsProvider> findAll() throws Exception;
}
