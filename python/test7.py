# 定位一组元素
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:\login.html")
driver.get(file_path)
driver.maximize_window()

# 定位一组元素：利用循环就可以了
inputs = driver.find_element_by_tag_name("input")
time.sleep(6)
for input in inputs:
    if input.get_atrribute('type') == "checkbox":
        input.click()
time.sleep(6)
driver.quit()