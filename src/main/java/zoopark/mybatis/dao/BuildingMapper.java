package zoopark.mybatis.dao;

import org.mybatis.cdi.Mapper;
import zoopark.mybatis.model.Building;

import java.util.List;

@Mapper
public interface BuildingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUILDING
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUILDING
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int insert(Building record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUILDING
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    Building selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUILDING
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    List<Building> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BUILDING
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int updateByPrimaryKey(Building record);
}