# 键盘事件
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time
import os

from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
driver.get("http://127.0.0.1:88/biz/user-login-L2Jpei8=.html")
driver.implicitly_wait(10)

# 1：模拟tab键
driver.find_element_by_id("account").send_keys("admin")
time.sleep(5)
driver.find_element_by_id("account").send_keys(Keys.TAB)
time.sleep(3)
driver.find_element_by_name("password").send_keys("123")
# driver.find_element_by_id("submit").click()
# 或者使用键盘的enter键
driver.find_element_by_name("password").send_keys(Keys.ENTER)
time.sleep(6)
driver.quit()