# webdriver api的使用
from selenium import webdriver
import time

driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
# # 1：清除内容：clear()
# driver.find_element_by_id("kw").send_keys("权志龙")
# driver.find_element_by_id("su").click()
# time.sleep(6)
# driver.find_element_by_id("kw").clear()
# time.sleep(3)
# driver.find_element_by_id("kw").send_keys("太阳")
# driver.find_element_by_id("su").click()
# driver.find_element_by_id("su").submit()跟click的功能是一样的
# time.sleep(8)

# # 2：读取文本信息
# context = driver.find_element_by_link_text("新闻").text
# print(context)

# # # 3：固定等待和智能等待
# driver.find_element_by_id("kw").send_keys("权志龙")
# driver.find_element_by_id("su").click()
# # 固定等待在级联点击的时候，是比较浪费时间的，因为由于页面么有加载完成的时候进行点击是无法进行点击的
# # time.sleep(30)
#
# # 智能等待，当页面加载完成之后显示出即可进行跳转
# driver.implicitly_wait(10)
# driver.find_element_by_link_text(u"权志龙_百度百科").click()

# # # # 4：title
driver.find_element_by_id("kw").send_keys("权志龙")
title1 = driver.title
print("title1="+title1)
driver.find_element_by_id("su").click()
driver.implicitly_wait(10)
driver.find_element_by_link_text(u"权志龙_百度百科").click()

# title输出的是上一个title和上一个url
title2 = driver.title
print("title2="+title2)


url = driver.current_url
print(url)
time.sleep(8)
driver.quit()