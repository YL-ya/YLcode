# DIV对话框处理
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.maximize_window()

# 点击click
driver.find_element_by_id("showmodal").click()
time.sleep(5)

# 点击click me
div1 = driver.find_element_by_class_name("modal-body")
div1.find_element_by_link_text("click me").click()
time.sleep(5)

# 关闭alert
div2 = driver.find_element_by_class_name("modal_footer")
div2.find_element_by_class_name("btn").click()
time.sleep(5)

driver.quit()