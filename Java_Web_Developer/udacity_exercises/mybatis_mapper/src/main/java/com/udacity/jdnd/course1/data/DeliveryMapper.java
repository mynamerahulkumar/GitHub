package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {
    @Select("Select * FROM Delivery WHERE id=#{id}")
    Delivery findDeliveryId(Integer id);
    @Insert("INSERT INTO Delivery(orderId,time) VALUES(#{orderId},#{time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insert(Delivery delivery);
    @Delete("DELETE from Delivery where id={#id}")
    void delete(Integer id);

}
