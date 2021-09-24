# 异常捕获

## 简述

```
try
catch
finally
```

- Throwable
  - Exception
    - RuntimeException-check exception
    - OtherException-uncheck exception
  - Error-uncheck exception


## JVM处理异常简述

### try-catch-finally的处理

- 生成异常表条目
  - form-字节码对应try块开始的地址
  - to-try块结束的地址（不包含）
  - target-异常类型
- 编码
  - 将finally块的代码复制到try-catch的出口。

