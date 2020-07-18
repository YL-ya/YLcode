# 上传文件
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()

# 获取html的url
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.get(file_path)
time.sleep(3)
driver.find_element_by_name("file").send_keys("e:/python.txt")

time.sleep(5)
driver.quit()