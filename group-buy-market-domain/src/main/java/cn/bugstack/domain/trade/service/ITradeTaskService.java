package cn.bugstack.domain.trade.service;

import cn.bugstack.domain.trade.model.entity.NotifyTaskEntity;

import java.util.Map;

/**
 * 交易任务（MT/HTTP）服务接口
 */
public interface ITradeTaskService {

    /**
     * 执行结算通知任务
     *
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execNotifyJob() throws Exception;

    /**
     * 执行结算通知任务
     *
     * @param teamId 指定结算组ID
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execNotifyJob(String teamId) throws Exception;

    /**
     * 执行结算通知任务
     *
     * @param notifyTaskEntity 通知任务对象
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execNotifyJob(NotifyTaskEntity notifyTaskEntity) throws Exception;

}
