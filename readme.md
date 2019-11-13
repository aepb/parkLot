Task:

|         GIVE       |WHEN                          |THEN                         |
|----------------|-------------------------------|-----------------------------|
|空的停车场+一辆车|停车|可以停车，获得对应车的停车票|
|没有车位的停车场+一辆车|停车|不能停车|
|停了A车的停车场+A车停车票|取车|能取到A车|
|停车场+无效的停车票|取车|不能取车|

|给一个非正数|构造停车场|构造失败|

需求：
1. 大小限制>0
1. 超出限制提示
1. One by One 停/取车
1. 一辆车只能停/取一次
1. 停车票标识
1. 停车票只能用一次
1. 停车票使用一次后失效



**能够将车顺序停放到多个停车场**

先把第一个停车场停满，再停第二个停车场

A->B->C


Graduate

最少管理一个停车场

初始化时Graduate和停车场的关系

