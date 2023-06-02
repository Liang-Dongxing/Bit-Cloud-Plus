package com.bit.system.domain.convert;

import com.bit.system.domain.vo.SysDictDataVo;
import io.github.linpeilie.BaseMapper;
import com.bit.system.api.domain.vo.RemoteDictDataVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * 字典数据转换器
 * @author zhujie
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysDictDataVoConvert extends BaseMapper<SysDictDataVo, RemoteDictDataVo> {

}
