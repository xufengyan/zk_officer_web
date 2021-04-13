import request from '@/utils/request'
export function listDownload(query) {
  return request({
    url: '/download/list',
    method: 'get',
    params: query
  })
}

export function createDownload(data) {
  return request({
    url: '/download/add',
    method: 'post',
    data
  })
}

export function editDownload(data) {
  return request({
    url: '/download/edit',
    method: 'post',
    data
  })
}
