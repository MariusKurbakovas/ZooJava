package zoopark.mybatis.dao;

import org.mybatis.cdi.Mapper;
import zoopark.mybatis.model.Animal;

import java.util.List;

@Mapper
public interface AnimalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANIMAL
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANIMAL
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int insert(Animal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANIMAL
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    Animal selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANIMAL
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    List<Animal> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANIMAL
     *
     * @mbg.generated Thu Mar 21 11:37:36 EET 2019
     */
    int updateByPrimaryKey(Animal record);

    List<Animal> selectByBuildingId(Integer id);
}