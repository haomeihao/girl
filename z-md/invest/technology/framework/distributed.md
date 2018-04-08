#### technology framework distributed

``` 
任何一个分布式系统都无法同时满足一致性（Consistency）、可用性（Availability）
和分区容错性（Partition tolerance），最多只能同时满足两项。
在互联网领域的绝大多数的场景中，都需要牺牲强一致性来换取系统的高可用性，
系统往往只需要保证“最终一致性”，只要这个最终时间是在用户可以接受的范围内即可。
```

- distributed transaction

- distributed lock
``` 
基于数据库实现分布式锁 
基于缓存实现分布式锁 
基于Zookeeper实现分布式锁

从理解的难易程度角度（从低到高）
数据库 > 缓存 > Zookeeper

从实现的复杂性角度（从低到高）
Zookeeper >= 缓存 > 数据库

从性能角度（从高到低）
缓存 > Zookeeper >= 数据库

从可靠性角度（从高到低）
Zookeeper > 缓存 > 数据库

综合：
更在意可靠性：Zookeeper
更在意性能：缓存
```
