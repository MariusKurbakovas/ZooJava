package zoopark.mybatis.model;

public class AnimalZooKeeper {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANIMAL_ZOOKEEPER.ANIMALS_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    private Integer animalsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANIMAL_ZOOKEEPER.ZOOKEEPER_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    private Integer zookeeperId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANIMAL_ZOOKEEPER.ANIMALS_ID
     *
     * @return the value of PUBLIC.ANIMAL_ZOOKEEPER.ANIMALS_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    public Integer getAnimalsId() {
        return animalsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANIMAL_ZOOKEEPER.ANIMALS_ID
     *
     * @param animalsId the value for PUBLIC.ANIMAL_ZOOKEEPER.ANIMALS_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    public void setAnimalsId(Integer animalsId) {
        this.animalsId = animalsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANIMAL_ZOOKEEPER.ZOOKEEPER_ID
     *
     * @return the value of PUBLIC.ANIMAL_ZOOKEEPER.ZOOKEEPER_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    public Integer getZookeeperId() {
        return zookeeperId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANIMAL_ZOOKEEPER.ZOOKEEPER_ID
     *
     * @param zookeeperId the value for PUBLIC.ANIMAL_ZOOKEEPER.ZOOKEEPER_ID
     *
     * @mbg.generated Tue Mar 26 14:20:33 EET 2019
     */
    public void setZookeeperId(Integer zookeeperId) {
        this.zookeeperId = zookeeperId;
    }
}