package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAttachment;
import com.sliansoft.slianOA.dataaccess.model.OaAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAttachmentMapper {
    int countByExample(OaAttachmentExample example);

    int deleteByExample(OaAttachmentExample example);

    int deleteByPrimaryKey(Integer attachmentId);

    int insert(OaAttachment record);

    int insertSelective(OaAttachment record);

    List<OaAttachment> selectByExample(OaAttachmentExample example);

    OaAttachment selectByPrimaryKey(Integer attachmentId);

    int updateByExampleSelective(@Param("record") OaAttachment record, @Param("example") OaAttachmentExample example);

    int updateByExample(@Param("record") OaAttachment record, @Param("example") OaAttachmentExample example);

    int updateByPrimaryKeySelective(OaAttachment record);

    int updateByPrimaryKey(OaAttachment record);

    List<OaAttachment> selectPage(OaAttachmentExample example);
}