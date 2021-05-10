package com.xiaojukeji.kafka.manager.common.entity.dto.normal;

import com.xiaojukeji.kafka.manager.common.entity.dto.ClusterTopicDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Properties;

@ApiModel(description = "创建topic")
public class TopicAddDTO extends ClusterTopicDTO {

  @ApiModelProperty(value = "AppID")
  private String appId;

  @ApiModelProperty(value = "分区数")
  private Integer partitionNum;

  @ApiModelProperty(value = "副本数")
  private Integer replicaNum;

  @ApiModelProperty(value = "消息保存时间(ms)")
  private Long retentionTime;

  @ApiModelProperty(value = "brokerId列表")
  private List<Integer> brokerIdList;

  @ApiModelProperty(value = "RegionId")
  private Long regionId;

  @ApiModelProperty(value = "备注")
  private String description;

  @ApiModelProperty(value = "Topic属性列表")
  private Properties properties;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public Integer getPartitionNum() {
    return partitionNum;
  }

  public void setPartitionNum(Integer partitionNum) {
    this.partitionNum = partitionNum;
  }

  public Integer getReplicaNum() {
    return replicaNum;
  }

  public void setReplicaNum(Integer replicaNum) {
    this.replicaNum = replicaNum;
  }

  public Long getRetentionTime() {
    return retentionTime;
  }

  public void setRetentionTime(Long retentionTime) {
    this.retentionTime = retentionTime;
  }

  public List<Integer> getBrokerIdList() {
    return brokerIdList;
  }

  public void setBrokerIdList(List<Integer> brokerIdList) {
    this.brokerIdList = brokerIdList;
  }

  public Long getRegionId() {
    return regionId;
  }

  public void setRegionId(Long regionId) {
    this.regionId = regionId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

}