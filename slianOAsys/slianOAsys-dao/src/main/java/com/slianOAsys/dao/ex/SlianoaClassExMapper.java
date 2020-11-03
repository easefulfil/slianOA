package com.slianOAsys.dao.ex;

import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.ex.ClassEx;
import com.slianOAsys.model.SlianoaClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlianoaClassExMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class
     *
     * @mbggenerated
     */
    int countByExample(SlianoaClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class
     *
     * @mbggenerated
     */
    List<ClassEx> selectByExample(SlianoaClassExample example);
    
    List<ClassEx> getClassById(int classid);

}