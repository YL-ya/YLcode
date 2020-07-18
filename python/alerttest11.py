# 出现弹框信息，如果不点击的话，页面上的所有东西都没有办法点击
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.get(file_path)
driver.maximize_window()

# 点击之后会弹出弹出框
driver.find_element_by_id("tooltip").click()
time.sleep(6)

# 得到弹出框的句柄
alert = driver.switch_to.alert()

# 弹出框的东西打印到控制台中(打印弹出框的内容)
print("text"+alert.text)

# 关闭弹出框，点击的是确认按钮
alert.accept()
time.sleep(6)
driver.quit()