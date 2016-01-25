/******** redis set������� *****/
1.���һ��������Ա��set
SADD key member [member ...]
summary: Add one or more members to a set
since: 1.0.0
127.0.0.1:6379> sadd set1 val1 val2 val3
(integer) 3

2.��ȡһ��set�ĳ�Ա����
SCARD key
summary: Get the number of members in a set
since: 1.0.0
127.0.0.1:6379> scard set1
(integer) 3

3.��ѯ�ڵ�һ��set�е����ں���set�еĳ�Ա��������
SDIFF key [key ...]
summary: Subtract multiple sets
since: 1.0.0
127.0.0.1:6379> SMEMBERS set1
1) "val3"
2) "val4"
3) "val5"
4) "val2"
5) "val1"
127.0.0.1:6379> SMEMBERS set2
1) "val3"
2) "val4"
3) "val2"
127.0.0.1:6379> SDIFF set2 set1
(empty list or set)
127.0.0.1:6379> SDIFF set1 set2
1) "val5"
2) "val1"

4.��ѯkey1�еĳ�Ա������key2�Ⱥ���key�еĳ�Ա��������õĽ������des-key��
SDIFFSTORE des-key key1 [key2 ...]
summary: Subtract multiple sets and store the resulting set in a key
since: 1.0.0
127.0.0.1:6379> SDIFFSTORE set3 set1 set2
(integer) 2
127.0.0.1:6379> SMEMBERS set3
1) "val5"
2) "val1"

5.��ѯset�е��ظ���
SINTER key [key ...]
summary: Intersect multiple sets
since: 1.0.0
127.0.0.1:6379> sinter set1 set2
1) "val3"
2) "val4"
3) "val2"
127.0.0.1:6379> sinter set2 set1
1) "val3"
2) "val4"
3) "val2"

6.��ѯset�е��ظ��������Ŀ��set��
SINTERSTORE des-key key [key ...]
summary: Intersect multiple sets and store the resulting set in a key
since: 1.0.0
127.0.0.1:6379> SINTERSTORE set4 set1 set2
(integer) 3
127.0.0.1:6379> SMEMBERS set4
1) "val3"
2) "val2"
3) "val4"

7.��ѯָ���ĳ�Ա�Ƿ���ָ����key��(�ڷ���1�����ڷ���0)
SISMEMBER key member
summary: Determine if a given value is a member of a set
since: 1.0.0

8.��ѯset�����еĳ�Ա
SMEMBERS key
summary: Get all the members in a set
since: 1.0.0
127.0.0.1:6379> SMEMBERS set4
1) "val3"
2) "val2"
3) "val4"

9.��set�е�һ����Ա��set�Ƶ���һ��set
SMOVE source destination member
summary: Move a member from one set to another
since: 1.0.0
127.0.0.1:6379> smove set4 set3 val3
(integer) 1
127.0.0.1:6379> SMEMBERS set4
1) "val2"
2) "val4"
127.0.0.1:6379> SMEMBERS set3
1) "val3"
2) "val5"
3) "val1"

10.�Ƴ�����������ĳ�Ա
SPOP key
summary: Remove and return a random member from a set
since: 1.0.0
127.0.0.1:6379> SMEMBERS set3
1) "val3"
2) "val5"
3) "val1"
127.0.0.1:6379> spop set3
"val1"
127.0.0.1:6379> SMEMBERS set3
1) "val3"
2) "val5"

11.��ȡһ�����������Ա(countָ����ȡ����Ŀ)
SRANDMEMBER key [count]
summary: Get one or multiple random members from a set
since: 1.0.0
127.0.0.1:6379> SRANDMEMBER set3 2
1) "val3"
2) "val5"

12.�Ƴ�set�е�һ��������Ա
SREM key member [member ...]
summary: Remove one or more members from a set
since: 1.0.0
127.0.0.1:6379> srem set3 val3 val4
(integer) 1  #ֻɾ����val3,val4���������Է���1

13.��Ӷ��sets����ʾ���sets�Ľ�������ظ�
SUNION key [key ...]
summary: Add multiple sets
since: 1.0.0

127.0.0.1:6379> SUNION set3 set4 set1
1) "val3"
2) "val5"
3) "val4"
4) "val2"
5) "val1"

14.���Ӷ��set����������������Ŀ��set��
SUNIONSTORE dest-key key [key ...]
summary: Add multiple sets and store the resulting set in a key
since: 1.0.0

127.0.0.1:6379> SUNIONstore  set6  set3 set4 set1
(integer) 5


