package com.loonggg.androidframedemo.net.rpc.model;

import java.util.List;

/**
 * Created by loonggg on 16/9/16.
 */

public class TestInfoModel {


    /**
     * list : [{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-8255071.jpg/640","id":"wechat_20160915039850","source":"功夫体育","title":"女排冠军们\u201c高\u201d人一等，谁敢娶？","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160915039850","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-8206632.jpg/640","id":"wechat_20160102022165","source":"篮球频道","title":"【球迷关注点】书豪:一度想退役不再打球 曾被科比一句蔑视激怒","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160102022165","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-8064767.jpg/640","id":"wechat_20160908053966","source":"娱乐圈扒姐","title":"某知名女星在节目中威胁选手收贿，私下爱搞潜规则","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160908053966","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986866.jpg/640","id":"wechat_20160906017693","source":"颜小白的篮球梦","title":"科比跟乔丹比到底差在哪里？仅仅是身体素质吗","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906017693","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986843.jpg/640","id":"wechat_20160906017663","source":"嘻嘻哈哈","title":"神动图|这手感绝对不差！","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906017663","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986833.jpg/640","id":"wechat_20160906017658","source":"嘻嘻哈哈","title":"江湖流传的这些奇葩书，简直刷新我的三观~","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906017658","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986819.jpg/640","id":"wechat_20160906017552","source":"笑你妹","title":"【搞笑段子】有心无力啊，办起事来几分钟完事~","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906017552","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986802.jpg/640","id":"wechat_20160906017288","source":"TechWeb","title":"在iPhone7发布之前我们先来看看它的跑分吧","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906017288","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986693.jpg/640","id":"wechat_20160906016354","source":"陇南生活网","title":"甘肃：将发生严重腐败问题的地区部门直接评为\u201c一般\u201d","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906016354","mark":""},{"firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-7986675.jpg/640","id":"wechat_20160906016213","source":"云上的空母","title":"万吨两栖舰上的袖珍火炮，射速为每分钟200发","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20160906016213","mark":""}]
     * totalPage : 50
     * ps : 10
     * pno : 1
     */

    private int totalPage;
    private int ps;
    private int pno;
    /**
     * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-8255071.jpg/640
     * id : wechat_20160915039850
     * source : 功夫体育
     * title : 女排冠军们“高”人一等，谁敢娶？
     * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20160915039850
     * mark :
     */

    private List<ListBean> list;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String firstImg;
        private String id;
        private String source;
        private String title;
        private String url;
        private String mark;

        public String getFirstImg() {
            return firstImg;
        }

        public void setFirstImg(String firstImg) {
            this.firstImg = firstImg;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }
    }
}
