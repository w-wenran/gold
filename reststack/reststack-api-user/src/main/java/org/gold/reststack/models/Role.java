package org.gold.reststack.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gold.reststack.utils.beannote.Note;

/**
 * Created by wangwr on 2016.3.24.
 */
public class Role {

    @Note("角色名称")
    @JsonProperty("role_name")
    private String roleName;

    @Note("角色编码")
    @JsonProperty("role_code")
    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
