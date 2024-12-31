# 카프카

카프카 주키퍼 없이 Kraft로만 운용

## run_workaround.sh

```
#!/bin/sh

sed -i '/KAFKA_ZOOKEEPER_CONNECT/d' /etc/confluent/docker/configure

sed -i 's/cub zk-ready/echo ignore zk-ready/' /etc/confluent/docker/ensure

echo "kafka-storage format --ignore-formatted -t NqnEdODVKkiLTfJvqd1uqQ== -c /etc/kafka/kafka.properties" >> /etc/confluent/docker/ensure
```

1. ZOOKEEPER 연결 안하도록 설정
2. zk-ready 예외 무시하기
3. KRaft 필스, 디렉토리 포맷 지정 (16 바이트, base64-encoded UUID.)


### 1. 토픽 생성
```
cheonkyu@cheonkyuui-MacBookPro kafka-springboot % docker exec -it kafka1 /bin/bash
[appuser@59152579ee80 ~]$ kafka-topics --bootstrap-server kafka1:9092 --create --topic exampleTopic
Created topic exampleTopic.
[appuser@59152579ee80 ~]$ 
```

### 2. 프로듀서 
```
cheonkyu@cheonkyuui-MacBookPro kafka-springboot % docker exec -it kafka2 /bin/bash
[appuser@f77c86cdd309 ~]$ kafka-console-producer --bootstrap-server kafka2:9092 --topic exampleTopic
>codersee
>rules
```

### 3. 컨슈머
```
cheonkyu@cheonkyuui-MacBookPro kafka-springboot % docker exec -it kafka3 /bin/bash
[appuser@10b140836ece ~]$ kafka-console-consumer --bootstrap-server kafka3:9092 --topic exampleTopic --from-beginning
codersee
rules
```

# Reference

https://codersee.com/how-to-set-up-kafka-without-zookeeper-using-docker-compose/