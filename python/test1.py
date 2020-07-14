from selenium import webdriver
import time
diver=webdriver.Chrome();
diver.get("https://www.baidu.com/")
diver.maximize_window()
diver.find_element_by_link_text("新闻").click()
time.sleep(6)
diver.quit()