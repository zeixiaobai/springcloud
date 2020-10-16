package org.springcloud.template.usercenter.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.zxb.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * TODO
 *
 * @author zjx
 * @date 2020/7/30 0030 21:58
 */
@Data
@Entity
@Table(name = "el_application")
@DynamicInsert
@DynamicUpdate
public class Application extends BaseEntity {

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "name")
    private String name;

    @Column(name = "user_public_key")
    private String userPublicKey;

    @Column(name = "remark")
    private String remark;

    @Column(name = "expire_time")
    private Date expireTime;
}
