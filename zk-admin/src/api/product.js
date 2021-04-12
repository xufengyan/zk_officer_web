import request from '@/utils/request'
export function listProduct(query) {
  return request({
    url: '/product/list',
    method: 'get',
    params: query
  })
}

export function createProduct(data) {
  return request({
    url: '/product/add',
    method: 'post',
    data
  })
}

export function readProduct(data) {
  return request({
    url: '/product/read/' + data,
    method: 'get'
  })
}

export function editProduct(data) {
  return request({
    url: '/product/edit',
    method: 'post',
    data
  })
}
