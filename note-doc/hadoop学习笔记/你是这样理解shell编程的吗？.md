
	学习使用linux系统，绕不过去的就是shell脚本编程，在编写shell脚本之前。当然还要熟悉linux上的一些常用的命令(ls、mv、alias、cp、crontab、find、grep、mkdir等等很多)，只有熟悉了linux上的命令才能进一步学习linux上的shell编程。
	
	虽然linux现在的图形界面做的也已经不错了，但linux上最重要最便捷的操作还是通过命令行(也就是只有黑底白字的窗口)实现的，图形界面只是实现了其中的一部分功能，而且图形界面(如：KDE、GNOME等)只是linux上的套件，并不是linux上必备的软件，完全可以在不需要的情况下删除掉。所以要想学好linux，还是要熟悉命令和shell脚本，这是基础。
	
	那什么是shell脚本呢？一说脚本好像不太懂是什么东东，脚本只是对某一种文件的称呼而已，实际上还是用户可读的文本文件。而该文件中写的不是令人捧腹的笑话，也不是文章，更不是你对某个学科所做的笔记，而是一堆命令，对，就是一堆命令。如果每个命令都是一个东西(比如一本书)，那shell脚本就是盛放书籍的箱子，而书籍在其中是按照一定的顺序排放的。
	
	那shell脚本到底是什么呢？慢慢听我说，你可能使用过ls命令，很简单，显示当前目录的文件嘛。那多次执行各种命令(比如要生成一个含有hello的文件，并且将该文件命名为test，然后将文件重命名为test.txt，最后浏览当前目录然后将输出信息写入到该文件但不能覆盖掉hello。这样是不是就比较难一些了)。这样的一个任务分成了好多步骤执行，就要在终端下输入很多次的命令，但如果重新来一遍的话，还要重新输入。累不累啊？很累。大牛们感觉这样实在不是办法，就想了个主意，将这些命令依次序写到一个文件中，然后开发了一个叫做shell的程序去从上到下、从左到右读取文件中的内容来替代手动输入的内容。就这样，我们只需要让shell读一下文件即可了，是不是很省事了。而这样的文件就被称为shell脚本。
	
	而后来处理的事情比上面举的例子要复杂的多啊，简单的罗列命令的方式不好用啊，而且很多时候重复的内容能不能只写一次在多处调用呢？当然。大牛们为了偷点懒省电时间又为shell增加了一些语法,因此就出现了if-else 和 for循环、while循环等控制语句以及函数function，增加了shell的功能和复杂度。而这些控制语句和函数是借鉴的编程语言(比如C)，因此编写shell脚本的过程又叫做shell编程。
	因此在linux下，当使用者面对重复繁重的命令操作时，就可以将linux中的命令或者shell内置的命令，通过控制语句的编排，写入到一个文本文件中就成了shell脚本。然后给予该文本一个可执行权限，把该文件交给shell执行。那这样就完成了shell编程，是不是既便捷又轻松还显得高大上呢？
