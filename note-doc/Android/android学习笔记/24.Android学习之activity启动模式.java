/*********-- activity������ģʽ --***********/
activity�����û������Ľ��� UI
service ����̨�������е����
receiver: ����ϵͳ�Դ��Ĺ㲥�����ͽ����Զ���Ĺ㲥�¼�
content provider����һ��Ӧ�ó���˽�е����ݿ⣬��¶�����Ӧ��


Ӧ�ó��� �� ����
Ӧ�ó�����һ������Ľ��
���� ������Щ���������

����ջ��task stack ->  ֻ���activity ����
һ����Ҫ���ã�����ά���û��Ľ���

/*****-- activity������ģʽ --********/
 ����activity������ģʽ
����ջ��֮�²����������ڶ��ͬһactivity��ʵ��
 android:launchMode="singleTop"

����ջ��ÿ������ֻ����һ���������activity���浽taskstack��ʱ�����ջ
�д��ڸ�activityʵ�����ͽ���ʵ�����������activityʵ���������ջ������ʾ��
���û�о��´���
android:launchMode="singleTask"

ÿ��activity����һ������ջ��ÿ������ջ��ֻ��һ��activity��ʵ����������ڵ�ǰ�����activity������ջ���ͽ�
��ջ�Ƶ���ǰ���λ�ã���������ھʹ�����activity������ջ
���ˣ��������ֻ�ϵͳ��ֻ�����ͬһ��activityʵ���������Ǽ����ⲿӦ�ó������
android:launchMode="singleInstance"

����ջ���Ƿ���ڸ�activity��ÿ�ε������ջ�����ɸ�aactivity��ʵ����
������ջ�п��������������Ĵ��ڶ��ͬһactivity��ʵ��
android:launchMode="standard"











