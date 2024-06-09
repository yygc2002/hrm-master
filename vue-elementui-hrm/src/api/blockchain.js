import request from '../utils/request'

const url = '/blockchain'

export const getAll = () => {
  return request({
    url: url + '/findAll'
  })
}
