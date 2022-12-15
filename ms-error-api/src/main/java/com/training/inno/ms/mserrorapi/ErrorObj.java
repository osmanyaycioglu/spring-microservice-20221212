package com.training.inno.ms.mserrorapi;

import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String microservice; // domain.subdomain.bounded-context.microservice
    private String desc;
    private int    code;

    public ErrorObj() {
    }

    public ErrorObj(List<ErrorObj> subErrors,
                    String microservice,
                    String desc,
                    int code) {
        this.subErrors = subErrors;
        this.microservice = microservice;
        this.desc = desc;
        this.code = code;
    }

    public static ErrorObjBuilder builder(String microserviceParam) {
        return new ErrorObjBuilder(microserviceParam);
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getCode() {
        return this.code;
    }

    public void setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ErrorObjBuilder {
        private List<ErrorObj> subErrors;
        private final String         microservice;
        private String         desc;
        private int            code;


        ErrorObjBuilder(String microserviceParam) {

            microservice = microserviceParam;
        }

        public ErrorObjBuilder withSubErrors(List<ErrorObj> subErrors) {
            this.subErrors = subErrors;
            return this;
        }

        public ErrorObjBuilder withDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public ErrorObjBuilder withCode(int code) {
            this.code = code;
            return this;
        }

        public ErrorObj build() {
            return new ErrorObj(subErrors,
                                microservice,
                                desc,
                                code);
        }

        public String toString() {
            return "ErrorObj.ErrorObjBuilder(subErrors="
                   + this.subErrors
                   + ", microservice="
                   + this.microservice
                   + ", desc="
                   + this.desc
                   + ", code="
                   + this.code
                   + ")";
        }
    }
}
