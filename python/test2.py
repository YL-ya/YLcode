from selenium import webdriver
import time
# 获取谷歌浏览器的驱动
driver=webdriver.Chrome()

# 支配浏览器，打开百度
driver.get("https://www.baidu.com/")

# 设置窗口的大小
driver.maximize_window()

# 以下是定位的方法
# 1：在百度的输入框中输入关键字
# driver.find_element_by_id("kw").send_keys("白夜追凶")

# 点击搜索一下
# driver.find_element_by_id("su").click()

# 2：根据链接进行点击
# driver.find_element_by_link_text("hao123").click()

# 3：根据部分汉字进行定位
# driver.find_element_by_partial_link_text("新").click()

# 4：根据类型进行定位
# driver.find_element_by_tag_name("input").send_keys("端午节").click()

# 5：万能定位：xpath
driver.find_element_by_xpath("//*[@id='kw']").send_keys("水涨船高")
driver.find_element_by_xpath("//*[@id='su']").click()
# 固定暂停8秒
time.sleep(8)

# 关闭浏览器(quit可以释放资源，但是close不可以)，不然运行一个脚本就会开启一个浏览器的界面
driver.quit()