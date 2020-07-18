# 当有多层框架套用的时候的操作：
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()

file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.get(file_path)

driver.maximize_window()

# 从默认页面跳转到frame1
# 因为f2是放在f1中
driver.switch_to.frame("f1")
driver.switch_to.frame("f2")

driver.find_element_by_id("kw").send_keys("西藏")
driver.find_element_by_id("su").click()
time.sleep(7)


# click是存放在法f1中的，是不能直接进行跳转，必须先跳转到默认页面
driver.switch_to.default_content()
driver.switch_to.frame("f1")
driver.find_element_by_link_text("click").click()
time.sleep(8)
driver.quit()


