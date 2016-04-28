package com.clear.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ユーザ情報
 * 
 * @author FNST
 * @date 2015-07-02
 */
@MappedSuperclass
public class BaseEntity {

    /** 登録担当者 **/
    @Column(name = "INSTT", columnDefinition = "VARCHAR(10)")
    private String instt;

    /** 登録日 **/
    @Column(name = "INSD")
    @Temporal(TemporalType.DATE)
    private Date insd;

    /** 更新担当者 **/
    @Column(name = "UPTT", columnDefinition = "VARCHAR(10)")
    private String uptt;

    /** 更新日 **/
    @Column(name = "UPD")
    @Temporal(TemporalType.DATE)
    private Date upd;

    /** 削除フラグ **/
    @Column(name = "DELFLG", columnDefinition = "CHAR(1)")
    private String delFlg;

    /** 最終ログイン日時 **/
    @Column(name = "LASTLOGIN")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;

    /** パスワード変更日時 **/
    @Column(name = "LASTPASSD")
    @Temporal(TemporalType.DATE)
    private Date lastPassd;

    /** SALT **/
    @Column(name = "SALT", columnDefinition = "VARCHAR(255)")
    private String salt;

    /** TOKEN **/
    @Column(name = "TOKEN", columnDefinition = "VARCHAR(255)")
    private String token;

    public String getInstt() {
        return instt;
    }

    public Date getInsd() {
        return insd;
    }

    public String getUptt() {
        return uptt;
    }

    public Date getUpd() {
        return upd;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getLastPassd() {
        return lastPassd;
    }

    public void setInstt(String instt) {
        this.instt = instt;
    }

    public void setInsd(Date insd) {
        this.insd = insd;
    }

    public void setUptt(String uptt) {
        this.uptt = uptt;
    }

    public void setUpd(Date upd) {
        this.upd = upd;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastPassd(Date lastPassd) {
        this.lastPassd = lastPassd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
