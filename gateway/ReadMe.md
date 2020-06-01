    #时间转发
spring.cloud.gateway.discovery.locator.predicates=- After=2017-01-20T17:42:47.789-07:00[America/Denver]
 #特定请求头
 - Header=X-Request-Id, \d+
 #匹配路径转发
- Path=/foo/{segment}
 #需要一个参数即hostname
 - Host=**.123.com
 - Method=GET
 #一个参数名和一个参数值的正则表达式
- Query=foo, ba.
spring.cloud.nacos.discovery.ip=47.97.215.217
spring.cloud.nacos.discovery.port=8848







 Spring Cloud Gateway根据作用范围划分为GatewayFilter和GlobalFilter，二者区别如下：
      GatewayFilter : 需要通过spring.cloud.routes.filters 配置在具体路由下，只作用在当前路由上或通过spring.cloud.default-filters配置在全局，作用在所有路由上
      GlobalFilter : 全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上。
