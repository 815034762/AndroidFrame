package com.example.myapplication.ui.notifications.data.model

import java.io.Serializable
import java.util.*

/**
 * 实体bean
 */
class Notifications : Serializable {
    var status = 0
    var error: String? = null
    var data: DataBean? = null
    var errcode = 0
    class DataBean {
        var timestamp = 0
        var total = 0
        var info: List<InfoBean>? = null
        class InfoBean {
            var contain: String? = null
            var nickname: String? = null
            var intro: String? = null
            var collectcount = 0
            var slid = 0
            var trans_param: TransParamBean? = null
            var nper = 0
            var playcount = 0
            var singername: String? = null
            var verified = 0
            var publishtime: String? = null
            var songcount = 0
            var imgurl: String? = null
            var suid = 0
            var iscustom = 0
            var isperiodical = 0
            var specialid = 0
            var specialname: String? = null
            var gid: String? = null
            override fun equals(o: Any?): Boolean {
                if (this === o) return true
                if (o !is InfoBean) return false
                val infoBean = o
                return collectcount == infoBean.collectcount && slid == infoBean.slid && nper == infoBean.nper && playcount == infoBean.playcount && verified == infoBean.verified && songcount == infoBean.songcount && suid == infoBean.suid && iscustom == infoBean.iscustom && isperiodical == infoBean.isperiodical && specialid == infoBean.specialid &&
                        contain == infoBean.contain &&
                        nickname == infoBean.nickname &&
                        intro == infoBean.intro &&
                        trans_param == infoBean.trans_param &&
                        singername == infoBean.singername &&
                        publishtime == infoBean.publishtime &&
                        imgurl == infoBean.imgurl &&
                        specialname == infoBean.specialname &&
                        gid == infoBean.gid
            }

            override fun hashCode(): Int {
                return Objects.hash(contain, nickname, intro, collectcount, slid, trans_param, nper, playcount, singername, verified, publishtime, songcount, imgurl, suid, iscustom, isperiodical, specialid, specialname, gid)
            }

            class TransParamBean {
                var special_tag = 0
            }
        }
    }
}