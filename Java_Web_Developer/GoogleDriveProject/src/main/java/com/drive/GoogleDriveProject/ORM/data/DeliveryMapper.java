package com.drive.GoogleDriveProject.ORM.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {

    @Select("SELECT * FROM Delivery WHERE id=#{id}")
    Delivery findDelivery(Integer id);

    @Insert("INSERT INTO Delivery(orderId,time) VALUES(#{orderId},#{timestamp})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insert(Delivery delivery);

    @Delete("DELETE FROM Delivery WHERE id=#{id}")
    void delete(Integer id);
}
