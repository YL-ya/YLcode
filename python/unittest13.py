from selenium import webdriver
import unittest
import time

# 创建类并继承
class Baidui1(unittest.TestCase):

    # 测试固件：setUp tearDown方法
    # 不管代码放在那里，setUp是第一个运行，tearDown是最后一个运行
    def setUp(self):
        self.driver =webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "https://www.baidu.com/"
        self.driver.maximize_window()
        self.verificationErrors = []
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()
        self.assertAlmostEqual([],self.verificationErrors)

    # 在写单元测试的时候必须以test_开头
    def test_baidusearch(self):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("su").send_keys("权志龙")
        driver.find_element_by_id()