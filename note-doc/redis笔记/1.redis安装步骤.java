/***********---- redis��װ�ʼ� ----*************/
1.ʹ��winscp��windows�µ�redis��ѹ�������Ƶ��������centos6�У�
2.��ѹredisѹ��������������Ϊredis,�ƶ���/usr/local/��
#tar -xzvf redis-2.8.3.tar.gz 
#cp -r redis-2.8.3 /usr/local/
#mv redis-2.8.3 redis
3.�л�����Ŀ¼��redis�£���README�ļ��������ļ��еĲ��谲װredis
#cd /usr/local/redis/
#vim README

4.����redisԴ��
#make  ##��ǰϵͳ��λ����64λ���������Ϊ64λ����
����#make 32bit #����Ϊ32λ����
����#make CFLAGS="-m32 -march=native" LDFLAGS="-m32"  #����Ϊ32λ����

û����ʹ������ɹ��ˡ�

5.����redis�ķ��񣬲�ʹ��redis-cli�ͻ��˲���ʹ��(��ǰĿ¼Ϊ/usr/local/redis/)
#cd src
##����redis����ʹ��Ĭ������
#./redis-server &
##����redis����ʹ���Զ����redis����(��:redis.conf)
#./redis-server /path/to/redis.conf
#����ͨ�������ȷ�Ĳ����޸� redis�����ļ������ݣ���ʱ�޸�
# ./redis-server --port 9999 --slaveof 127.0.0.1 6379
# ./redis-server /etc/redis/6379.conf --loglevel debug

6.����redis�ͻ���
[root@hadoop1 redis]# ./src/redis-cli
127.0.0.1:6379> ping
PONG
127.0.0.1:6379> set foo bar
OK
127.0.0.1:6379> get foo
"bar"
127.0.0.1:6379> incr mycounter
(integer) 1
127.0.0.1:6379> incr mycounter
(integer) 2
127.0.0.1:6379> incr mycounter
(integer) 3
127.0.0.1:6379> incr mycounter
(integer) 4
127.0.0.1:6379>

7.��ubuntu��Debian���������а�װredis�����ơ�
[root@hadoop1 redis]# make install 
��װredis��ϵͳ�ϣ�Ҳ�������ó�ʼ���Ľű��������ļ������ֻ����һ��redis��
��һ�����Ǳ���ģ����������װ��һ�������еĻ����У���ô����ʹ�����½ű���װ
[root@hadoop1 redis]#cd utils
#./install_server 
�ýű����������������⣬���һ�����redis��ϵͳ��Ϊdaemon����������ÿ���¡�
[root@hadoop1 utils]# ./install_server.sh
Welcome to the redis service installer
This script will help you easily set up a running redis server


Please select the redis port for this instance: [6379]
Selecting default: 6379
Please select the redis config file name [/etc/redis/6379.conf]
Selected default - /etc/redis/6379.conf
Please select the redis log file name [/var/log/redis_6379.log]
Selected default - /var/log/redis_6379.log
Please select the data directory for this instance [/var/lib/redis/6379]
Selected default - /var/lib/redis/6379
Please select the redis executable path [/usr/local/bin/redis-server]
s#^port [0-9]{4}$#port 6379#;s#^logfile .+$#logfile /var/log/redis_6379.log#;s#^dir .+$#dir /var/lib/redis/6379#;s#^pidfile .+$#pidfile /var/run/redis_6379.pid#;s#^daemonize no$#daemonize yes#;
Copied /tmp/6379.conf => /etc/init.d/redis_6379
Installing service...
./install_server.sh: line 178: update-rc.d: command not found
 exists, process is already running or crashed
Installation successful!

����ͨ��/etc/init.d/redis_<portnumber> start/stop�������͹ر�redis����




