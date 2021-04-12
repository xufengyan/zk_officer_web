import request from '@/utils/request'

export function listCategory(query) {
  return request({
    url: '/category/list',
    method: 'get',
    params: query
  })
}

export function listCatL1() {
  return request({
    url: '/category/l1',
    method: 'get'
  })
}

export function createCategory(data) {
  return request({
    url: '/category/add',
    method: 'post',
    data
  })
}

export function readCategory(data) {
  return request({
    url: '/category/read',
    method: 'get',
    data
  })
}

export function editCategory(data) {
  return request({
    url: '/category/edit',
    method: 'post',
    data
  })
}

export function deleteCategory(data) {
  return request({
    url: '/category/delete',
    method: 'post',
    data
  })
}
