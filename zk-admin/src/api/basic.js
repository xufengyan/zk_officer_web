import request from '@/utils/request'
export function listBasic(query) {
  return request({
    url: '/basic/list',
    method: 'get',
    params: query
  })
}
