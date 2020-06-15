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







 Spring Cloud Gateway根据作用范围划分为GatewayFilter和GlobalFilter，先调用GatewayFilter（按照配置的顺序调用），再调用globalFilter，二者区别如下：
      GatewayFilter : 需要通过spring.cloud.routes.filters 配置在具体路由下，只作用在当前路由上或通过spring.cloud.default-filters配置在全局，作用在所有路由上
            继承抽象类
                AbstractNameValueGatewayFilterFactory：是AbstractGatewayFilterFactory的其中一个抽象子类，重点在于其泛型Config类是一个键值对类型的，被若干个键值对配置的子类继承，如AddRequestHeaderGatewayFilterFactory等。
                AbstractChangeRequestUriGatewayFilterFactory：是AbstractGatewayFilterFactory的另一个抽象子类，泛型参数与AbstractGatewayFilterFactory一致，只有一个参数名，实现类目前只有RequestHeaderToRequestUriGatewayFilterFactory。
            常用过滤器
                AddRequestHeaderGatewayFilterFactory：在request header中添加一个键值对的header参数。
                AddRequestParameterGatewayFilterFactory：在request query参数列表中添加一个查询参数。
                AddResponseHeaderGatewayFilterFactory：在response header中添加一个键值对的header参数。
                DedupeResponseHeaderGatewayFilterFactory：删除response header中重复的数据项，分别有三种数据保留策略。
                HystrixGatewayFilterFactory：熔断器，集成了Netflix开源的Hystrix框架熔断功能，为了避免服务在故障时引发级联故障，通过Hystrix允许下游服务故障时提供熔断返回或者请求转发操作；主要转发逻辑在RouteHystrixCommand中的resumeWithFallback函数中。
                PrefixPathGatewayFilterFactory：为请求的Uri添加一个前缀路径，Restful Api经常以/api作为规范开头路径，则可以为客户端自动添加此规范，客户端则无需遵循此规范。
                PreserveHostHeaderGatewayFilterFactory：此过滤器没有参数，配置一个声明属性即可，标明时候对请求Host进行验证，验证操作不发生于此过滤器中。
                RedirectToGatewayFilterFactory：将配置所指定的域名请求重定向至所配置地址，并设置当前请求状态码为3XX。
                RemoveRequestHeaderGatewayFilterFactory：这个与AddRequestHeaderGatewayFilterFactory呼应，只不过是删除request header中指定的header参数。
                RemoveResponseHeaderGatewayFilterFactory：与AddResponseHeaderGatewayFilterFactory呼应，删除response header中的指定参数。
                RequestHeaderToRequestUriGatewayFilterFactory：需要一个NameConfig参数（需要通过此参数在header中获取header属性值），只需要在配置文件中声明开启，前提需要在request header中存在配置参数名的header属性存在；将当前请求的Uri替换成header中指定的Uri；注意这个工厂类的apply方法在父类中，自身只重写了determineRequestUri方法。
                RequestRateLimiterGatewayFilterFactory：流量限制过滤器，这个实现比较复杂的，基于redis + lua script实现的。
                RequestSizeGatewayFilterFactory：限制请求体的大小，默认是5M；这个工厂类也是在2.0.2版本之后加入的。
                RetryGatewayFilterFactory：重试机制，可以配置指定重试的错误级别和方法类型。
                RewritePathGatewayFilterFactory：重写请求的Uri，配置参数需要遵循正则表达式的规则。
                RewriteResponseHeaderGatewayFilterFactory：重写response中指定的header参数。
                SaveSessionGatewayFilterFactory：缓存当前请求的Session，调用Web Server的方法缓存，这里是Http Server的动作。
                SecureHeadersGatewayFilterFactory：为request header添加若干属性。
                SetPathGatewayFilterFactory：替换Path断言中的路径。
                SetRequestHeaderGatewayFilterFactory：与AddRequestHeaderGatewayFilterFactory功能相似，一个是全局替换，一个是追加，某种情况下作用一致。
                SetResponseHeaderGatewayFilterFactory：与AddResponseHeaderGatewayFilterFactory功能相似，这里是设置，而AddResponseHeaderGatewayFilterFactory中是往已存在的header属性集合中添加，当header属性为空时两个作用是一样的。
                SetStatusGatewayFilterFactory：根据配置设置请求的返回状态。
                StripPrefixGatewayFilterFactory：这个与PrefixPathGatewayFilterFactory类似，只不过是按照配置截掉Uri的部分path。
      GlobalFilter : 全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上。
      
return exchange.getResponse().setComplete();过滤器就不会再往下在，可以在这里验证登陆不成功后，在response加入标记，直接返回前端，前端跳转到登陆
