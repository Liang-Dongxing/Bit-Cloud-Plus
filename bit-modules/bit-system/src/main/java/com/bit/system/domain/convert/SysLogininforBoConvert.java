package com.bit.system.domain.convert;

import com.bit.system.domain.bo.SysLogininforBo;
import io.github.linpeilie.BaseMapper;
import com.bit.system.api.domain.bo.RemoteLogininforBo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * 登录日志转换器
 * @author zhujie
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysLogininforBoConvert extends BaseMapper<RemoteLogininforBo, SysLogininforBo> {

}
