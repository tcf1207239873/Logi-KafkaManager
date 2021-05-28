package com.xiaojukeji.kafka.manager.web.api.versionone.op;

import com.xiaojukeji.kafka.manager.common.constant.ApiPrefix;
import com.xiaojukeji.kafka.manager.common.entity.PaginationResult;
import com.xiaojukeji.kafka.manager.common.entity.dto.op.reassign.ReassignCmbTaskDTO;
import com.xiaojukeji.kafka.manager.common.entity.vo.op.reassign.ReassignTaskVO;
import com.xiaojukeji.kafka.manager.service.service.ReassignService;
import com.xiaojukeji.kafka.manager.web.converters.ReassignModelConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 招行Topic迁移相关结构
 */
@Api(tags = "OP-CMB-Topic迁移相关接口")
@RestController
@RequestMapping(ApiPrefix.API_V1_OP_PREFIX)
public class OpReassignCmbController {

  @Autowired
  private ReassignService reassignService;

  /**
   * 现在有个问题，该接口是将查询的子任务，按照前端传入的字段排序，在分页的数据（子任务数据）
   * 页面要展示的是总任务（包含多个子任务的数据），后端要整合数据
   * 问题：例如前端传入pageNo=1,pageSize=10,查询到10条子任务，整合为总任务后，返回前端的数据没有10条
   * @param dto
   * @return
   */
  @ApiOperation(value = "迁移任务列表", notes = "迁移任务列表")
  @RequestMapping(value = {"reassign-tasks/condition"}, method = RequestMethod.POST)
  @ResponseBody
  // 此处的响应还没有改为ReassignCmbTaskVo
  public PaginationResult<ReassignTaskVO> getReassignTasks(@RequestBody ReassignCmbTaskDTO dto){
    return new PaginationResult<>(ReassignModelConverter.convert2ReassignTaskVOList(
        reassignService.getReassignTaskListByCondition(dto)),dto.getPageNo(),dto.getPageSize(),
        reassignService.getReassignTaskList().size());
  }
}
