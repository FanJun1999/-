package com.hdax.service.impl;

import com.hdax.entity.SmbmsBill;
import com.hdax.mappers.SmbmsBillMapper;
import com.hdax.service.SmbmsBillService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {

    @Autowired
    private SmbmsBillMapper smbmsBillMapper;


    @Override
    public Boolean saveBill(SmbmsBill bill) {
        try {
            smbmsBillMapper.saveEntity(bill);
            return true;
        }catch (Exception e){
            log.error("订单新增异常 : "+e.getMessage());
            return false;
        }
    }

    @Override
    public SmbmsBill findById(Integer id) throws Exception {
        return smbmsBillMapper.findById(id);
    }

    @Override
    public Boolean updateBill(SmbmsBill bill) throws Exception {
        try {
            smbmsBillMapper.updateEntity(bill);
            return true;
        }catch (Exception e){
            log.error("订单删除异常 : "+e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            smbmsBillMapper.deleteById(id);
            return true;
        }catch (Exception e){
            log.error("订单删除异常 : "+e.getMessage());
            return false;
        }
    }

    @Override
    public List<SmbmsBill> findByCondition(SmbmsBill condition, int page, int limit) throws Exception {

        List<SmbmsBill> bills = null;

        try {
            bills = smbmsBillMapper.findByCondition(condition, (page-1) * limit, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

    @Override
    public int getCountByCondition(SmbmsBill condition) throws Exception {
        int count = 0;
        try{
            count = smbmsBillMapper.getCountByCondition(condition);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
