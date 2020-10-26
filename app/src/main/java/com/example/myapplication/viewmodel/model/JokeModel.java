package com.example.myapplication.viewmodel.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author ly-zhangty
 * 笑话大全的实体类
 */
public class JokeModel implements Serializable {

//    {
//     reason : Success
//     result : {"data":[{"content":"昨天下班坐公交车回家，白天上班坐着坐多了想站一会儿，\r\n就把座位让给了一个阿姨，阿姨道谢一番开始和我聊天，聊了挺多的。\r\n后来我要下车了，阿姨热情的和我道别。\r\n下车的一瞬间我回头看了一眼，只见那阿姨对着手机说：\u201c儿子，\r\n刚才遇见一个姑娘特不错，可惜长得不好看，不然我肯定帮你要号码！\u201d\r\n靠，阿姨你下车，我保证不打死你！","hashId":"348e7f933774bcaef3ed3f0ecb8e7b19","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"小时候妈妈喂我饭之前会看书，我问她看的什么时。\r\n妈妈总是笑着告诉我：\u201c是《育儿经验宝典》啊！\u201d\r\n我很感动，直到我认识字才发现，妈妈看的是《猪崽饲养手册》。","hashId":"126a79697167f330f3f2339281ccb8b2","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"刚刚在舞蹈学校外接儿子，听到两个已经接到孩子到妈妈在聊天。\r\n妈妈甲：\u201c你闺女这么小就是个美人胚子，大眼睛，双眼皮，瓜子脸。\u201d\r\n妈妈乙：\u201c是啊，长大了不知道要祸害多少男孩！\u201d","hashId":"a38339d867e4de601b0d77e3b94de0ab","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"\u201c科学研究发现，睡眠不足会带来许多身心伤害：免疫力下降、\r\n记忆力减弱、易衰老、失去平衡等等，从而引发多种疾病。\r\n从科学角度讲，睡懒觉有助于身心健康。\u201d\r\n\u201c所以，李老师，这就是你在课堂上睡觉的原因？\u201d校长生气的问我。","hashId":"7fda08b4f42baf3868d6963aa5f2e9aa","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"做饭的时候发现没食用油了，\r\n就叫五岁的儿子\u201c娃儿，去楼下小商店买壶油，顺便买点姜回来。别搞忘了。\u201d\r\n儿子答应，边出门边念叨\u201c油，姜，油，姜，油，姜，油\u2026\u2026\u2026\u2026\u201d\r\n果然，回来带了瓶酱油\u2026\u2026","hashId":"650fd02f47de7bc4795248295a6bbde2","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"我妈研究了几个新菜，邀请我品尝，\r\n结果我没有给她一个yes，被臭骂了一顿，\r\n要和我断绝关系。找我爸评理，\r\n老头说为了公平起见，我还是尝尝菜吧。\r\n吃完后，老头幽幽的说道，你和我也断绝关系吧。","hashId":"70fa72fdf6038d5a7fb1e00a4db008ae","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"有一天晚上我俩一起吃西瓜，老大把西瓜籽很整洁的吐在了一张纸上，\r\n过了几天，我从教室回但宿舍看到老大在磕瓜子，\r\n我就问他：老大，你什么时候买的瓜子？\r\n老大说：刚晒好，说着抓了一把要递给我\u2026\u2026","hashId":"c8aa0e4e178fc61fe51d4279cf1df1b3","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"＂我女朋友气跑了＂\r\n＂怎么回事？严重吗？你怎么着她了？＂\r\n＂不严重，我只是很久没用了＂","hashId":"b5deeae99246331671dce4d5f16c7573","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"还说神马来一场说走就走的旅行，\r\n工作后就连一场说走就走的下班都不行","hashId":"ab6bcb72f06adf3c485a19fed3e9addb","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"},{"content":"高速路上堵车，路边葡萄地里有一哥们竟然在偷葡萄，心想太没素质了吧！\r\n不管了我也去，刚溜进葡萄地，那哥们竟问我干嘛，\r\n我撇了一眼反问道你干嘛呢？\r\n那哥们答道摘葡萄呢！\r\n我答道：我也摘葡萄呢！\r\n哥们郁闷了说我摘我家的你呢？\r\n我顿时脸红，哥你家葡萄咋卖呢？","hashId":"82e537f58a90383a3e85a973c3fae2f3","unixtime":1418819032,"updatetime":"2014-12-17 20:23:52"}]}
//     error_code : 0
//    }

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
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
        }
    }
}
