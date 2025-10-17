package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.CrowdTags;
import cn.bugstack.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 人群标签
 */
@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);

}
