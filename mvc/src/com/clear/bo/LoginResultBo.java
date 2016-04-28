package com.clear.bo;

import java.io.Serializable;

public class LoginResultBo implements Serializable{
    
        
        public static final String LOGIN_FAIL="0";
         
        public static final String LOGIN_SUCCESS="1";
        /**
         * 
         */
        private static final long serialVersionUID = -3417857545357517574L;
        
        
        private String status;
        private String msg;
        private String scussessUrl;
        @Deprecated
        private String failUrl;

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }

        public String getMsg() {
        return msg;
        }

        public void setMsg(String msg) {
        this.msg = msg;
        }

        public String getScussessUrl() {
            return scussessUrl;
        }

        public void setScussessUrl(String scussessUrl) {
            this.scussessUrl = scussessUrl;
        }

        public String getFailUrl() {
            return failUrl;
        }

        public void setFailUrl(String failUrl) {
            this.failUrl = failUrl;
        }

}
