package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.dataaccess.model.OaDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaDocumentMapper {
    int countByExample(OaDocumentExample example);

    int deleteByExample(OaDocumentExample example);

    int deleteByPrimaryKey(Integer documentId);

    int insert(OaDocument record);

    int insertSelective(OaDocument record);

    List<OaDocument> selectByExample(OaDocumentExample example);

    OaDocument selectByPrimaryKey(Integer documentId);

    int updateByExampleSelective(@Param("record") OaDocument record, @Param("example") OaDocumentExample example);

    int updateByExample(@Param("record") OaDocument record, @Param("example") OaDocumentExample example);

    int updateByPrimaryKeySelective(OaDocument record);

    int updateByPrimaryKey(OaDocument record);

    List<OaDocument> selectPage(OaDocumentExample example);
}