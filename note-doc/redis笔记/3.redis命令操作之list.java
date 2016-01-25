/*******  redis list������� **********/
1.��ֵ׷�ӵ��б�
RPUSH key value [value ...]
summary: Append one or multiple values to a list
since: 1.0.0
127.0.0.1:6379> RPUSH mylist value1 value2 value3
(integer) 3

2.��ȡ�б�ĳ���
LLEN key
summary: Get the length of a list
since: 1.0.0

127.0.0.1:6379> llen mylist
(integer) 3

3.��ȡ���Ƴ��б��е�һ��Ԫ��
BLPOP key [key ...] timeout
summary: Remove and get the first element in a list, or block until one is available
since: 2.0.0

127.0.0.1:6379> blpop mylist 3
1) "mylist" ##�б�key
2) "value1" #�б�ǰ��һ��ֵ
127.0.0.1:6379> blpop mylist 3
1) "mylist"
2) "value2"
127.0.0.1:6379> blpop mylist 3
1) "mylist"
2) "value3"
127.0.0.1:6379> blpop mylist 3 �б��Ѿ�������value

(nil)
(3.78s)

4.��ȡ���Ƴ��б��е����һ��Ԫ��
BRPOP key [key ...] timeout
summary: Remove and get the last element in a list, or block until one is available
since: 2.0.0
127.0.0.1:6379> brpop list1 3
1) "list1" #�б����
2) "value3" #�б����һ��ֵ

5.��ջlist�е�һ��value����������һ��list�У������ظ�ֵ
BRPOPLPUSH source destination timeout
summary: Pop a value from a list, push it to another list and return it; or block until one is available
since: 2.2.0

127.0.0.1:6379> BRPOPLPUSH list1 list2 3
"value2"

6.��ȡָ��λ�õ�valueֵ�����ص��Ǹ�λ�õ�ֵ����ֵ�򳬳��߽緵��nil
LINDEX key index
summary: Get an element from a list by its index
since: 1.0.0

7.���б�һ��Ԫ�ص�֮ǰ��֮�����һ��Ԫ�أ����ص�ǰ�б�ĳ���
LINSERT key BEFORE|AFTER pivot value
summary: Insert an element before or after another element in a list
since: 2.2.0
127.0.0.1:6379> linsert ml before v2 value2
(integer) 5  ��v2֮ǰ����ֵvalue2

8.ջ��Ԫ�س�ջ
LPOP key
summary: Remove and get the first element in a list
since: 1.0.0
127.0.0.1:6379> lpop ml
"v1"

9.��list�����һ������value��������ֵ��index��ǰ(��Ԫ��ѹ��ջ��)
LPUSH key value [value ...]
summary: Prepend one or multiple values to a list
since: 1.0.0
127.0.0.1:6379> lpush list2 val1 val2 val3 val4 val5
(integer) 6
127.0.0.1:6379> lindex list2 0
"val5"

10.ֻ�е��б����ʱ���Ŵ�ջ��ѹ��Ԫ��
LPUSHX key value
summary: Prepend a value to a list, only if the list exists
since: 2.2.0

11.��ȡָ����Χ��list��valueֵ
LRANGE key start stop
summary: Get a range of elements from a list
since: 1.0.0

12.���б����Ƴ�Ԫ��(��list�д��ڶ���ظ���ֵʱ��countȷ��Ҫ�Ƴ�����value)
LREM key count value
summary: Remove elements from a list
since: 1.0.0

13.ͨ��Ԫ�ص�����index����value
LSET key index value
summary: Set the value of an element in a list by its index
since: 1.0.0
127.0.0.1:6379> lset list2 3 namew #�޸ĵ�����λ�õ�ֵ
OK

14. 
LTRIM key start stop
summary: Trim a list to the specified range
since: 1.0.0

15.�Ƴ�����ȡ�б��е����һ��Ԫ��
RPOP key
summary: Remove and get the last element in a list
since: 1.0.0

16.�Ƴ��б��е����һ��Ԫ�أ�׷�ӵ���һ���б��У������ظ�ֵ
RPOPLPUSH source destination
summary: Remove the last element in a list, append it to another list and return it
since: 1.2.0


17.��ֵ׷�ӵ��б��У�ֻ�е�����б��Ѿ�����
RPUSHX key value
summary: Append a value to a list, only if the list exists
since: 2.2.0









