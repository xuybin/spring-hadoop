# maven打包
```
mvn clean package
```
# maven打包慢或无法下载依赖jar包,可从镜像解压所有依赖包
```
docker run --rm  -v /m2:/m2 registry.cn-shenzhen.aliyuncs.com/xuybin/spring-hadoop-m2
ls  -al /m2
```

