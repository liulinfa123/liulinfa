package com.app.admin.dto;

import com.app.utils.SecurityUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改密码所需参数")
public class ChangePWDTO {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("原始密码")
    private String passWord;

    @ApiModelProperty("新密码")
    private String newPassWord;

    @ApiModelProperty("确认新密码")
    private String resultPassWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return SecurityUtil.encrypt(passWord);
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNewPassWord() {
        return SecurityUtil.encrypt(newPassWord);
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }

    public String getResultPassWord() {
        return SecurityUtil.encrypt(resultPassWord);
    }

    public void setResultPassWord(String resultPassWord) {
        this.resultPassWord = resultPassWord;
    }
}
