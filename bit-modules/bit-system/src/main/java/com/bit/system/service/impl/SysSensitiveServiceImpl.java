package com.bit.system.service.impl;

import com.bit.common.satoken.utils.LoginHelper;
import com.bit.common.sensitive.core.SensitiveService;
import com.bit.common.tenant.helper.TenantHelper;
import org.springframework.stereotype.Service;

/**
 * 脱敏服务
 * 默认管理员不过滤
 * 需自行根据业务重写实现
 *
 * @author Lion Li
 * @version 3.6.0
 */
@Service
public class SysSensitiveServiceImpl implements SensitiveService {

    /**
     * 是否脱敏
     */
    @Override
    public boolean isSensitive() {
        if (TenantHelper.isEnable()) {
            return !LoginHelper.isSuperAdmin() || !LoginHelper.isTenantAdmin();
        }
        return !LoginHelper.isSuperAdmin();
    }

}
