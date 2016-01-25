/*********** redis transaction������� **********/
1.
DISCARD -
summary: Discard all commands issued after MULTI
since: 2.0.0

EXEC -
summary: Execute all commands issued after MULTI
since: 1.2.0

MULTI -
summary: Mark the start of a transaction block
since: 1.2.0

UNWATCH -
summary: Forget about all watched keys
since: 2.2.0

WATCH key [key ...]
summary: Watch the given keys to determine execution of the MULTI/EXEC block
since: 2.2.0

/************** redis connection������� ***********/
1.��֤����������
AUTH password
summary: Authenticate to the server
since: 1.0.0

2.��ʾָ����message��Ϣ
ECHO message
summary: Echo the given string
since: 1.0.0

3.�жϷ����Ƿ�pingͨ
PING -
summary: Ping the server
since: 1.0.0
4.�ر����Ӳ��˳�
QUIT -
summary: Close the connection
since: 1.0.0

5.ѡ��redis�µ����ݿ�
SELECT index
summary: Change the selected database for the current connection
since: 1.0.0


