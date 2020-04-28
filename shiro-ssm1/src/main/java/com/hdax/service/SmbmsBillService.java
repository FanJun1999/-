package com.hdax.service;

import com.hdax.entity.SmbmsBill;

import java.util.List;

public interface SmbmsBillService {

    /**
     *
     * @param condition 查询条件
     * @param page 偏移量
     * @param limit 条数限制
     * @return
     * @throws Exception
     */
    List<SmbmsBill> findByCondition(SmbmsBill condition, int page, int limit) throws Exception;

    /**
     * 条件差查询总条数
     * @param condition
     * @return
     * @throws Exception
     */
    int getCountByCondition(SmbmsBill condition) throws Exception;

    /**
     * 根据id删除订单信息
     * @param id
     * @return
     */
    Boolean deleteById(Integer id) throws Exception;

    /**
     * 新增订单
     * @param bill
     * @return
     */
    Boolean saveBill(SmbmsBill bill) throws Exception;

    /**
     * 查询订单
     * @param id
     * @return
     */
    SmbmsBill findById(Integer id) throws Exception;

    /**
     * 修改订单
     * @param bill
     * @throws Exception
     */
    Boolean updateBill(SmbmsBill bill) throws Exception;
}
