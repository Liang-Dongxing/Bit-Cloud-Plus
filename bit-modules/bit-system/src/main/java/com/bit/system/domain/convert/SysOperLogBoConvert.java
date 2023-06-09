package com.bit.system.domain.convert;

import com.bit.system.domain.bo.SysOperLogBo;
import io.github.linpeilie.BaseMapper;
import com.bit.system.api.domain.bo.RemoteOperLogBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * 操作日志转换器
 * @author zhujie
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperLogBoConvert extends BaseMapper<RemoteOperLogBo, SysOperLogBo> {

    /**
     * RemoteOperLogBoToSysOperLogBo
     * @param remoteOperLogBo 待转换对象
     * @return 转换后对象
     */
    @Mapping(target = "businessTypes", ignore = true)
    SysOperLogBo convert(RemoteOperLogBo remoteOperLogBo);
}