/*****************--  通过配置文件修改jdk的路径 --******************/
Eclipse的eclipse目录下的eclipse.ini配置文件，会有一个
	-vm 选项，将该选项及其下面的配置路径删除掉后，启动Eclipse就会自己去系统的环境变量中寻找jdk的位置

/********************-- 项目因误操作删除maven依赖包后重新转为maven项目 --**********************/

右击项目 -> configure ->convert to maven project 即可恢复为maven项目