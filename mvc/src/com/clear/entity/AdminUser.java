package com.clear.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ADMIN_USER")
public class AdminUser extends BaseEntity{
//    @EmbeddedId
//    private StorePK id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "mySeqGenerator", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 50)
    @GenericGenerator(name = "userGenerator", strategy = "increment")    
    @Column(name = "ID", columnDefinition = "INTEGER")
    private String id;
    
    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(name = "PWD", columnDefinition = "VARCHAR(12)")
    private String pwd;
    @Column(name = "TFS", columnDefinition = "VARCHAR(200)")
    private String tfs;
    @Column(name = "ADDRESS", columnDefinition = "VARCHAR(50)")
    private String addr;
    @Column(name = "PHONE", columnDefinition = "VARCHAR(20)")
    private String tel;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTfs() {
        return tfs;
    }

    public void setTfs(String tfs) {
        this.tfs = tfs;
    }
    
    
}

