package com.ycz.realm;

import com.ycz.pojo.User;
import com.ycz.service.PermissionService;
import com.ycz.service.RoleService;
import com.ycz.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * 用于对用户的身份和权限进行验证
 */

@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();

        Set<String> roles = roleService.queryAllRolenameByUsername(username);
        Set<String> permissions = permissionService.queryAllPermissionByUsername(username);

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();

        User user = userService.queryUserByUsername(username);

        if(user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user.getUsername(),
                                            user.getPassword(),
                                            ByteSource.Util.bytes(user.getSalt()),
                                            this.getName());
    }
}
