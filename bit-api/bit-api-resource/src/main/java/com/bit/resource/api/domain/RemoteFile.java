package com.bit.resource.api.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 文件信息
 *
 * @author bit
 */
@Data
public class RemoteFile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * oss主键
     */
    private Long ossId;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件地址
     */
    private String url;

}
