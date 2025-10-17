package cn.bugstack.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 回调任务实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotifyTaskEntity {

    /**
     * 拼单组队ID
     */
    private String teamId;
    /**
     * 回调类型
     */
    private String notifyType;
    /**
     * 回调消息
     */
    private String notifyMQ;
    /**
     * 回调接口
     */
    private String notifyUrl;
    /**
     * 回调次数
     */
    private Integer notifyCount;
    /**
     * 参数对象
     */
    private String parameterJson;
    /**
     * 唯一标识
     */
    private String uuid;

    public String lockKey() {
        return "notify_job_lock_key_" + this.uuid;
    }

}
