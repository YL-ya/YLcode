# 将测试用例放进容器中(套件)
import unittest
from src import unittest13
def createsuite():
    # 1：先把testSuite容器创建好
    suite = unittest.TestSuite()

    # 2：将测试用例加入到容器去(套件)
    # 2.1：这个是每个类里面的添加每一个方法(如果写的方法太多的话，不太适用于这个添加方法)
    suite.addTest(unittest13.Baidui1("test_baidusearch"))
    return suite

    # 2.2：以类为单位进行测试：类中的所有的测试方法都能够运行
    suite.addTest(unittest.makeSuite(unittest13.Baidui1))
    return suite

    # 2.3：也是以类为单位进行测试
    suite1 = unittest.TestLoader().loadTestsFromTestCase(unittest13.Baidui1)
    suite = unittest.TestSuite(suite1)
    return suite

    # 2.4：把一种形式的所有文件全部加载执行
    dicovers = unittest.defaultTestLoader.discover("../src", pattern="Baidu*.py", top_level_dir=None)
    return dicovers


if _name_== "_main_":
    # 得到测试套件
    suite = createsuite()
    # 1：只打印那个测试用例(正确(.) F)通过；2：可以打印出详细信息
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)