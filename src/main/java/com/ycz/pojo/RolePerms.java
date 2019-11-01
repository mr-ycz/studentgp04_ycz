package com.ycz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePerms {
    private Integer id;
    private Integer permId;
    private Integer roleId;
}
