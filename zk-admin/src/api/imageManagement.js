import request from '@/utils/request'
export function listImageManagement(query) {
  return request({
    url: '/management/list',
    method: 'get',
    params: query
  })
}

export function createImageManagement(data) {
  return request({
    url: '/management/add',
    method: 'post',
    data
  })
}

export function editImageManagement(data) {
  return request({
    url: '/management/edit',
    method: 'post',
    data
  })
}

export function delImageManagement(data) {
  return request({
    url: '/management/remove/' + data,
    method: 'get'
  })
}
