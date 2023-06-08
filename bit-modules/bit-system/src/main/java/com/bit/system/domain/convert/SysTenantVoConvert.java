package com.bit.system.domain.convert;

import com.bit.system.domain.vo.SysTenantVo;
import io.github.linpeilie.BaseMapper;
import com.bit.system.api.domain.vo.RemoteTenantVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * 租户转换器
 * @author zhujie
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysTenantVoConvert extends BaseMapper<SysTenantVo, RemoteTenantVo> {

}
