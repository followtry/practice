 centos���ֶ���װmysql
/****************************************************/
1.��������е�centos��ip����Ϊ�ֶ��������Ժ���������ͨ

/****************************************************/
2.ʹ��winscp��mysql-5.5-x.tar.gz ���Ƶ�linux��rootĿ¼��
(1).��ѹ�ļ�
#tar -xzvf  mysql-5.5-x.tar.gz
(2).������
#mv mysql-5.5-x.tar.gz mysql
/****************************************************/
3.����Ԥ��װ����
(1).����û�����
#groupadd mysql
#useradd -r -g mysql mysql

(2).��װcmake����
	#yum install gcc #�Ȱ�װ���빤�߼�gcc
	#yum install cmake
(3).ȷ����������ϵͳ������Ѿ�����װ
ͨ�� rpm -qa | grep name �ķ�ʽ��֤����������Ƿ���ȫ����װ��
gcc* gcc-c++* autoconf* automake* zlib* libxml* "ncurses-devel" libgcrypt* libtool*
curses��RH��centos��Ϊncurses-devel����Ubuntu��Ϊlibncurses5-dev 
(4).ִ��"cmake .",��������Ҳ���curses��lib��centos��
#yum  install ncurses-devel
#ɾ��mysql�µ�CMakeCache.txt�ļ�
#cmake .
(5).���벢��װ
#make
#make install
/****************************************************/
4. ��װ������
(1).����
#cd /usr/local/mysql
#chown -R mysql .
#chgrp -R mysql .
####scripts/mysql_install_db --user=mysql #�д�
#./bin/mysqld --skip-grant &
#chown -R root .
#chown -R mysql data
##### Next command is optional
#cp support-files/my-medium.cnf /etc/my.cnf
#bin/mysqld_safe --user=mysql &
##### Next command is optional
#cp support-files/mysql.server /etc/init.d/mysql.server

PS:�������./mysqld: unknown option '--ndbcluster'
�޸������ļ�
########################Դ�ļ�################################
[client]
socket=/var/lib/mysql/mysql.sock

[mysqld]
max_connections=100
datadir=/var/lib/mysql
socket=/var/lib/mysql/mysql.sock
user=mysql
#ndbcluster  #�޸ĺ�Ϊע�͵�
#ndb-connectstring=192.168.100.11   #�޸ĺ�Ϊע�͵�
# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0

[mysqld_safe]
log-error=/var/log/mysqld.log
pid-file=/var/run/mysqld/mysqld.pid

[mysql_cluster]
#ndb-connectstring=192.168.100.11   #�޸ĺ�Ϊע�͵�
(2).�������� 
#/usr/local/mysql/bin/mysqld --user=mysql &  #����mysqld ����
#/usr/local/mysql/bin/mysql -u mysql  #����mysql�����пͻ���
(3).��mysqlĿ¼��ӵ�����������
#vim /etc/profile
#export MYSQL_HOME=/usr/local/mysql
#export PATH=.:MYSQL_HOME/bin:$PATH

#source /etc/profile
/**************************************************/
5.����mysql���ӷ�����
(1).����ȷ�����ӷ������ϵ�Mysql�汾��ͬ
(2).������������,����һ�������ݿ���˻�,ʹ��REPLICATION SLAVE����Ȩ��
(3).����ӷ�����Ȩ��
#mysql
mysql>  GRANT REPLICATION SLAVE ON *.* TO 'root'@'192.168.48.142';## IDENTIFIED BY 'mysql'
Query OK, 0 rows affected (0.01 sec)




/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

/****************************************************/

