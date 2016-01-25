/********  redis һ��������� ************/
redis�Ǽ�ֵ�Ե��ڴ����ݿ⣬����Nosql����
��¼redis�Դ��Ŀͻ���
#redis-cli
127.0.0.1:6379>
1.����redis ��ֵ��
> set foo bar  #���ü�foo��ֵΪ"bar"
OK #���óɹ�

2.���redis ��ֵ��
> get foo #���ݼ����ֵ
"bar" #���صĽ��

3.ɾ����ֵ�� 
127.0.0.1:6379> del foo foo2 foo3 #ɾ����ֵ�ԣ���ɾ�����
(integer) 3 #ɾ���ɹ��ļ�ֵ�Եĸ���

4.���ؿ�
127.0.0.1:6379> get foo #�����ֵ�Բ����ڣ�����nil
(nil)

5.�жϼ�ֵ���Ƿ���ڣ�����0�������ڣ�����1�����ڣ�ֻ�ܲ�ѯһ������

127.0.0.1:6379> EXISTS foo
(integer) 0
127.0.0.1:6379> set foo bar
OK
127.0.0.1:6379> EXISTS foo
(integer) 1
127.0.0.1:6379> EXISTS foo foo2 foo3
(error) ERR wrong number of arguments for 'exists' command

6.���ü�ֵ����Ч��
127.0.0.1:6379> EXPIRE foo 32 #����foo����Ч��Ϊ32��
(integer) 1

7.���ݼ��ı��ʽ�����ҷ��ϱ��ʽ�ļ�
127.0.0.1:6379> keys foo*
1) "foo3"
2) "foo2"
3) "foo"

8.�Զ���һ��key��һ��redisʵ�����䵽��һ��	
MIGRATE host port key destination-db timeout
summary: Atomically transfer a key from a Redis instance to another one.
since: 2.6.0

9.��һ��key�Ƶ���һ�����ݿ�
MOVE key db
summary: Move a key to another database
since: 1.0.0

10.����ڲ���redis����
OBJECT subcommand [arguments [arguments ...]]
summary: Inspect the internals of Redis objects
since: 2.2.3

11.��key���Ƴ�����ʱ��
PERSIST key
summary: Remove the expiration from a key
since: 2.2.0

127.0.0.1:6379> set foo bar
OK
127.0.0.1:6379> EXPIRE foo 32
(integer) 1
127.0.0.1:6379> PERSIST foo
(integer) 1

12.��ȡ��ֵ�ԵĴ��ʱ��(΢��)
PTTL key
summary: Get the time to live for a key in milliseconds
since: 2.6.0

127.0.0.1:6379> EXPIRE foo 32
(integer) 1
127.0.0.1:6379> pttl foo
(integer) 27944
13.��ȡ��ֵ�Դ��ʱ��(��)
TTL key
summary: Get the time to live for a key
since: 1.0.0


13.����΢�뼶��ļ�ֵ�Դ��ʱ��
PEXPIRE key milliseconds
summary: Set a key's time to live in milliseconds
since: 2.6.0

14.����΢�뼶���unix��ʽ��ʱ�䣬��ֵ�Դ��ʱ��
PEXPIREAT key milliseconds-timestamp
summary: Set the expiration for a key as a UNIX timestamp specified in milliseconds
since: 2.6.0

15.�����ȡһ����
RANDOMKEY -
summary: Return a random key from the keyspace
since: 1.0.0

127.0.0.1:6379> RANDOMKEY
"foo2"
16.��������
RENAME key newkey
summary: Rename a key
since: 1.0.0

127.0.0.1:6379> rename foo12 foo13
OK

17.�����������¼�������ʱ
RENAMENX key newkey
summary: Rename a key, only if the new key does not exist
since: 1.0.0

127.0.0.1:6379> RENAMENX foo13 foo3 #foo3�Ѿ�����ִ�в��ɹ�
(integer) 0

18.���ݼ�ֵ��
DUMP key
summary: Return a serialized version of the value stored at the specified key.
since: 2.6.0
127.0.0.1:6379> dump foo
"\x00\x03bar\x06\x00pS!\xe0\x1b3\xc1\x84"

19.��ԭ��ֵ��
RESTORE key ttl serialized-value
summary: Create a key using the provided serialized value, previously obtained using DUMP.
since: 2.6.0

20.��ȡ��������
TYPE key
summary: Determine the type stored at key
since: 1.0.0
127.0.0.1:6379> type foo3
string

21.��������
SORT key [BY pattern] [LIMIT offset count] [GET pattern [GET pattern ...]] [ASC|DESC] [ALPHA] [STORE destination]
summary: Sort the elements in a list, set or sorted set
since: 1.0.0

/****** string���͵�������� ********/
1.��ֵ��ӵ�����ֵ�ú���
APPEND key value
summary: Append a value to a key
since: 2.0.0
127.0.0.1:6379> append foo3 barbar
(integer) 10
127.0.0.1:6379> get foo3
"bar3barbar"

2.
BITCOUNT key [start] [end]
summary: Count set bits in a string
since: 2.6.0
127.0.0.1:6379> bitcount foo3
(integer) 34
127.0.0.1:6379> bitcount foo13
(integer) 16

3."����"
BITOP operation destkey key [key ...]
summary: Perform bitwise operations between strings
since: 2.6.0

4.��ֵ��С1(����Ӧ��ֵ����Ϊint)
DECR key
summary: Decrement the integer value of a key by one
since: 1.0.0

127.0.0.1:6379> set num1 13
OK
127.0.0.1:6379> get num1
"13"
127.0.0.1:6379> decr num1
(integer) 12
127.0.0.1:6379> get num1
"12"

5.��ֵ��Сָ����С(����Ӧ��ֵ����Ϊint)
DECRBY key decrement
summary: Decrement the integer value of a key by the given number
since: 1.0.0
127.0.0.1:6379> get num1
"12"
127.0.0.1:6379> DECRBY num1 6
(integer) 6
127.0.0.1:6379> get num1
"6"

6.Ϊ�����¸��ƣ�������֮ǰ�ľ�ֵ
GETSET key value
summary: Set the string value of a key and return its old value
since: 1.0.0

7. 
GETBIT key offset
summary: Returns the bit value at offset in the string value stored at key
since: 2.2.0

8.
GETRANGE key start end
summary: Get a substring of the string stored at a key
since: 2.4.0

9.Ϊkey����stringֵ��������ԭ�ȵ�ֵ
GETSET key value
summary: Set the string value of a key and return its old value
since: 1.0.0

127.0.0.1:6379> get foo13
"bar12nametest"
127.0.0.1:6379> getset foo13 test
"bar12nametest"

10. ��value����Ϊint��ֵ��1
INCR key
summary: Increment the integer value of a key by one
since: 1.0.0
127.0.0.1:6379> set num 10
OK
127.0.0.1:6379> get num
"10"
127.0.0.1:6379> INCR num
(integer) 11

11. ��value����Ϊint��ֵ��ָ������
INCRBY key increment
summary: Increment the integer value of a key by the given amount
since: 1.0.0
127.0.0.1:6379> get num
"11"
127.0.0.1:6379> INCRBY num 10
(integer) 21
127.0.0.1:6379> get num
"21"

12.��value����Ϊfloat��ֵ����ָ������
INCRBYFLOAT key increment
summary: Increment the float value of a key by the given amount
since: 2.6.0

127.0.0.1:6379> set flo 11.2
OK
127.0.0.1:6379> get flo
"11.2"
127.0.0.1:6379> INCRBYFLOAT flo 12.0
"23.2"

13.��ȡ���key��value
MGET key [key ...]
summary: Get the values of all the given keys
since: 1.0.0
127.0.0.1:6379> MGET foo2 foo3 foo4
1) "bar2"
2) "bar3barbar"
3) (nil)


14.���ö��key��value
MSET key value [key value ...]
summary: Set multiple keys to multiple values
since: 1.0.1
127.0.0.1:6379> MSET foo2 bar22 foo3 bar33 foo4 bar44
OK
127.0.0.1:6379> MGET foo2 foo3 foo4
1) "bar22"
2) "bar33"
3) "bar44"

15.�����е�key��������ʱ������value
MSETNX key value [key value ...]
summary: Set multiple keys to multiple values, only if none of the keys exist
since: 1.0.1
127.0.0.1:6379> MSETNX foo2 bar23 foo5 bar55 ##��Ϊfoo2���Ѿ�����
(integer) 0

16.���ü���΢������ʱ���ֵ
PSETEX key milliseconds value
summary: Set the value and expiration in milliseconds of a key
since: 2.6.0

17.���ü���������ʱ���ֵ
SETEX key seconds value
summary: Set the value and expiration of a key
since: 2.0.0


18.����ֵ
SET key value [EX seconds] [PX milliseconds] [NX|XX]
summary: Set the string value of a key
since: 1.0.0

19.
SETBIT key offset value
summary: Sets or clears the bit at offset in the string value stored at key
since: 2.2.0

20.�ڼ�������ʱ������ֵ
SETNX key value
summary: Set the value of a key, only if the key does not exist
since: 1.0.0

21.��offsetλ��д���µ�ֵ����
SETRANGE key offset value
summary: Overwrite part of a string at key starting at the specified offset
since: 2.2.0
127.0.0.1:6379> set foo5 jing
OK
127.0.0.1:6379> get foo5
"jing"
127.0.0.1:6379> SETRANGE foo5 3 test
(integer) 7
127.0.0.1:6379> get foo5
"jintest"


22.��ȡֵ�ó���
STRLEN key
summary: Get the length of the value stored in a key
since: 2.2.0
127.0.0.1:6379> STRLEN foo5
(integer) 4
















