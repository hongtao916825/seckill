@HystrixCommand
    fallbackMethod
    threadPoolKey：线程设定，细粒度配置，相当于对单个服务的线程池信息进行设置，也可多个服务设置同一个
    groupKey：全局唯一标识服务分组，用于组织统计命令告警、仪表盘等信息，默认的线程划分也是根据命令组来实现
            默认情况下，Hystrix会让相同组名的命令使用同一个线程池
    commandKey:全局唯一标识服务名称，默认是函数名
    commandProperties：配置该命令的一些参数