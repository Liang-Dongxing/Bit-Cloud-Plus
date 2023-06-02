package com.bit.system.api;

import com.bit.system.api.domain.bo.RemoteOperLogBo;
import com.bit.system.api.domain.bo.RemoteLogininforBo;

/**
 * 日志服务
 *
 * @author Lion Li
 */
public interface RemoteLogService {

    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     */
    void saveLog(RemoteOperLogBo sysOperLog);

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     */
    void saveLogininfor(RemoteLogininforBo sysLogininfor);
}
