package com.loonggg.androidframedemo.model;

import com.google.gson.annotations.SerializedName;
import com.loonggg.androidframedemo.app.CustomApp;

import java.util.List;

/**
 * Created by Pokesy_dajiao on 2017/5/22.
 */

public class HomeNewsModel {

    /**
     * data : {"Data6":[{"1":1}],"Data7":[{"1":1}],"Data8":[{"1":1}],"Data9":[{"1":1}],"Data2":[{"1":1}],"Data3":[{"1":1}],"Data4":[{"1":1}],"Data5":[{"1":1}],"Data1":[{"NEWS_TITLE":"中联重科PL50水稻机海南开镰收早稻","BROWSE_QTY":222,"NEWS_ID":418,"CT_DATE_STR":"2017.05.10","PATH_NAME":"/storage/file/tomcat/AttachmentFile/1/201705/20170329082052963_10150552434cut.jpg","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"中联重科","VIDEO_PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/花阳神社_13134439354.mp4","ROWNUM_":1},{"NEWS_TITLE":"小麦收割","BROWSE_QTY":259,"NEWS_ID":354,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/QQ图片20170505201209_05201652963cut.png","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":2},{"NEWS_TITLE":"谷王匠心的名义","BROWSE_QTY":89,"NEWS_ID":351,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/1/201705/201505251601486383.jpg!w640qm_10140450301cut.jpg","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":3},{"NEWS_TITLE":"中联重科拖拉机春耕新疆","BROWSE_QTY":55,"NEWS_ID":348,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/QQ图片20170505201300_05201510423cut.png","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":4},{"NEWS_TITLE":"联合整地机","BROWSE_QTY":74,"NEWS_ID":341,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/d317dc4_03102533909cut.jpg","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":5},{"NEWS_TITLE":"谷王小麦机最美麦收","BROWSE_QTY":140,"NEWS_ID":338,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/QQ图片20170505201230_05201329062cut.png","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":6},{"NEWS_TITLE":"玉米收获机","BROWSE_QTY":50,"NEWS_ID":337,"CT_DATE_STR":"2017.05.03","PATH_NAME":"/storage/file/tomcat/AttachmentFile/-1/201705/201411071113010992.jpg!w400h300_03094226003cut.jpg","NEWS_TYPE_NAME":"视频","NEWS_TYPE_ID":30,"USER_NAME":"111111","ROWNUM_":7}],"Data11":[{"1":1}],"Data12":[{"1":1}],"Data10":[{"1":1}]}
     * errorMessage : null
     * resultType : 1
     */

    private DataBean data;
    private Object errorMessage;
    private int resultType;



    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public static class DataBean {
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

        public static class Data3Bean {
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

        public static class Data4Bean {
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

        public static class Data5Bean {
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

        public static class Data1Bean {
            /**
             * NEWS_TITLE : 中联重科PL50水稻机海南开镰收早稻
             * BROWSE_QTY : 222
             * NEWS_ID : 418
             * CT_DATE_STR : 2017.05.10
             * PATH_NAME : /storage/file/tomcat/AttachmentFile/1/201705/20170329082052963_10150552434cut.jpg
             * NEWS_TYPE_NAME : 视频
             * NEWS_TYPE_ID : 30
             * USER_NAME : 中联重科
             * VIDEO_PATH_NAME : /storage/file/tomcat/AttachmentFile/-1/201705/花阳神社_13134439354.mp4
             * ROWNUM_ : 1
             */

            private String NEWS_TITLE;
            private int BROWSE_QTY;
            private int NEWS_ID;
            private String CT_DATE_STR;
            private String PATH_NAME;
            private String NEWS_TYPE_NAME;
            private int NEWS_TYPE_ID;
            private String USER_NAME;
            private String VIDEO_PATH_NAME;
            private int ROWNUM_;

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

            public String getCT_DATE_STR() {
                return CT_DATE_STR;
            }

            public void setCT_DATE_STR(String CT_DATE_STR) {
                this.CT_DATE_STR = CT_DATE_STR;
            }

            public String getPATH_NAME() {
                return PATH_NAME;
            }

            public void setPATH_NAME(String PATH_NAME) {
                this.PATH_NAME = PATH_NAME;
            }

            public String getNEWS_TYPE_NAME() {
                return NEWS_TYPE_NAME;
            }

            public void setNEWS_TYPE_NAME(String NEWS_TYPE_NAME) {
                this.NEWS_TYPE_NAME = NEWS_TYPE_NAME;
            }

            public int getNEWS_TYPE_ID() {
                return NEWS_TYPE_ID;
            }

            public void setNEWS_TYPE_ID(int NEWS_TYPE_ID) {
                this.NEWS_TYPE_ID = NEWS_TYPE_ID;
            }

            public String getUSER_NAME() {
                return USER_NAME;
            }

            public void setUSER_NAME(String USER_NAME) {
                this.USER_NAME = USER_NAME;
            }

            public String getVIDEO_PATH_NAME() {
                return VIDEO_PATH_NAME;
            }

            public void setVIDEO_PATH_NAME(String VIDEO_PATH_NAME) {
                this.VIDEO_PATH_NAME = VIDEO_PATH_NAME;
            }

            public int getROWNUM_() {
                return ROWNUM_;
            }

            public void setROWNUM_(int ROWNUM_) {
                this.ROWNUM_ = ROWNUM_;
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
}
