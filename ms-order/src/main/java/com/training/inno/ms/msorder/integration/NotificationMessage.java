package com.training.inno.ms.msorder.integration;

public class NotificationMessage {
    private String msg;
    private String dest;

    public NotificationMessage() {
    }

    public NotificationMessage(String msg,
                               String dest) {
        this.msg = msg;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
               "msg='" + msg + '\'' +
               ", dest='" + dest + '\'' +
               '}';
    }

    public static NotificationMessageBuilder builder() {
        return new NotificationMessageBuilder();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msgParam) {
        msg = msgParam;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String destParam) {
        dest = destParam;
    }

    public static class NotificationMessageBuilder {
        private String msg;
        private String dest;

        NotificationMessageBuilder() {
        }

        public NotificationMessageBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public NotificationMessageBuilder dest(String dest) {
            this.dest = dest;
            return this;
        }

        public NotificationMessage build() {
            return new NotificationMessage(msg,
                                           dest);
        }

        public String toString() {
            return "NotificationMessage.NotificationMessageBuilder(msg=" + this.msg + ", dest=" + this.dest + ")";
        }
    }
}
