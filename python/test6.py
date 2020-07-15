# 鼠标事件
from selenium import webdriver
import time

from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.maximize_window()
driver.find_element_by_id("kw").send_keys("权志龙")
su1 = driver.find_element_by_id("su")

# 右击
ActionChains(driver).context_click(su1).perform()

time.sleep(6)

# 双击
ActionChains(driver).double_click(su1).perform()
time.sleep(10)

title = driver.find_element_by_id("su")
target = driver.find_element_by_link_text("权志龙_百度百科")
# 拖动
ActionChains(driver).drag_and_drop(title, target).perform()

# 移动
ActionChains(driver).move_to_element(target).perform()
driver.quit()

