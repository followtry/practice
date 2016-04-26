## MongoDB 特定规范

**mongodb 数据类型**

|数据类型|描述|
|---|---|
|String|字符串，常用类型。编码只能是UTF-8|
|Integer|整数类型，存储数值|
|Boolean|布尔类型，存储false或true|
|Double|双精度类型，存储浮点数|
|Min/Max keys|将一个值与bson的最大和最小值比较|
|Arrays|用于将数组或列表或多个值存储为一个键。|
|Timestamp|时间戳。记录文档修改或添加的具体时间|
|Object|嵌入文档|
|Null|创建空值|
|Symbol|符号，基本上等同于字符串，用于采用特殊符号类型的语言|
|Date|日期信息，unix时间格式|
|Object ID|对象id，用于创建文档id|
|Binary Data|二进制数据|
|Code|存储js代码|
|Regular expression|存储正则表达式|

**MongoDB 与 RDBMS Where 语句比较**
|操作|格式||范例|RDBMS 中的类似语句|
|---|---|---|---|
|等于|{key:value}| db.test.find({likes:100})|where likes = 100|
|小于|{key:{$lt:value}}| db.test.find({likes:{$lt:200}})|where likes < 100|
|小于等于|{key:{$lte:value}}|db.test.find({likes:{$lte:100}})|where likes <= 100|
|大于等于|{key:{$gte:value}}|db.test.find({likes:{$gte:100}})|where likes >= 100|
|大于|{key:{$gt:value}}|db.test.find({likes:{$gt:100}})|where likes > 100|
|不等于|{key:{$ne:value}}|db.test.find({likes:{$ne:100}})|where likes != 100|
|AND|{key1:value1,key2:value2}|db.test.find({likes:100,title:"MongoDB 教程"})|where likes = 100 and title ='MongoDB 教程'|
|OR|{$or:[{key1:value1,key2:value2}]}|db.test.find({$or:[{likes:100,title:"MongoDB 教程"}]}) 一定要有中括号"[]"|where likes = 100 or title ='MongoDB 教程'|


**MongoDB $type 操作符**

|类型|	数字|	备注|
|---|---|---|
|Double	|1	| |
|String	|2	 ||
|Object	|3	 ||
|Array	|4	 ||
|Binary data	|5|	 |
|Undefined	|6	|已废弃。|
|Object id	|7|	| 
|Boolean	|8|	| 
|Date	|9|	 |
|Null	|10|	| 
|Regular Expression	|11||	 
|JavaScript	|13||	 
|Symbol	|14||	 
|JavaScript (with scope)	|15||	 
|32-bit integer	|16||	 
|Timestamp	|17||	 
|64-bit integer	|18||	 
|Min key	|255|	Query with -1.|
|Max key	|127||	 

**索引ensureIndex()的参数**

|Parameter	|Type|	Description|
|---|---|---|
|background	|Boolean|	建索引过程会阻塞其它数据库操作，background可指定以后台方式创建索引，即增加 "background" 可选参数。 "background" 默认值为false。|
|unique|	Boolean	|建立的索引是否唯一。指定为true创建唯一索引。默认值为false.|
|name	|string|	索引的名称。如果未指定，MongoDB的通过连接索引的字段名和排序顺序生成一个索引名称。|
|dropDups|	Boolean	|在建立唯一索引时是否删除重复记录,指定 true 创建唯一索引。默认值为 false.|
|sparse|Boolean|	对文档中不存在的字段数据不启用索引；这个参数需要特别注意，如果设置为true的话，在索引字段中不会查询出不包含对应字段的文档.。默认值为 false.|
|expireAfterSeconds	|integer|	指定一个以秒为单位的数值，完成 TTL设定，设定集合的生存时间。|
|v	|index version|	索引的版本号。默认的索引版本取决于mongod创建索引时运行的版本。|
|weights	|document|	索引权重值，数值在 1 到 99,999 之间，表示该索引相对于其他索引字段的得分权重。|
|default_language	|string	|对于文本索引，该参数决定了停用词及词干和词器的规则的列表。 默认为英语|
|language_override	|string	|对于文本索引，该参数指定了包含在文档中的字段名，语言覆盖默认的language，默认值为 language.|

**聚合表达式**


|表达式	|描述|	实例|
|--|--|--|
|$sum|	计算总和。|	db.mycol.aggregate([{$group : {_id : "$by_user", num_tutorial : {$sum : "$likes"}}}])|
|$avg|	计算平均值	|db.mycol.aggregate([{$group : {_id : "$by_user", num_tutorial : {$avg : "$likes"}}}])|
|$min|	获取集合中所有文档对应值得最小值。|	db.mycol.aggregate([{$group : {_id : "$by_user", num_tutorial : {$min : "$likes"}}}])|
|$max|	获取集合中所有文档对应值得最大值。|	db.mycol.aggregate([{$group : {_id : "$by_user", num_tutorial : {$max : "$likes"}}}])|
|$push|	在结果文档中插入值到一个数组中。|	db.mycol.aggregate([{$group : {_id : "$by_user", url : {$push: "$url"}}}])|
|$addToSet|	在结果文档中插入值到一个数组中，但不创建副本。	|db.mycol.aggregate([{$group : {_id : "$by_user", url : {$addToSet : "$url"}}}])|
|$first|	根据资源文档的排序获取第一个文档数据。|	db.mycol.aggregate([{$group : {_id : "$by_user", first_url : {$first : "$url"}}}])|
|$last|	根据资源文档的排序获取最后一个文档数据	|db.mycol.aggregate([{$group : {_id : "$by_user", last_url : {$last : "$url"}}}])|

### 数据库名称

- 不能是空字符串

- 不能含有空格、.、$、/、\和\0;

- 全部小写

- 最多64字节

### 文档：

- 文档中键值对是有序的

- 文档中的值不仅可以是字符串，还可以是其他类型，甚至是嵌入文档

- mongodb 区分大小写

- mongodb文档不能有重复的键

- 键不能含有\0（空字符），因为该字符使用来结尾的

- .和$有特殊的意义，只能在特定环境下使用

- 以下划线开头的键是保留的(非严格要求)

### 集合：

- 集合名不能是空字符串""。
- 集合名不能含有\0字符（空字符)，这个字符表示集合名的结尾。
- 集合名不能以"system."开头，这是为系统集合保留的前缀。
- 用户创建的集合名字不能含有保留字符。有些驱动程序的确支持在集合名里面包含，这是因为某些系统生成的集合中包含该字符。除非你要访问这种系统创建的集合，否则千万不要在名字里出现$。　