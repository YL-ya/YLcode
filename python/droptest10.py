# 下拉选项
from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.get(file_path)
driver.maximize_window()

# 通过定位一组元素：
lists = driver.find_element_by_tag_name("option")

# 1:通过循环
# for list in lists:
#     if list.get_attribute('value') == "10.69":
#         list.click()

# 2:因为存放的位置是数组中，所以可以通过下表进行访问
lists[2].click()

# 3:根据xpath定位
driver.find_element_by_xpath("//*[@value='8.34]").click()
driver.quit()