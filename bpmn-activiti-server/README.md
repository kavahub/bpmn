# bpmn-activiti-server

#### 打包

编译，测试，打包：

```
mvn clean install spring-boot:repackage
```

#### 运行

``` 
mvn spring-boot:run
```

#### 阿里云镜像服务
阿里云提供个人的，免费的镜像服务。开通服务，在本机上运行
```
docker login --username=<阿里云账号> registry.cn-hangzhou.aliyuncs.com
```

然后运行命令
```
mvn compile jib:build -Pali-docker 
```

命令成功运行后，在阿里云镜像服务中可以查询到

本地拉取并运行镜像
```
docker run -p 9030:9030 --link mysql:mysql --name bpmn-activiti-server -d registry.cn-hangzhou.aliyuncs.com/beidou/bpmn-activiti-server-7.2.0.java
```