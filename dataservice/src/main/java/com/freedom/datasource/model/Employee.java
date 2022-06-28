package com.freedom.datasource.model;

import com.freedom.datasource.dto.EmployeeExtendedInfoDto;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "employee")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "contact", nullable = false)
  private String contact;

  @Column(name = "address")
  private String address;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "extended_info")
  @Type(type = "json")
  private EmployeeExtendedInfoDto extendedInfo;

  @Column(name = "created_on", insertable = false, updatable = false)
  private Date createdOn;

  @Column(name = "updated_on", insertable = false, updatable = false)
  private Date updatedOn;
}
/*
CREATE TABLE `employee` (
    `id`                BIGINT          NOT NULL AUTO_INCREMENT,
    `name`              VARCHAR(200)     NOT NULL,
    `contact`           VARCHAR(60)     NOT NULL,
    `address`           VARCHAR(40)     NOT NULL,
    `status`            VARCHAR(40)     DEFAULT NULL,
    `extended_info`     JSON            DEFAULT NULL,
    `created_on`        DATETIME(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_on`        DATETIME(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`),
    KEY `cxt_created_on` (`created_on`),
    KEY `cxt_updated_on` (`updated_on`)
);
*/
