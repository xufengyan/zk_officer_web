import request from '@/utils/request'
export function listScheme(query) {
  return request({
    url: '/scheme/list',
    method: 'get',
    params: query
  })
}
export function createScheme(data) {
  return request({
    url: '/scheme/add',
    method: 'post',
    data
  })
}
export function readScheme(data) {
  return request({
    url: '/scheme/read/' + data,
    method: 'get'
  })
}

export function editScheme(data) {
  return request({
    url: '/scheme/edit',
    method: 'post',
    data
  })
}

