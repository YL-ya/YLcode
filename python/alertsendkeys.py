# 如果弹出框中进行输入的话
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.maximize_window()

# 1：先定位点击按钮
# 用tag_name进行定位，因为input的控件是唯一的
driver.find_element_by_tag_name("input").click()
time.sleep(6)
# 2：得到操作的alert句柄
alert = driver.switch_to.alert()

# 3：给弹出框输入内容
alert.send_keys("java")
time.sleep(3)

# 4：点击确认并关闭弹框
alert.accept()
time.sleep(6)
driver.quit()
