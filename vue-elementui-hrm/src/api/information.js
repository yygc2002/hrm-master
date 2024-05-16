import request from '../utils/request'
import {date} from "mockjs/src/mock/random/date";

const url = '/information'

export const getOne = (id) => {
  return request({
    url: url + '/detail' + '/' + id
  })
}

export const save = (data) => {
  return request({
    url: url + '/detail/save',
    method: 'post',
    data: data
  })
}

export const getWorkExperience = (id) => {
  return request({
    url: url + '/experience' + '/' + id
  })
}

export const saveWorkExperience = (data) => {
  return request({
    url: url + '/experience/save',
    method: 'post',
    data: data
  })
}

export const addWorkExperience = (date) => {
  return request({
    url: url + '/experience/add',
    method: 'post',
    data: date
  })
}

export const deleteWorkExperience = (id) => {
  return request({
    url: url + '/experience' + '/delete/' + id,
    method: 'get'
  })
}

export const getWorkingExperience = (id) => {
  return request({
    url: url + '/experience' + '/getWorkingExperience/' + id
  })
}

export const addWorkingExperience = (date) => {
  return request({
    url: url + '/experience/addWorkingExperience',
    method: 'post',
    data: date
  })
}

export const saveWorkingExperience = (date) => {
  return request(({
    url: url + '/experience' + '/saveWorkingExperience',
    method: 'post',
    data: date
  }))
}

export const deleteWorkingExperience = (id) => {
  return request({
    url: url + '/experience' + '/deleteWorkingExperience/' + id,
    method: 'get'
  })
}
