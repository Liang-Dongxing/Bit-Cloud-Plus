package com.bit.resource.dubbo;

import cn.hutool.core.bean.BeanUtil;
import com.bit.common.core.exception.ServiceException;
import com.bit.common.core.utils.SpringUtils;
import com.bit.common.sms.config.properties.SmsProperties;
import com.bit.common.sms.core.SmsTemplate;
import com.bit.common.sms.entity.SmsResult;
import com.bit.resource.api.RemoteSmsService;
import com.bit.resource.api.domain.RemoteSms;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 短信服务
 *
 * @author Lion Li
 */
@Slf4j
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteSmsServiceImpl implements RemoteSmsService {

    private final SmsProperties smsProperties;

    /**
     * 发送短信
     *
     * @param phones     电话号(多个逗号分割)
     * @param templateId 模板id
     * @param param      模板对应参数
     */
    public RemoteSms send(String phones, String templateId, Map<String, String> param) throws ServiceException {
        if (!smsProperties.getEnabled()) {
            throw new ServiceException("当前系统没有开启短信功能！");
        }
        SmsTemplate smsTemplate = SpringUtils.getBean(SmsTemplate.class);
        SmsResult smsResult = smsTemplate.send(phones, templateId, param);
        return BeanUtil.toBean(smsResult, RemoteSms.class);
    }

}
