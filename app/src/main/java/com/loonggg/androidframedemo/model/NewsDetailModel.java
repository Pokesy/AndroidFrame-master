package com.loonggg.androidframedemo.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 * 修云飞  详情页的实体类
 */

public class NewsDetailModel implements Serializable{

    private List<Data6Bean> Data6;
    private List<Data7Bean> Data7;
    private List<Data8Bean> Data8;
    private List<Data9Bean> Data9;
    private List<Data2Bean> Data2;
    private List<Data3Bean> Data3;
    private List<Data4Bean> Data4;
    private List<Data5Bean> Data5;
    private List<Data1Bean> Data1;
    private List<Data11Bean> Data11;
    private List<Data12Bean> Data12;
    private List<Data10Bean> Data10;

    public List<Data6Bean> getData6() {
        return Data6;
    }

    public void setData6(List<Data6Bean> Data6) {
        this.Data6 = Data6;
    }

    public List<Data7Bean> getData7() {
        return Data7;
    }

    public void setData7(List<Data7Bean> Data7) {
        this.Data7 = Data7;
    }

    public List<Data8Bean> getData8() {
        return Data8;
    }

    public void setData8(List<Data8Bean> Data8) {
        this.Data8 = Data8;
    }

    public List<Data9Bean> getData9() {
        return Data9;
    }

    public void setData9(List<Data9Bean> Data9) {
        this.Data9 = Data9;
    }

    public List<Data2Bean> getData2() {
        return Data2;
    }

    public void setData2(List<Data2Bean> Data2) {
        this.Data2 = Data2;
    }

    public List<Data3Bean> getData3() {
        return Data3;
    }

    public void setData3(List<Data3Bean> Data3) {
        this.Data3 = Data3;
    }

    public List<Data4Bean> getData4() {
        return Data4;
    }

    public void setData4(List<Data4Bean> Data4) {
        this.Data4 = Data4;
    }

    public List<Data5Bean> getData5() {
        return Data5;
    }

    public void setData5(List<Data5Bean> Data5) {
        this.Data5 = Data5;
    }

    public List<Data1Bean> getData1() {
        return Data1;
    }

    public void setData1(List<Data1Bean> Data1) {
        this.Data1 = Data1;
    }

    public List<Data11Bean> getData11() {
        return Data11;
    }

    public void setData11(List<Data11Bean> Data11) {
        this.Data11 = Data11;
    }

    public List<Data12Bean> getData12() {
        return Data12;
    }

    public void setData12(List<Data12Bean> Data12) {
        this.Data12 = Data12;
    }

    public List<Data10Bean> getData10() {
        return Data10;
    }

    public void setData10(List<Data10Bean> Data10) {
        this.Data10 = Data10;
    }

    public static class Data6Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data7Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data8Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data9Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data2Bean {
        /**
         * NEWS_TITLE : 中联重科PL50水稻机海南开镰收早稻
         * BROWSE_QTY : 230
         * NEWS_ID : 418
         * NEWS_TYPE_NAME : 视频
         * PATH_NAME : /storage/file/tomcat/AttachmentFile/1/201705/20170329082052963_10150552434cut.jpg
         * NUM : 1
         * RELEASE_TIME : 2017.05.10
         */

        private String NEWS_TITLE;
        private int BROWSE_QTY;
        private int NEWS_ID;
        private String NEWS_TYPE_NAME;
        private String PATH_NAME;
        private int NUM;
        private String RELEASE_TIME;

        public String getNEWS_TITLE() {
            return NEWS_TITLE;
        }

        public void setNEWS_TITLE(String NEWS_TITLE) {
            this.NEWS_TITLE = NEWS_TITLE;
        }

        public int getBROWSE_QTY() {
            return BROWSE_QTY;
        }

        public void setBROWSE_QTY(int BROWSE_QTY) {
            this.BROWSE_QTY = BROWSE_QTY;
        }

        public int getNEWS_ID() {
            return NEWS_ID;
        }

        public void setNEWS_ID(int NEWS_ID) {
            this.NEWS_ID = NEWS_ID;
        }

        public String getNEWS_TYPE_NAME() {
            return NEWS_TYPE_NAME;
        }

        public void setNEWS_TYPE_NAME(String NEWS_TYPE_NAME) {
            this.NEWS_TYPE_NAME = NEWS_TYPE_NAME;
        }

        public String getPATH_NAME() {
            return PATH_NAME;
        }

        public void setPATH_NAME(String PATH_NAME) {
            this.PATH_NAME = PATH_NAME;
        }

        public int getNUM() {
            return NUM;
        }

        public void setNUM(int NUM) {
            this.NUM = NUM;
        }

        public String getRELEASE_TIME() {
            return RELEASE_TIME;
        }

        public void setRELEASE_TIME(String RELEASE_TIME) {
            this.RELEASE_TIME = RELEASE_TIME;
        }
    }

    public static class Data3Bean {
        /**
         * USER_CODE : 18396603725
         * NEWS_ID : 418
         * NEWS_REPLY_CONTENT : 我又来评论了。
         * PATH_NAME : D:\JavaProject\OA\USEFILES_OA\Attachment\2\201705\3bcdc8fc-e8d9-4d91-a938-60712b183570.jpg
         * BS_USER_ID : 593
         * NEWS_REPLY_TIME_STR : 2017-05-13
         * SHOW_ORDER : 0
         * USER_ID : 593
         * NEWS_REPLY_ID : 383
         * COUNT_NUM : 0
         * USER_NAME : 吕丽萍
         * NEWS_REPLY_TIME : 2017.05.13 09:05:40
         */

        private String USER_CODE;
        private int NEWS_ID;
        private String NEWS_REPLY_CONTENT;
        private String PATH_NAME;
        private int BS_USER_ID;
        private String NEWS_REPLY_TIME_STR;
        private int SHOW_ORDER;
        private int USER_ID;
        private int NEWS_REPLY_ID;
        private int COUNT_NUM;
        private String USER_NAME;
        private String NEWS_REPLY_TIME;

        public String getUSER_CODE() {
            return USER_CODE;
        }

        public void setUSER_CODE(String USER_CODE) {
            this.USER_CODE = USER_CODE;
        }

        public int getNEWS_ID() {
            return NEWS_ID;
        }

        public void setNEWS_ID(int NEWS_ID) {
            this.NEWS_ID = NEWS_ID;
        }

        public String getNEWS_REPLY_CONTENT() {
            return NEWS_REPLY_CONTENT;
        }

        public void setNEWS_REPLY_CONTENT(String NEWS_REPLY_CONTENT) {
            this.NEWS_REPLY_CONTENT = NEWS_REPLY_CONTENT;
        }

        public String getPATH_NAME() {
            return PATH_NAME;
        }

        public void setPATH_NAME(String PATH_NAME) {
            this.PATH_NAME = PATH_NAME;
        }

        public int getBS_USER_ID() {
            return BS_USER_ID;
        }

        public void setBS_USER_ID(int BS_USER_ID) {
            this.BS_USER_ID = BS_USER_ID;
        }

        public String getNEWS_REPLY_TIME_STR() {
            return NEWS_REPLY_TIME_STR;
        }

        public void setNEWS_REPLY_TIME_STR(String NEWS_REPLY_TIME_STR) {
            this.NEWS_REPLY_TIME_STR = NEWS_REPLY_TIME_STR;
        }

        public int getSHOW_ORDER() {
            return SHOW_ORDER;
        }

        public void setSHOW_ORDER(int SHOW_ORDER) {
            this.SHOW_ORDER = SHOW_ORDER;
        }

        public int getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(int USER_ID) {
            this.USER_ID = USER_ID;
        }

        public int getNEWS_REPLY_ID() {
            return NEWS_REPLY_ID;
        }

        public void setNEWS_REPLY_ID(int NEWS_REPLY_ID) {
            this.NEWS_REPLY_ID = NEWS_REPLY_ID;
        }

        public int getCOUNT_NUM() {
            return COUNT_NUM;
        }

        public void setCOUNT_NUM(int COUNT_NUM) {
            this.COUNT_NUM = COUNT_NUM;
        }

        public String getUSER_NAME() {
            return USER_NAME;
        }

        public void setUSER_NAME(String USER_NAME) {
            this.USER_NAME = USER_NAME;
        }

        public String getNEWS_REPLY_TIME() {
            return NEWS_REPLY_TIME;
        }

        public void setNEWS_REPLY_TIME(String NEWS_REPLY_TIME) {
            this.NEWS_REPLY_TIME = NEWS_REPLY_TIME;
        }
    }

    public static class Data4Bean {
        /**
         * PRAISE_CNT : 0
         */

        private int PRAISE_CNT;

        public int getPRAISE_CNT() {
            return PRAISE_CNT;
        }

        public void setPRAISE_CNT(int PRAISE_CNT) {
            this.PRAISE_CNT = PRAISE_CNT;
        }
    }

    public static class Data5Bean {
        /**
         * CELECT_CNT : 0
         */

        private int CELECT_CNT;

        public int getCELECT_CNT() {
            return CELECT_CNT;
        }

        public void setCELECT_CNT(int CELECT_CNT) {
            this.CELECT_CNT = CELECT_CNT;
        }
    }

    public static class Data1Bean {
        /**
         * NEWS_TITLE : 中联重科PL50水稻机海南开镰收早稻
         * HTML_ATTACHMENT_ID : 3553
         * BROWSE_QTY : 230
         * NEWS_ID : 418
         * BS_USER_ID : 633
         * NUM_QTY : 11
         * RELEASE_TIME : 2017.05.10
         * BS_COMPANY_ID : 1
         * ANNOUNCER : 原创
         * BUSINESS_NO : SC00040
         * PRAISE_QTY : 4
         * VIDEO_PATH_NAME : /storage/file/tomcat/AttachmentFile/-1/201705/花阳神社_13134439354.mp4
         */

        private String NEWS_TITLE;
        private int HTML_ATTACHMENT_ID;
        private int BROWSE_QTY;
        private int NEWS_ID;
        private int BS_USER_ID;
        private int NUM_QTY;
        private String RELEASE_TIME;
        private int BS_COMPANY_ID;
        private String ANNOUNCER;
        private String BUSINESS_NO;
        private int PRAISE_QTY;
        private String VIDEO_PATH_NAME;
        private String HTML_URL;

        public String getHTML_URL() {
            return HTML_URL;
        }

        public void setHTML_URL(String HTML_URL) {
            this.HTML_URL = HTML_URL;
        }

        public String getNEWS_TITLE() {
            return NEWS_TITLE;
        }

        public void setNEWS_TITLE(String NEWS_TITLE) {
            this.NEWS_TITLE = NEWS_TITLE;
        }

        public int getHTML_ATTACHMENT_ID() {
            return HTML_ATTACHMENT_ID;
        }

        public void setHTML_ATTACHMENT_ID(int HTML_ATTACHMENT_ID) {
            this.HTML_ATTACHMENT_ID = HTML_ATTACHMENT_ID;
        }

        public int getBROWSE_QTY() {
            return BROWSE_QTY;
        }

        public void setBROWSE_QTY(int BROWSE_QTY) {
            this.BROWSE_QTY = BROWSE_QTY;
        }

        public int getNEWS_ID() {
            return NEWS_ID;
        }

        public void setNEWS_ID(int NEWS_ID) {
            this.NEWS_ID = NEWS_ID;
        }

        public int getBS_USER_ID() {
            return BS_USER_ID;
        }

        public void setBS_USER_ID(int BS_USER_ID) {
            this.BS_USER_ID = BS_USER_ID;
        }

        public int getNUM_QTY() {
            return NUM_QTY;
        }

        public void setNUM_QTY(int NUM_QTY) {
            this.NUM_QTY = NUM_QTY;
        }

        public String getRELEASE_TIME() {
            return RELEASE_TIME;
        }

        public void setRELEASE_TIME(String RELEASE_TIME) {
            this.RELEASE_TIME = RELEASE_TIME;
        }

        public int getBS_COMPANY_ID() {
            return BS_COMPANY_ID;
        }

        public void setBS_COMPANY_ID(int BS_COMPANY_ID) {
            this.BS_COMPANY_ID = BS_COMPANY_ID;
        }

        public String getANNOUNCER() {
            return ANNOUNCER;
        }

        public void setANNOUNCER(String ANNOUNCER) {
            this.ANNOUNCER = ANNOUNCER;
        }

        public String getBUSINESS_NO() {
            return BUSINESS_NO;
        }

        public void setBUSINESS_NO(String BUSINESS_NO) {
            this.BUSINESS_NO = BUSINESS_NO;
        }

        public int getPRAISE_QTY() {
            return PRAISE_QTY;
        }

        public void setPRAISE_QTY(int PRAISE_QTY) {
            this.PRAISE_QTY = PRAISE_QTY;
        }

        public String getVIDEO_PATH_NAME() {
            return VIDEO_PATH_NAME;
        }

        public void setVIDEO_PATH_NAME(String VIDEO_PATH_NAME) {
            this.VIDEO_PATH_NAME = VIDEO_PATH_NAME;
        }
    }

    public static class Data11Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data12Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }

    public static class Data10Bean {
        /**
         * 1 : 1
         */

        @SerializedName("1")
        private int _$1;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }
    }
}
