package com.bit.system.domain.convert;

import com.bit.system.domain.bo.SysUserBo;
import io.github.linpeilie.BaseMapper;
import com.bit.system.api.domain.bo.RemoteUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * 用户信息转换器
 * @author zhujie
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysUserBoConvert extends BaseMapper<RemoteUserBo, SysUserBo> {

    /**
     * RemoteUserBoToSysUserBo
     * @param remoteUserBo 待转换对象
     * @return 转换后对象
     */
    @Mapping(target = "roleIds", ignore = true)
    @Mapping(target = "postIds", ignore = true)
    SysUserBo convert(RemoteUserBo remoteUserBo);
}
