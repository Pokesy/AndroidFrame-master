package com.loonggg.androidframedemo.net.rpc.model;



public class UserInfo {
    public static final String USER_TYPE_VISITOR = "2";
    public static final String USER_TYPE_THIRD = "1";
    public static final String USER_TYPE_PHONE = "0";

    public static final String CERTIFY_STATUS_CERTIFY_FAILED = "0";
    public static final String CERTIFY_STATUS_CERTIFY_PASS = "1";
    public static final String CERTIFY_STATUS_CERTIFYING = "2";



    private String birthday;
    private String devId;
    private String gender;
    private String introduce;
    private String inviteCode;
    private Object loginTime;
    private String mobileNo;
    private String myCity;
    private String password;
    private Object registerDate;
    private String thirdAccount;
    private int type;



    private int memberId;
    private String realName;
    private String portrait;
    private String nickName;
    private String signature;
    private String registerTime;
    private String token;
    private String ageStage;
    private int score;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAgeStage() {
        return ageStage;
    }

    public void setAgeStage(String ageStage) {
        this.ageStage = ageStage;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }



    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }


    public Object getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Object loginTime) {
        this.loginTime = loginTime;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    public String getMyCity() {
        return myCity;
    }

    public void setMyCity(String myCity) {
        this.myCity = myCity;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Object getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Object registerDate) {
        this.registerDate = registerDate;
    }


    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thirdAccount) {
        this.thirdAccount = thirdAccount;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }




}
