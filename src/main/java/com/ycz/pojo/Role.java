package com.ycz.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String rolename;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy--MM-dd")
    private Date createTime;
}
