package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkAdmin;
import com.xf.project.db.domain.ZkAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZkAdminMapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    long countByExample(ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int deleteByExample(ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int insert(ZkAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int insertSelective(ZkAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    ZkAdmin selectOneByExample(ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    ZkAdmin selectOneByExampleSelective(@Param("example") ZkAdminExample example, @Param("selective") ZkAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    List<ZkAdmin> selectByExampleSelective(@Param("example") ZkAdminExample example, @Param("selective") ZkAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    List<ZkAdmin> selectByExample(ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    ZkAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ZkAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    ZkAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    ZkAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ZkAdmin record, @Param("example") ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ZkAdmin record, @Param("example") ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ZkAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ZkAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ZkAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
