package com.example.myapplication.ui.notifications;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 实体bean
 */
public class Notifications implements Serializable {

    private String reason;
    private Notifications.ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Notifications.ResultBean getResult() {
        return result;
    }

    public void setResult(Notifications.ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private List<Notifications.ResultBean.DataBean> data;

        public List<Notifications.ResultBean.DataBean> getData() {
            return data;
        }

        public void setData(List<Notifications.ResultBean.DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * content : 昨天下班坐公交车回家，白天上班坐着坐多了想站一会儿，
             就把座位让给了一个阿姨，阿姨道谢一番开始和我聊天，聊了挺多的。
             后来我要下车了，阿姨热情的和我道别。
             下车的一瞬间我回头看了一眼，只见那阿姨对着手机说：“儿子，
             刚才遇见一个姑娘特不错，可惜长得不好看，不然我肯定帮你要号码！”
             靠，阿姨你下车，我保证不打死你！
             * hashId : 348e7f933774bcaef3ed3f0ecb8e7b19
             * unixtime : 1418819032
             * updatetime : 2014-12-17 20:23:52
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                DataBean dataBean = (DataBean) o;
                return unixtime == dataBean.unixtime &&
                        content.equals(dataBean.content) &&
                        hashId.equals(dataBean.hashId) &&
                        updatetime.equals(dataBean.updatetime);
            }

            @Override
            public int hashCode() {
                return Objects.hash(content, hashId, unixtime, updatetime);
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
