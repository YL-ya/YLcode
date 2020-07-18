# 多层窗口定位
from selenium import webdriver
import time
import os

from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("e:/login.html")
driver.get(file_path)

driver.find_element_by_link_text("link1").click()
element = driver.find_element_by_link_text("Another action")
ActionChains(driver).move_to_element(element).perform()

time.sleep(10)
driver.quit()
