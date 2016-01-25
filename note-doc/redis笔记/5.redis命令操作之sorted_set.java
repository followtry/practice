/***** redis sorted_set ������� ********/
score ��set�����ֵ��Խ��Խ��ǰ
1.��� ��Ա��sorted_set�У�������score
ZADD key score member [score member ...]
summary: Add one or more members to a sorted set, or update its score if it already exists
since: 1.2.0
127.0.0.1:6379> zadd sset1 2 val4
(integer) 1


2. ��ѯsorted_set�ĳ�Ա����
ZCARD key
summary: Get the number of members in a sorted set
since: 1.2.0
127.0.0.1:6379> ZCARD sset1
(integer) 5

3.��ȡscore��min��max֮�������
ZCOUNT key min max
summary: Count the members in a sorted set with scores within the given values
since: 2.0.0
127.0.0.1:6379> ZCOUNT sset1 12 100
(integer) 2
127.0.0.1:6379> ZCOUNT sset1 0 200000
(integer) 5

4.����sorted_set�г�Ա��score
ZINCRBY key increment member
summary: Increment the score of a member in a sorted set
since: 1.2.0
127.0.0.1:6379> ZINCRBY sset1 30 val1
"52"

5.��key1��key2...���ظ���ֵ�ý���浽des-key�У�numkeysΪԴkey������
ZINTERSTORE des-key numkeys key1 [key2 ...] [WEIGHTS weight] [AGGREGATE SUM|MIN|MAX]
summary: Intersect multiple sorted sets and store the resulting sorted set in a new key
since: 2.0.0
127.0.0.1:6379> ZINTERSTORE sset5 2 sset1 sset2
(integer) 3

6.��ȡsorted_set��indexֵ��start��stop֮���ֵ(������ĩֵ)
ZRANGE key start stop [WITHSCORES]
summary: Return a range of members in a sorted set, by index
since: 1.2.0

6.��ȡsorted_set��indexֵ��min ��max֮���ֵ(������ĩֵ)
ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]
summary: Return a range of members in a sorted set, by score
since: 1.0.5
127.0.0.1:6379> ZRANGEBYSCORE sset5 6 11
1) "val4"

7.��ȡ��Ա������λ��
ZRANK key member
summary: Determine the index of a member in a sorted set
since: 2.0.0
127.0.0.1:6379> ZRANK sset5 val3
(integer) 2
127.0.0.1:6379> ZRANGE sset5 0 10
1) "val4"
2) "val2"
3) "val3"

8.��sorted_set ��ɾ��ָ���ĳ�Ա���ɶ����
ZREM key member [member ...]
summary: Remove one or more members from a sorted set
since: 1.2.0

9.ɾ��indexֵ��start��stop֮��ĳ�Ա
ZREMRANGEBYRANK key start stop
summary: Remove all members in a sorted set within the given indexes
since: 2.0.0

10.ɾ��scoreֵ��min��max֮��ĳ�Ա
ZREMRANGEBYSCORE key min max
summary: Remove all members in a sorted set within the given scores
since: 1.2.0

11.����ָ��index��start��stop֮�䣬����score�Ӹߵ��׵�����
ZREVRANGE key start stop [WITHSCORES]
summary: Return a range of members in a sorted set, by index, with scores ordered from high to low
since: 1.2.0
127.0.0.1:6379> ZREVRANGE sset5 0 2
1) "val3"
2) "val2"
3) "val4"

12.����ָ��score��min��max֮�䣬����score�Ӹߵ��׵�����
ZREVRANGEBYSCORE key max min [WITHSCORES] [LIMIT offset count]
summary: Return a range of members in a sorted set, by score, with scores ordered from high to low
since: 2.2.0

13.��ȡ��Ա������λ�ã�����score�Ӹߵ�������
ZREVRANK key member
summary: Determine the index of a member in a sorted set, with scores ordered from high to low
since: 2.0.0

14.��ȡָ����Ա��score
ZSCORE key member
summary: Get the score associated with the given member in a sorted set
since: 1.2.0

127.0.0.1:6379> ZSCORE sset5 val2
"12"

15.��sorted_key��ʾ�����������ʾ����ŵ�Ŀ��key�У�numkeys����Դkey����Ŀ
ZUNIONSTORE des-key numkeys key1 [key2 ...] [WEIGHTS weight] [AGGREGATE SUM|MIN|MAX]
summary: Add multiple sorted sets and store the resulting sorted set in a new key
since: 2.0.0




