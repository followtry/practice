########startDFS.sh############
#!/bin/sh
#echo "waring"
#read NAME #�ȴ��û����벢�������ֵ����NAME
NAME=$1 #���ű���һ����������NAME

#���ñ���ʱ����"{}",�Ǹ���ϰ��,����shell�������߽�
if [  -z ${NAME} ]  ;then #Ĭ�����Ϊ�գ�hadoop start
        echo "1.start hadoop on ${HOSTNAME}"
        start-all.sh
elif [ "${NAME}" = "hadoop" ];then #���NAME�е�ֵΪ"hadoop"�������ִ��if
        echo "2.start hadoop on ${HOSTNAME}"
        start-all.sh
elif [ "${NAME}" = "hbase" ] ;then #�����ִ��else if
        start-all.sh
        #for loop in 1 2 3
        NUM=1
        while [ ${NUM} -lt 4 ]
        do
                echo "start zkServer on hadoop${NUM}"
                ssh -t -p 22 hadoop${NUM} "/usr/local/zk/bin/zkServer.sh start" #��Զ��
������������
        NUM=$[${NUM}+1]
        done
        ssh -t -p 22 hadoop1 "/usr/local/hbase/bin/start-hbase.sh" #��Զ�̻�����������
else
echo "error"

fi #����if����


########stopDFS.sh############
#!/bin/sh
#echo "waring"
#read NAME #�ȴ��û����벢�������ֵ����NAME
NAME=$1 #���ű���һ����������NAME
#���ñ���ʱ����"{}",�Ǹ���ϰ��,����shell�������߽�
if [ -z ${NAME} ] ; then #Ĭ�Ϲر�hadoop
        stop-all.sh
elif [ ${NAME} = "hadoop" ]; then #���NAME�е�ֵΪ"jingzhongzhi"�������ִ��if
        echo "shutdown hadoop cluster"
        stop-all.sh
elif [ ${NAME} = "hbase" ] ; then #�����ִ��else if
        echo "shutdown hbase on hadoop1"
        ssh -t -p 22 hadoop1 "/usr/local/hbase/bin/stop-hbase.sh" #��Զ�̻�����������
        NUM=1
        while [ ${NUM} -lt 4 ]
        do
                echo "shutdown hadoop${NUM}'s zkServer"
                ssh -t -p 22 hadoop${NUM} "/usr/local/zk/bin/zkServer.sh stop" #��Զ��>������������
                NUM=$[${NUM}+1]
        done
        echo "shutdwon hadoop cluster"
        stop-all.sh
else
        echo "error"

fi #����if����

########�鿴hadoop��״̬###########
#!/bin/sh
#�鿴hadoop������״̬
function hadoopState(){
        COUNT=1
        while [ ${COUNT} -le ${NUM} ]
        do
                echo "�鿴hadoop${COUNT}��hadoop������״̬"
                #����Զ�������鿴����״̬
                ssh -t -p 22 hadoop${COUNT} "jps"
                COUNT=$((${COUNT}+1))
        done
}

echo "=====�鿴hadoop������״̬===="
NUM=$1 #hadoop ��Ⱥ������
echo "������ĵ�NUMΪ${NUM}"
if test !${NUM};then
        NUM=3
        hadoopState
else
        hadoopState
fi
echo "=====�鿴����===="

                                               