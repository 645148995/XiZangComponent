package com.ctvit.base.entity;

/**
 * Created by Administrator on 2016/12/24.
 */

public class UserInfoEntity {

    /**
     * succeed : 1
     * message : 获取用户信息成功
     * Info : {"uid":"U1465987626118537","loginname":"13609972053","phone":"13609972053","createtime":"1465987626","nickname":"13609972053","deviceid":"865707029387564","invitcode":"5761322a","invitedcode":"","userlogo":"http://idata.5club.cctv.cn/pic/userhead/1465988595.jpg","status":"1","sex":"1","birthday":"1988-06-16","appsource":"14","registrationid":"werwer234243234"}
     */

    private String succeed;
    private String message;
    private InfoBean Info;

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InfoBean getInfo() {
        return Info;
    }

    public void setInfo(InfoBean Info) {
        this.Info = Info;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "succeed='" + succeed + '\'' +
                ", message='" + message + '\'' +
                ", Info=" + Info +
                '}';
    }

    public static class InfoBean {
        /**
         * uid : U1465987626118537
         * loginname : 13609972053
         * phone : 13609972053
         * createtime : 1465987626
         * nickname : 13609972053
         * deviceid : 865707029387564
         * invitcode : 5761322a
         * invitedcode :
         * userlogo : http://idata.5club.cctv.cn/pic/userhead/1465988595.jpg
         * status : 1
         * sex : 1
         * birthday : 1988-06-16
         * appsource : 14
         * registrationid : werwer234243234
         */

        private String uid;
        private String loginname;
        private String phone;
        private String createtime;
        private String nickname;
        private String deviceid;
        private String invitcode;
        private String invitedcode;
        private String userlogo;
        private String status;
        private String sex;
        private String birthday;
        private String appsource;
        private String registrationid;
        private String usertoken;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getLoginname() {
            return loginname;
        }

        public void setLoginname(String loginname) {
            this.loginname = loginname;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public String getInvitcode() {
            return invitcode;
        }

        public void setInvitcode(String invitcode) {
            this.invitcode = invitcode;
        }

        public String getInvitedcode() {
            return invitedcode;
        }

        public void setInvitedcode(String invitedcode) {
            this.invitedcode = invitedcode;
        }

        public String getUserlogo() {
            return userlogo;
        }

        public void setUserlogo(String userlogo) {
            this.userlogo = userlogo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAppsource() {
            return appsource;
        }

        public void setAppsource(String appsource) {
            this.appsource = appsource;
        }

        public String getRegistrationid() {
            return registrationid;
        }

        public void setRegistrationid(String registrationid) {
            this.registrationid = registrationid;
        }

        public String getUsertoken() {
            return usertoken;
        }

        public void setUsertoken(String usertoken) {
            this.usertoken = usertoken;
        }

        @Override
        public String toString() {
            return "InfoBean{" +
                    "uid='" + uid + '\'' +
                    ", loginname='" + loginname + '\'' +
                    ", phone='" + phone + '\'' +
                    ", createtime='" + createtime + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", deviceid='" + deviceid + '\'' +
                    ", invitcode='" + invitcode + '\'' +
                    ", invitedcode='" + invitedcode + '\'' +
                    ", userlogo='" + userlogo + '\'' +
                    ", status='" + status + '\'' +
                    ", sex='" + sex + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", appsource='" + appsource + '\'' +
                    ", registrationid='" + registrationid + '\'' +
                    ", usertoken='" + usertoken + '\'' +
                    '}';
        }
    }
}
