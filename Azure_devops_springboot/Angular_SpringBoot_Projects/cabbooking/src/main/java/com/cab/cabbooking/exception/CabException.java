package com.cab.cabbooking.exception;

import lombok.Data;

import java.util.Locale;
@Data
public class CabException extends RuntimeException{
    private int  status;
    private String errorMessage;

    private String errorCode;

    private String traceId;

    /**
     * default exception
     */
    public CabException(){
        super();
    }

    public static Locale.Builder getBuilder(){
        return new Locale.Builder();
    }
    public static class  Builder{
        private int  status;
        private String errorMessage;

        private String errorCode;

        private String traceId;

        /**
         * method to set status
         * @param status
         * @return
         */
        public Builder status(int status){
            this.status=status;
            return this;
        }
        /**
         * method to set errorMessage
         * @param errorMessage
         * @return
         */
        public Builder errorMessage(String  errorMessage){
            this.errorMessage=errorMessage;
            return this;
        }
        /**
         * method to set errorCode
         * @param errorCode
         * @return
         */
        public Builder errorCode(String  errorCode){
            this.errorCode=errorCode;
            return this;
        }
        /**
         * method to set traceId
         * @param traceId
         * @return
         */
        public Builder traceId(String traceId){
            this.traceId=traceId;
            return this;
        }
        public CabException build(){
            CabException cabException=new CabException();
            cabException.status=this.status;
            cabException.errorMessage=this.errorMessage;
            cabException.errorCode=this.errorCode;
            cabException.traceId=this.traceId;
            return cabException;
        }

    }

}
