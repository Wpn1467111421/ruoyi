import request from '@/utils/request'

// 查询参数列表
export function listConfig(query) {
  return request({
    url: '/system/log/list',
    method: 'get',
    params: query
  })
}

// 查询参数详细
export function getConfig(logId) {
  return request({
    url: '/system/log/' + logId,
    method: 'get'
  })
}


// 新增参数配置
export function addConfig(data) {
  return request({
    url: '/system/log/add',
    method: 'post',
    data: data
  })
}

// 修改参数配置
export function updateConfig(data) {
  return request({
    url: '/system/log/edit',
    method: 'put',
    data: data
  })
}

// 删除参数配置
export function delConfig(logId) {
  return request({
    url: '/system/log/' + logId,
    method: 'delete'
  })
}

