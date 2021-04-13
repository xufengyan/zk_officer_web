import request from '@/utils/request'
export function listParagraph(query) {
  return request({
    url: '/paragraph/list',
    method: 'get',
    params: query
  })
}

export function createParagraph(data) {
  return request({
    url: '/paragraph/add',
    method: 'post',
    data
  })
}

export function editParagraph(data) {
  return request({
    url: '/paragraph/edit',
    method: 'post',
    data
  })
}
