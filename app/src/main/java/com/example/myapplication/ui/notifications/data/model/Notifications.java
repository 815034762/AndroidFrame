package com.example.myapplication.ui.notifications.data.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 实体bean
 */
public class Notifications implements Serializable {
    /**
     * status : 1
     * error :
     * data : {"timestamp":1604388663,"info":[{"contain":"","nickname":"圣","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2448476,"singername":"","verified":0,"publishtime":"2020-09-28 11:30:14","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20200928/20200928112850220178.jpg","suid":509005055,"iscustom":0,"isperiodical":0,"specialid":3117485,"specialname":"你好<\/em>DJ，来个串烧套餐好伐？","gid":"collection_3_509005055_36_0"},{"contain":"","nickname":"兔八哥","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":43019,"singername":"","verified":0,"publishtime":"2015-08-31 11:41:26","songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150831/20150831114535855399.jpg","suid":509001535,"iscustom":0,"isperiodical":0,"specialid":26134,"specialname":"再见八月，九月你好<\/em>","gid":"collection_3_509001535_2_0"},{"contain":"","nickname":"来自仙女的念想","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":286,"singername":"","verified":0,"publishtime":"2020-03-17 10:25:20","songcount":24,"imgurl":"http://c1.kgimg.com/custom/150/20200317/20200317102338411257.jpg","suid":1210258192,"iscustom":0,"isperiodical":0,"specialid":2218033,"specialname":"你好<\/em>，能不能借一生说话。","gid":"collection_3_1210258192_23_0"},{"contain":"","nickname":"予茕兔桃想","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":0,"singername":"","verified":0,"publishtime":"2016-03-31 18:57:36","songcount":16,"imgurl":"http://c1.kgimg.com/stdmusic/150/20200615/20200615110654613657.png","suid":509004838,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"你好<\/em> | 李志 | 这个世界会好吗？","gid":"collection_3_509004838_12_0"},{"contain":"","nickname":"巫师","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":1603,"singername":"","verified":0,"publishtime":"2016-03-31 22:23:47","songcount":28,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150719/20150719043652607845.jpg","suid":509004289,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"土嗨你好<\/em>，土嗨再见！","gid":"collection_3_509004289_14_0"},{"contain":"","nickname":"鬼鬼不哭","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":46365,"singername":"","verified":0,"publishtime":"2016-04-01 15:18:53","songcount":13,"imgurl":"http://c1.kgimg.com/stdmusic/150/20160921/20160921005540946787.jpg","suid":509005474,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"\u201c明天，你好<\/em>\u201d\u2014\u2014牛奶咖啡讲述十年记","gid":"collection_3_509005474_21_0"},{"contain":"再见 你好<\/em> (片段)","nickname":"塔","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":105345,"singername":"","verified":0,"publishtime":"2020-02-07 11:45:44","songcount":984,"imgurl":"http://c1.kgimg.com/custom/150/20200401/20200401144837230551.jpg","suid":1504351688,"iscustom":0,"isperiodical":0,"specialid":2027918,"specialname":"超好听/甜的热歌，祝你天天开心，考生加油～","gid":"collection_3_1504351688_7_0"},{"contain":"你好<\/em>","nickname":"绘梨衣","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":585,"singername":"","verified":0,"publishtime":"2020-03-05 17:43:55","songcount":30,"imgurl":"http://c1.kgimg.com/custom/150/20200305/20200305174213746862.jpg","suid":1269466115,"iscustom":0,"isperiodical":0,"specialid":2156843,"specialname":"初音未来w","gid":"collection_3_1269466115_24_0"},{"contain":"","nickname":"情砉","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":22003,"singername":"","verified":0,"publishtime":"2016-03-31 01:42:29","songcount":34,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150715/20150715185416155784.jpg","suid":509004715,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"老表你好<\/em>hea","gid":"collection_3_509004715_7_0"},{"contain":"","nickname":"风中追风","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":17488,"singername":"","verified":0,"publishtime":"2016-05-12 16:38:33","songcount":13,"imgurl":"http://c1.kgimg.com/soft/collection/{size}/20160606/20160606181225538271.jpg","suid":509005795,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"你好<\/em> 清芬五月","gid":"collection_3_509005795_24_0"},{"contain":"","nickname":"酷狗轻音乐小编","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":104186,"singername":"","verified":0,"publishtime":"2019-12-02 18:03:17","songcount":24,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20191202/20191202180636589045.jpg","suid":1127147424,"iscustom":0,"isperiodical":0,"specialid":1567300,"specialname":"【唤醒你的耳朵】冬天，你好<\/em>","gid":"collection_3_1127147424_180_0"},{"contain":"你好<\/em>","nickname":"冰枫","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":324230,"singername":"","verified":0,"publishtime":"2017-08-28 15:09:05","songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171220/20171220175345372690.jpg","suid":509005552,"iscustom":0,"isperiodical":0,"specialid":152472,"specialname":"初音未来中文神调教！！","gid":"collection_3_509005552_33_0"},{"contain":"你好<\/em>","nickname":"June","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2428335,"singername":"","verified":0,"publishtime":"2018-12-13 15:31:37","songcount":43,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20190416/20190416181548603608.jpg","suid":1219351517,"iscustom":0,"isperiodical":0,"specialid":574517,"specialname":"专为宝宝打造的流行歌","gid":"collection_3_1219351517_38_0"},{"contain":"","nickname":"梦醒","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":497793,"singername":"","verified":0,"publishtime":"2017-04-30 16:40:03","songcount":25,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170430/20170430163955119171.jpg","suid":509004274,"iscustom":0,"isperiodical":0,"specialid":123764,"specialname":"治愈系歌曲带给你好<\/em>心情","gid":"collection_3_509004274_29_0"},{"contain":"","nickname":"小栗子今天更新了吗","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":1134667,"singername":"","verified":0,"publishtime":"2017-10-10 14:19:48","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171011/20171011155754440457.jpg","suid":401738841,"iscustom":0,"isperiodical":0,"specialid":181470,"specialname":"有些话你好<\/em>想说，但从没说出口","gid":"collection_3_401738841_149_0"},{"contain":"请先说你好<\/em> (片段)","nickname":"逸潇","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":131950,"singername":"","verified":0,"publishtime":"2020-05-04 10:30:58","songcount":168,"imgurl":"http://c1.kgimg.com/custom/150/20200505/20200505085856862671.jpg","suid":1105313420,"iscustom":0,"isperiodical":0,"specialid":2474996,"specialname":"伤感片段：我好希望你只有我啊","gid":"collection_3_1105313420_11_0"},{"contain":"","nickname":"影视大杂烩","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":118785,"singername":"","verified":0,"publishtime":"2015-01-17 18:31:07","songcount":25,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150718/20150718063610659322.jpg","suid":373452632,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"我很好，你好<\/em>吗","gid":"collection_3_373452632_83_0"},{"contain":"你好<\/em>","nickname":"超级宝贝","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":286970,"singername":"","verified":0,"publishtime":"2017-07-03 01:04:30","songcount":63,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170703/20170703010335660501.jpg","suid":509004859,"iscustom":0,"isperiodical":0,"specialid":127177,"specialname":"Hoop圈圈歌曲合集","gid":"collection_3_509004859_31_0"},{"contain":"","nickname":"超好玩的视频放送","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":5648464,"singername":"","verified":0,"publishtime":"2014-12-25 17:05:20","songcount":70,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20141225/20141225170442243734.jpg","suid":373452636,"iscustom":0,"isperiodical":0,"specialid":23350,"specialname":"我说你好<\/em>，你说打扰","gid":"collection_3_373452636_76_0"},{"contain":"你好<\/em>","nickname":"沙王","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2193618,"singername":"","verified":0,"publishtime":"2017-03-21 17:16:08","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171219/20171219094243828234.jpg","suid":509005128,"iscustom":0,"isperiodical":0,"specialid":122910,"specialname":"动漫专区-每日推荐歌单(171219)","gid":"collection_3_509005128_30_0"}],"total":251}
     * errcode : 0
     */

    private int status;
    private String error;
    private DataBean data;
    private int errcode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public static class DataBean {
        /**
         * timestamp : 1604388663
         * info : [{"contain":"","nickname":"圣","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2448476,"singername":"","verified":0,"publishtime":"2020-09-28 11:30:14","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20200928/20200928112850220178.jpg","suid":509005055,"iscustom":0,"isperiodical":0,"specialid":3117485,"specialname":"你好<\/em>DJ，来个串烧套餐好伐？","gid":"collection_3_509005055_36_0"},{"contain":"","nickname":"兔八哥","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":43019,"singername":"","verified":0,"publishtime":"2015-08-31 11:41:26","songcount":50,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20150831/20150831114535855399.jpg","suid":509001535,"iscustom":0,"isperiodical":0,"specialid":26134,"specialname":"再见八月，九月你好<\/em>","gid":"collection_3_509001535_2_0"},{"contain":"","nickname":"来自仙女的念想","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":286,"singername":"","verified":0,"publishtime":"2020-03-17 10:25:20","songcount":24,"imgurl":"http://c1.kgimg.com/custom/150/20200317/20200317102338411257.jpg","suid":1210258192,"iscustom":0,"isperiodical":0,"specialid":2218033,"specialname":"你好<\/em>，能不能借一生说话。","gid":"collection_3_1210258192_23_0"},{"contain":"","nickname":"予茕兔桃想","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":0,"singername":"","verified":0,"publishtime":"2016-03-31 18:57:36","songcount":16,"imgurl":"http://c1.kgimg.com/stdmusic/150/20200615/20200615110654613657.png","suid":509004838,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"你好<\/em> | 李志 | 这个世界会好吗？","gid":"collection_3_509004838_12_0"},{"contain":"","nickname":"巫师","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":1603,"singername":"","verified":0,"publishtime":"2016-03-31 22:23:47","songcount":28,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150719/20150719043652607845.jpg","suid":509004289,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"土嗨你好<\/em>，土嗨再见！","gid":"collection_3_509004289_14_0"},{"contain":"","nickname":"鬼鬼不哭","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":46365,"singername":"","verified":0,"publishtime":"2016-04-01 15:18:53","songcount":13,"imgurl":"http://c1.kgimg.com/stdmusic/150/20160921/20160921005540946787.jpg","suid":509005474,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"\u201c明天，你好<\/em>\u201d\u2014\u2014牛奶咖啡讲述十年记","gid":"collection_3_509005474_21_0"},{"contain":"再见 你好<\/em> (片段)","nickname":"塔","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":105345,"singername":"","verified":0,"publishtime":"2020-02-07 11:45:44","songcount":984,"imgurl":"http://c1.kgimg.com/custom/150/20200401/20200401144837230551.jpg","suid":1504351688,"iscustom":0,"isperiodical":0,"specialid":2027918,"specialname":"超好听/甜的热歌，祝你天天开心，考生加油～","gid":"collection_3_1504351688_7_0"},{"contain":"你好<\/em>","nickname":"绘梨衣","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":585,"singername":"","verified":0,"publishtime":"2020-03-05 17:43:55","songcount":30,"imgurl":"http://c1.kgimg.com/custom/150/20200305/20200305174213746862.jpg","suid":1269466115,"iscustom":0,"isperiodical":0,"specialid":2156843,"specialname":"初音未来w","gid":"collection_3_1269466115_24_0"},{"contain":"","nickname":"情砉","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":22003,"singername":"","verified":0,"publishtime":"2016-03-31 01:42:29","songcount":34,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150715/20150715185416155784.jpg","suid":509004715,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"老表你好<\/em>hea","gid":"collection_3_509004715_7_0"},{"contain":"","nickname":"风中追风","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":17488,"singername":"","verified":0,"publishtime":"2016-05-12 16:38:33","songcount":13,"imgurl":"http://c1.kgimg.com/soft/collection/{size}/20160606/20160606181225538271.jpg","suid":509005795,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"你好<\/em> 清芬五月","gid":"collection_3_509005795_24_0"},{"contain":"","nickname":"酷狗轻音乐小编","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":104186,"singername":"","verified":0,"publishtime":"2019-12-02 18:03:17","songcount":24,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20191202/20191202180636589045.jpg","suid":1127147424,"iscustom":0,"isperiodical":0,"specialid":1567300,"specialname":"【唤醒你的耳朵】冬天，你好<\/em>","gid":"collection_3_1127147424_180_0"},{"contain":"你好<\/em>","nickname":"冰枫","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":324230,"singername":"","verified":0,"publishtime":"2017-08-28 15:09:05","songcount":40,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171220/20171220175345372690.jpg","suid":509005552,"iscustom":0,"isperiodical":0,"specialid":152472,"specialname":"初音未来中文神调教！！","gid":"collection_3_509005552_33_0"},{"contain":"你好<\/em>","nickname":"June","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2428335,"singername":"","verified":0,"publishtime":"2018-12-13 15:31:37","songcount":43,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20190416/20190416181548603608.jpg","suid":1219351517,"iscustom":0,"isperiodical":0,"specialid":574517,"specialname":"专为宝宝打造的流行歌","gid":"collection_3_1219351517_38_0"},{"contain":"","nickname":"梦醒","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":497793,"singername":"","verified":0,"publishtime":"2017-04-30 16:40:03","songcount":25,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170430/20170430163955119171.jpg","suid":509004274,"iscustom":0,"isperiodical":0,"specialid":123764,"specialname":"治愈系歌曲带给你好<\/em>心情","gid":"collection_3_509004274_29_0"},{"contain":"","nickname":"小栗子今天更新了吗","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":1134667,"singername":"","verified":0,"publishtime":"2017-10-10 14:19:48","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171011/20171011155754440457.jpg","suid":401738841,"iscustom":0,"isperiodical":0,"specialid":181470,"specialname":"有些话你好<\/em>想说，但从没说出口","gid":"collection_3_401738841_149_0"},{"contain":"请先说你好<\/em> (片段)","nickname":"逸潇","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":131950,"singername":"","verified":0,"publishtime":"2020-05-04 10:30:58","songcount":168,"imgurl":"http://c1.kgimg.com/custom/150/20200505/20200505085856862671.jpg","suid":1105313420,"iscustom":0,"isperiodical":0,"specialid":2474996,"specialname":"伤感片段：我好希望你只有我啊","gid":"collection_3_1105313420_11_0"},{"contain":"","nickname":"影视大杂烩","intro":"","collectcount":0,"slid":0,"trans_param":null,"nper":0,"playcount":118785,"singername":"","verified":0,"publishtime":"2015-01-17 18:31:07","songcount":25,"imgurl":"http://c1.kgimg.com/stdmusic/150/20150718/20150718063610659322.jpg","suid":373452632,"iscustom":0,"isperiodical":0,"specialid":0,"specialname":"我很好，你好<\/em>吗","gid":"collection_3_373452632_83_0"},{"contain":"你好<\/em>","nickname":"超级宝贝","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":286970,"singername":"","verified":0,"publishtime":"2017-07-03 01:04:30","songcount":63,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20170703/20170703010335660501.jpg","suid":509004859,"iscustom":0,"isperiodical":0,"specialid":127177,"specialname":"Hoop圈圈歌曲合集","gid":"collection_3_509004859_31_0"},{"contain":"","nickname":"超好玩的视频放送","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":5648464,"singername":"","verified":0,"publishtime":"2014-12-25 17:05:20","songcount":70,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20141225/20141225170442243734.jpg","suid":373452636,"iscustom":0,"isperiodical":0,"specialid":23350,"specialname":"我说你好<\/em>，你说打扰","gid":"collection_3_373452636_76_0"},{"contain":"你好<\/em>","nickname":"沙王","intro":"","collectcount":0,"slid":0,"trans_param":{"special_tag":0},"nper":0,"playcount":2193618,"singername":"","verified":0,"publishtime":"2017-03-21 17:16:08","songcount":20,"imgurl":"http://imge.kugou.com/soft/collection/{size}/20171219/20171219094243828234.jpg","suid":509005128,"iscustom":0,"isperiodical":0,"specialid":122910,"specialname":"动漫专区-每日推荐歌单(171219)","gid":"collection_3_509005128_30_0"}]
         * total : 251
         */

        private int timestamp;
        private int total;
        private List<InfoBean> info;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * contain :
             * nickname : 圣
             * intro :
             * collectcount : 0
             * slid : 0
             * trans_param : {"special_tag":0}
             * nper : 0
             * playcount : 2448476
             * singername :
             * verified : 0
             * publishtime : 2020-09-28 11:30:14
             * songcount : 20
             * imgurl : http://imge.kugou.com/soft/collection/{size}/20200928/20200928112850220178.jpg
             * suid : 509005055
             * iscustom : 0
             * isperiodical : 0
             * specialid : 3117485
             * specialname : 你好</em>DJ，来个串烧套餐好伐？
             * gid : collection_3_509005055_36_0
             */

            private String contain;
            private String nickname;
            private String intro;
            private int collectcount;
            private int slid;
            private TransParamBean trans_param;
            private int nper;
            private int playcount;
            private String singername;
            private int verified;
            private String publishtime;
            private int songcount;
            private String imgurl;
            private int suid;
            private int iscustom;
            private int isperiodical;
            private int specialid;
            private String specialname;
            private String gid;

            public String getContain() {
                return contain;
            }

            public void setContain(String contain) {
                this.contain = contain;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getCollectcount() {
                return collectcount;
            }

            public void setCollectcount(int collectcount) {
                this.collectcount = collectcount;
            }

            public int getSlid() {
                return slid;
            }

            public void setSlid(int slid) {
                this.slid = slid;
            }

            public TransParamBean getTrans_param() {
                return trans_param;
            }

            public void setTrans_param(TransParamBean trans_param) {
                this.trans_param = trans_param;
            }

            public int getNper() {
                return nper;
            }

            public void setNper(int nper) {
                this.nper = nper;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public String getSingername() {
                return singername;
            }

            public void setSingername(String singername) {
                this.singername = singername;
            }

            public int getVerified() {
                return verified;
            }

            public void setVerified(int verified) {
                this.verified = verified;
            }

            public String getPublishtime() {
                return publishtime;
            }

            public void setPublishtime(String publishtime) {
                this.publishtime = publishtime;
            }

            public int getSongcount() {
                return songcount;
            }

            public void setSongcount(int songcount) {
                this.songcount = songcount;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getSuid() {
                return suid;
            }

            public void setSuid(int suid) {
                this.suid = suid;
            }

            public int getIscustom() {
                return iscustom;
            }

            public void setIscustom(int iscustom) {
                this.iscustom = iscustom;
            }

            public int getIsperiodical() {
                return isperiodical;
            }

            public void setIsperiodical(int isperiodical) {
                this.isperiodical = isperiodical;
            }

            public int getSpecialid() {
                return specialid;
            }

            public void setSpecialid(int specialid) {
                this.specialid = specialid;
            }

            public String getSpecialname() {
                return specialname;
            }

            public void setSpecialname(String specialname) {
                this.specialname = specialname;
            }

            public String getGid() {
                return gid;
            }

            public void setGid(String gid) {
                this.gid = gid;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof InfoBean)) return false;
                InfoBean infoBean = (InfoBean) o;
                return getCollectcount() == infoBean.getCollectcount() &&
                        getSlid() == infoBean.getSlid() &&
                        getNper() == infoBean.getNper() &&
                        getPlaycount() == infoBean.getPlaycount() &&
                        getVerified() == infoBean.getVerified() &&
                        getSongcount() == infoBean.getSongcount() &&
                        getSuid() == infoBean.getSuid() &&
                        getIscustom() == infoBean.getIscustom() &&
                        getIsperiodical() == infoBean.getIsperiodical() &&
                        getSpecialid() == infoBean.getSpecialid() &&
                        Objects.equals(getContain(), infoBean.getContain()) &&
                        Objects.equals(getNickname(), infoBean.getNickname()) &&
                        Objects.equals(getIntro(), infoBean.getIntro()) &&
                        Objects.equals(getTrans_param(), infoBean.getTrans_param()) &&
                        Objects.equals(getSingername(), infoBean.getSingername()) &&
                        Objects.equals(getPublishtime(), infoBean.getPublishtime()) &&
                        Objects.equals(getImgurl(), infoBean.getImgurl()) &&
                        Objects.equals(getSpecialname(), infoBean.getSpecialname()) &&
                        Objects.equals(getGid(), infoBean.getGid());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getContain(), getNickname(), getIntro(), getCollectcount(), getSlid(), getTrans_param(), getNper(), getPlaycount(), getSingername(), getVerified(), getPublishtime(), getSongcount(), getImgurl(), getSuid(), getIscustom(), getIsperiodical(), getSpecialid(), getSpecialname(), getGid());
            }

            public static class TransParamBean {
                /**
                 * special_tag : 0
                 */

                private int special_tag;

                public int getSpecial_tag() {
                    return special_tag;
                }

                public void setSpecial_tag(int special_tag) {
                    this.special_tag = special_tag;
                }
            }
        }
    }


//    private String id;
//    private String name;
//    private String sex;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    // 比较的函数
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Notifications notifications = (Notifications) o;
//        return id.equals(notifications.id) &&
//                name.equals(notifications.name) &&
//                sex.equals(notifications.sex);
//    }
//
//    // 比较的函数
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, sex);
//    }
}
