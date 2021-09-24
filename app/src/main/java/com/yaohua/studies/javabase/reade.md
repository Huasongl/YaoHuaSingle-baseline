# JavaBase

## 序列化与反序列化

- 序列化是将类的信息依据相应的编码规则转换为可存储在磁盘的二进制文件。用于存储数据和传输数据。

### 序列化的应用 

- serializable interface

## 线程池

- 通过ThreadPoolExecutor方法创建
- 常用的BlockingQueue类型
  - SynchronousQueue-同步无限队列
  - LinkedBlockingQueue-有限链式等待队列
  - ArrayBlockingQueue-最大线程数队列
  - DelayQueue-
  
- 常见的线程池
  - CachedThreadPool
  - FixedThreadPool
  - ScheduledThreadPool
  - SingleThreadExecutor
  
- 两种常见的提交方式submit&execute
  - submit 这种提交方式可以使用两种参数callable&runnable
    - 使用callable会有返回值Future
    - runnable的返回值为null
  - execute 无返回值，异常会直接抛出