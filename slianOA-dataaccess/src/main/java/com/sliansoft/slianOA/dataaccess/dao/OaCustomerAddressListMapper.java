package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaCustomerAddressList;
import com.sliansoft.slianOA.dataaccess.model.OaCustomerAddressListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaCustomerAddressListMapper {
    int countByExample(OaCustomerAddressListExample example);

    int deleteByExample(OaCustomerAddressListExample example);

    int deleteByPrimaryKey(Integer addressListId);

    int insert(OaCustomerAddressList record);

    int insertSelective(OaCustomerAddressList record);

    List<OaCustomerAddressList> selectByExample(OaCustomerAddressListExample example);

    OaCustomerAddressList selectByPrimaryKey(Integer addressListId);

    int updateByExampleSelective(@Param("record") OaCustomerAddressList record, @Param("example") OaCustomerAddressListExample example);

    int updateByExample(@Param("record") OaCustomerAddressList record, @Param("example") OaCustomerAddressListExample example);

    int updateByPrimaryKeySelective(OaCustomerAddressList record);

    int updateByPrimaryKey(OaCustomerAddressList record);

    List<OaCustomerAddressList> selectPage(OaCustomerAddressListExample example);
}