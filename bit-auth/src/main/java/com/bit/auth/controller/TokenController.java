package com.bit.auth.controller;

import cn.hutool.core.collection.CollUtil;
import com.bit.auth.domain.vo.LoginTenantVo;
import com.bit.auth.domain.vo.LoginVo;
import com.bit.auth.domain.vo.TenantListVo;
import com.bit.auth.form.EmailLoginBody;
import com.bit.auth.form.RegisterBody;
import com.bit.auth.form.SmsLoginBody;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import com.bit.auth.form.LoginBody;
import com.bit.auth.service.SysLoginService;
import com.bit.common.core.domain.R;
import com.bit.common.core.utils.MapstructUtils;
import com.bit.common.core.utils.StreamUtils;
import com.bit.common.core.utils.StringUtils;
import com.bit.common.tenant.helper.TenantHelper;
import com.bit.system.api.RemoteTenantService;
import com.bit.system.api.domain.vo.RemoteTenantVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import java.net.URL;
import java.util.List;

/**
 * token 控制
 *
 * @author Lion Li
 */
@Validated
@RequiredArgsConstructor
@RestController
public class TokenController {

    private final SysLoginService sysLoginService;

    @DubboReference
    private final RemoteTenantService remoteTenantService;

    /**
     * 登录方法
     */
    @PostMapping("login")
    public R<LoginVo> login(@Validated @RequestBody LoginBody body) {
        LoginVo loginVo = new LoginVo();
        // 生成令牌
        String token = sysLoginService.login(
            body.getTenantId(),
            body.getUsername(),
            body.getPassword());
        loginVo.setToken(token);
        return R.ok(loginVo);
    }

    /**
     * 短信登录
     *
     * @param smsLoginBody 登录信息
     * @return 结果
     */
    @PostMapping("/smsLogin")
    public R<LoginVo> smsLogin(@Validated @RequestBody SmsLoginBody smsLoginBody) {
        LoginVo loginVo = new LoginVo();
        // 生成令牌
        String token = sysLoginService.smsLogin(
            smsLoginBody.getTenantId(),
            smsLoginBody.getPhonenumber(),
            smsLoginBody.getSmsCode());
        loginVo.setToken(token);
        return R.ok(loginVo);
    }

    /**
     * 邮件登录
     *
     * @param body 登录信息
     * @return 结果
     */
    @PostMapping("/emailLogin")
    public R<LoginVo> emailLogin(@Validated @RequestBody EmailLoginBody body) {
        LoginVo loginVo = new LoginVo();
        // 生成令牌
        String token = sysLoginService.emailLogin(
            body.getTenantId(),
            body.getEmail(),
            body.getEmailCode());
        loginVo.setToken(token);
        return R.ok(loginVo);
    }

    /**
     * 小程序登录(示例)
     *
     * @param xcxCode 小程序code
     * @return 结果
     */
    @PostMapping("/xcxLogin")
    public R<LoginVo> xcxLogin(@NotBlank(message = "{xcx.code.not.blank}") String xcxCode) {
        LoginVo loginVo = new LoginVo();
        // 生成令牌
        String token = sysLoginService.xcxLogin(xcxCode);
        loginVo.setToken(token);
        return R.ok(loginVo);
    }

    /**
     * 登出方法
     */
    @PostMapping("logout")
    public R<Void> logout() {
        sysLoginService.logout();
        return R.ok();
    }

    /**
     * 用户注册
     */
    @PostMapping("register")
    public R<Void> register(@RequestBody RegisterBody registerBody) {
        // 用户注册
        sysLoginService.register(registerBody);
        return R.ok();
    }

    /**
     * 登录页面租户下拉框
     *
     * @return 租户列表
     */
    @GetMapping("/tenant/list")
    public R<LoginTenantVo> tenantList(HttpServletRequest request) throws Exception {
        List<RemoteTenantVo> tenantList = remoteTenantService.queryList();
        List<TenantListVo> voList = MapstructUtils.convert(tenantList, TenantListVo.class);
        // 获取域名
        String host;
        String referer = request.getHeader("referer");
        if (StringUtils.isNotBlank(referer)) {
            // 这里从referer中取值是为了本地使用hosts添加虚拟域名，方便本地环境调试
            host = referer.split("//")[1].split("/")[0];
        } else {
            host = new URL(request.getRequestURL().toString()).getHost();
        }
        // 根据域名进行筛选
        List<TenantListVo> list = StreamUtils.filter(voList, vo ->
            StringUtils.equals(vo.getDomain(), host));
        // 返回对象
        LoginTenantVo vo = new LoginTenantVo();
        vo.setVoList(CollUtil.isNotEmpty(list) ? list : voList);
        vo.setTenantEnabled(TenantHelper.isEnable());
        return R.ok(vo);
    }

}
