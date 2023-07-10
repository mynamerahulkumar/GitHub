package com.eats.restaurant.exception;

import lombok.Data;

import java.sql.SQLException;

/**
 * RestaurantException Exception class
 */
@Data
public class RestaurantException extends RuntimeException{
    private String errorCOde;
    private String errorMessage;
    private String level;
    private int status;

    public RestaurantException(){
        super();
    }
    public RestaurantException(SQLException e){
        super(e);
    }

    public static BuildMaker getBuildMaker(){
        return new BuildMaker();
    }
    public static class BuildMaker{
        private String errorCOde;
        private String errorMessage;
        private String level;
        private int status;
        public BuildMaker errorCode(String code){
            this.errorCOde=code;
            return this;
        }
        public BuildMaker errorMessage(String errorMessage){
            this.errorMessage=errorMessage;
            return this;
        }
        public BuildMaker level(String level){
            this.level=level;
            return this;
        }
        public BuildMaker status(int  status){
            this.status=status;
            return this;
        }
        public RestaurantException build(){
            RestaurantException restaurantException=new RestaurantException();
            restaurantException.errorCOde=this.errorCOde;
            restaurantException.errorMessage=this.errorMessage;
            restaurantException.level=this.level;
            restaurantException.status=this.status;
            return restaurantException;
        }
    }
}
