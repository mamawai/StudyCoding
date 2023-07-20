Feature: 使用chrome浏览器访问百度搜索柠檬班论坛

  Background:


#  Scenario: 百度搜索testingpai
#    Given 打开百度搜索
#    When 输入 "testingpai"
#    Then 显示 "测试派"
  Scenario: 读取json文件测试
    Given 获取json文件:"A.json"
    Then 输出文件内容
