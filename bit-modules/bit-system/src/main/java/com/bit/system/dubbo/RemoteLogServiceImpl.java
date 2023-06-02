package com.bit.system.dubbo;

import com.bit.system.domain.bo.SysLogininforBo;
import com.bit.system.domain.bo.SysOperLogBo;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import com.bit.common.core.utils.MapstructUtils;
import com.bit.system.api.RemoteLogService;
import com.bit.system.api.domain.bo.RemoteLogininforBo;
import com.bit.system.api.domain.bo.RemoteOperLogBo;
import com.bit.system.service.ISysLogininforService;
import com.bit.system.service.ISysOperLogService;
import org.springframework.stereotype.Service;

/**
 * 操作日志记录
 *
 * @author Lion Li
 */
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteLogServiceImpl implements RemoteLogService {

    private final ISysOperLogService operLogService;
    private final ISysLogininforService logininforService;

    @Override
    public void saveLog(RemoteOperLogBo remoteOperLogBo) {
        SysOperLogBo sysOperLogBo = MapstructUtils.convert(remoteOperLogBo, SysOperLogBo.class);
        operLogService.insertOperlog(sysOperLogBo);
    }

    @Override
    public void saveLogininfor(RemoteLogininforBo remoteLogininforBo) {
        SysLogininforBo sysLogininforBo = MapstructUtils.convert(remoteLogininforBo, SysLogininforBo.class);
        logininforService.insertLogininfor(sysLogininforBo);
    }
}
