# bpmn-flowable-server

| 方法 | 接口                  | 说明                             | 例子                                                                   |
| ---- | --------------------- | -------------------------------- | ---------------------------------------------------------------------- |
| GET  | /actuator/flowable    |                                  | http://localhost:9030/bpmn-flowable/actuator/flowable                  |
| GET  | /actuator/info        |                                  |                                                                        |
| *    | /process-api/*        | Flowable BPMN Rest API           | http://localhost:9030/bpmn-flowable/process-api/repository/deployments |
| *    | /external-job-api/*   | Flowable External Job Rest API   |                                                                        |
| *    | /idm-api/*            | Flowable IDM Rest API            |                                                                        |
| *    | /form-api/*           | Flowable Form Rest API           |                                                                        |
| *    | /event-registry-api/* | Flowable Event Registry Rest API |                                                                        |
| *    | /dmn-api/*            | Flowable DMN Rest API            |                                                                        |
| *    | /content-api/*        | Flowable Content Rest API        |                                                                        |
| *    | /cmmn-api/*           | Flowable CMMN Rest API           |                                                                        |
| *    | /app-api/*            | Flowable App Rest API            |                                                                        |

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
docker run -p 9030:9030 --link mysql:mysql --name bpmn-flowable-server -d registry.cn-hangzhou.aliyuncs.com/beidou/bpmn-flowable-server-6.7.2.jar
```