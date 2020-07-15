# 浏览器的操作
from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")

# driver.find_element_by_id("kw").send_keys("太阳")
# driver.find_element_by_id("su").click()
# # 1：浏览器的放大，也就是全屏
# driver.maximize_window()
# time.sleep(8)
#
# # 2：设置浏览器的宽和高
# driver.set_window_size(400, 400)
# time.sleep(6)

# # # 3：浏览器的前进和后退
# driver.maximize_window()
# driver.find_element_by_id("kw").send_keys("浏览器")
# driver.find_element_by_id("su").submit()
# time.sleep(6)
# driver.back()
# time.sleep(10)
# driver.forward()

# # # # 4：浏览器的滚动条拖到最低/最顶端：
# driver.find_element_by_id("kw").send_keys("哪吒")
# driver.find_element_by_id("su").submit()
# driver.maximize_window()
# time.sleep(5)
# # 低端
# js = "var q=document.documentElement.scrollTop=100000"
# driver.execute_script(js)
# time.sleep(5)
#
# # 顶端
# js = "var q=document.documentElement.scrollTop=0"
# driver.execute_script(js)
#
# driver.set_window_size(400, 800)

# # # # 5：同时可以设置左右，上下控制
# js = "window.scrollTo(200,200);"
# driver.execute_script(js)

# 6：键盘的的组合使用
driver.find_element_by_id("kw").send_keys("哪吒")
driver.find_element_by_id("su").click()
driver.implicitly_wait(10)

# 全选
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')

# 剪切
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'x')
time.sleep(4)
driver.find_element_by_id("kw").send_keys("敖丙")
driver.find_element_by_id("kw").click()
time.sleep(6)
driver.quit()