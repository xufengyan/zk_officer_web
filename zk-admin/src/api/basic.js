import request from '@/utils/request'
export function listBasic(query) {
  return request({
    url: '/basic/list',
    method: 'get',
    params: query
  })
}

export function readBasic(data) {
  return request({
    url: '/basic/read' + '/' + data,
    method: 'get',
    data
  })
}

export function editBasic(data) {
  return request({
    url: '/basic/edit',
    method: 'post',
    data
  })
}
