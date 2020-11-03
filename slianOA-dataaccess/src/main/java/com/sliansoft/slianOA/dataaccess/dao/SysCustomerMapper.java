package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SysCustomer;
import com.sliansoft.slianOA.dataaccess.model.SysCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCustomerMapper {
    int countByExample(SysCustomerExample example);

    int deleteByExample(SysCustomerExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(SysCustomer record);

    int insertSelective(SysCustomer record);

    List<SysCustomer> selectByExample(SysCustomerExample example);

    SysCustomer selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") SysCustomer record, @Param("example") SysCustomerExample example);

    int updateByExample(@Param("record") SysCustomer record, @Param("example") SysCustomerExample example);

    int updateByPrimaryKeySelective(SysCustomer record);

    int updateByPrimaryKey(SysCustomer record);

    List<SysCustomer> selectPage(SysCustomerExample example);
    
     int insertAndGetId(SysCustomer record);
     List<SysCustomer> selectAll(
       		@Param("customerCompany") String customerCompany,
       		@Param("cname") String cname,
               @Param("mobile") String mobile,
               @Param("customerType") String customerType,
               @Param("attitude") String attitude,
               @Param("department") String department,
               @Param("customerCounterman") String customerCounterman
               );
     
}