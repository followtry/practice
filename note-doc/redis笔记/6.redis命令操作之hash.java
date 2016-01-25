/*********redis hash������� **********/
1.ɾ��һ������hash��
HDEL key field [field ...]
summary: Delete one or more hash fields
since: 2.0.0
127.0.0.1:6379> HDEL hash1 name
(integer) 1


2.�ж�һ�����Ƿ����
HEXISTS key field
summary: Determine if a hash field exists
since: 2.0.0
127.0.0.1:6379> HEXISTS hash1 name
(integer) 0 #�����ڷ���0
127.0.0.1:6379> HEXISTS hash1 name2
(integer) 1 #���ڷ���1


3.��ȡһ��hash��
HGET key field
summary: Get the value of a hash field
since: 2.0.0
127.0.0.1:6379> HGET hash1 name2
"name22"

4.��ȡhash�����е����ֵ
HGETALL key
summary: Get all the fields and values in a hash
since: 2.0.0
127.0.0.1:6379> HGETALL hash1
1) "name"  #field��
2) "jing"  #valueֵ
3) "name2" #field��
4) "jing2" #valueֵ
5) "name3" #field��
6) "jing3" #valueֵ



5.�������ֵ(�����int��)������increment
HINCRBY key field increment
summary: Increment the integer value of a hash field by the given number
since: 2.0.0

6.�������ֵ(float��),����increment
HINCRBYFLOAT key field increment
summary: Increment the float value of a hash field by the given amount
since: 2.6.0
127.0.0.1:6379> HSET hash1 num1 10
(integer) 1
127.0.0.1:6379> HINCRBY hash1 num1 2
(integer) 12

7.��ȡhash��������
HKEYS key
summary: Get all the fields in a hash
since: 2.0.0
127.0.0.1:6379> HKEYS hash1
1) "name2"
2) "name3"
3) "num1"


8.��ȡhash���������
HLEN key
summary: Get the number of fields in a hash
since: 2.0.0
127.0.0.1:6379> HLEN hash1
(integer) 3



9.��ȡ���и������ֵ
HMGET key field [field ...]
summary: Get the values of all the given hash fields
since: 2.0.0
127.0.0.1:6379> HMGET hash1 name2 num1
1) "name22"
2) "12"


10.���ö��hash���Ӧ���hashֵ
HMSET key field value [field value ...]
summary: Set multiple hash fields to multiple values
since: 2.0.0
127.0.0.1:6379> HMSET hash1 num2 12 name4 jing4 num3 33
OK
127.0.0.1:6379> HGETALL hash1
 1) "name2"
 2) "name22"
 3) "name3"
 4) "name33"
 5) "num1"
 6) "12"
 7) "num2"
 8) "12"
 9) "name4"
10) "jing4"
11) "num3"
12) "33"


11.����hash����ַ���ֵ
HSET key field value
summary: Set the string value of a hash field
since: 2.0.0

12.ֻ�е����򲻴���ʱ������hash�����ֵ
HSETNX key field value
summary: Set the value of a hash field, only if the field does not exist
since: 2.0.0

13.��ȡhash������ֵ
HVALS key
summary: Get all the values in a hash
since: 2.0.0

127.0.0.1:6379> HVALS hash1
1) "name22"
2) "name33"
3) "12"
4) "12"
5) "jing4"
6) "33"
