### 1. 注册

#### 1.1. 注册接口

- 请求路径：/user/register
- 请求方法：POST
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| userId   | 用户 ID  | 不能为空 |
| password | 密码     | 不能为空 |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| status | 用户状态 |      |

- 响应数据

```json
{
  "data": {
    "status": 1
    //0是冻结，1是解封，2是已注册，3是未注册
  },
  "meta": {
    "msg": "注册成功",
    "status": 201
  }
}
```

### 2. 登录

#### 2.1.用户登录接口

- 请求路径：/user/login
- 请求方法：POST
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| userId   | 用户 ID  | 不能为空 |
| password | 密码     | 不能为空 |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| status | 用户状态 |      |
| token  | 令牌     |      |

- 响应数据

```json
{
  "data": {
    "status": 1,
    "token":"token值",
    "userId":1,
    "avatar":"xxxx"
  },
  "meta": {
    "msg": "用户登录成功",
    "status": 200
  }
}
```

#### 2.2. 管理员登录接口

- 请求路径：/admin/login
- 请求方法：POST
- 请求参数

| 参数名   | 参数说明  | 备注     |
| -------- | --------- | -------- |
| adminId  | 管理员 ID | 不能为空 |
| password | 密码      | 不能为空 |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| token  | 令牌     |      |

- 响应数据

```json
{
  "data": null,
  "meta": {
    "msg": "管理员登录成功",
    "status": 200
  }
}
```

### 3. 教程

#### 3.1. 查看教程接口

- 请求路径：/tutorial/view
- 请求方法：GET
- 请求参数

| 参数名 | 参数说明 | 备注       |
| ------ | -------- | ---------- |
| tutoId | 查询参数 | 不可以为空 |

- 响应参数

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| titleContent | 标题     |      |
| titleNum     | 标号     |      |
| content      | 教程内容 |      |
| commentList  | 评论列表 |      |
| proList      | 问题列表 |      |

- 响应数据

```json
{
  "data": {
    "titleContent": "数组",
    "titleNum": 30.0,
    "content": "array",
    "commentList": [
      {
        "commentId": 5,
        "commentTutoId": 9,
        "commentUserId": 12,
        "content": "fantastic",
        "replyTo": 1,
        "replyOrder": 20
      },
      {
        "commentId": 6,
        "commentTutoId": 9,
        "commentUserId": 27,
        "content": "amazing",
        "replyTo": 5,
        "replyOrder": 21
      }
    ],
    "proList": [
      {
        "probId": 5,
        "probTutoId": 9,
        "content": "A+BProblem"
      },
      {
        "probId": 6,
        "probTutoId": 9,
        "content": "StringMatching"
      }
    ]
  },
  "meta": {
    "msg": "查看成功",
    "status": 200
  }
}
```

### 4. 修改用户信息

#### 4.1修改用户密码

- 请求路径: user/:userId

- 请求方法：PUT

- 请求参数

| 参数名   | 参数说明 | 备注                  |
| -------- | -------- | --------------------- |
| userId   | 用户ID   | 不能为空, 携带在url中 |
| password | 用户密码 | 不能为空              |

- 响应数据

```json
{
  "data": {
    "userId": 11777777,
    "password": 7170831
  },
  "meta": {
    "msg": "信息修改成功",
    "status": 200
  }
}
```

#### 4.2修改管理员密码

- 请求路径: adminId/:AdminId

- 请求方法：PUT

- 请求参数

| 参数名   | 参数说明       | 备注                  |
| -------- | -------------- | --------------------- |
| AdminId  | 管理员ID       | 不能为空, 携带在url中 |
| password | 管理员账户密码 | 不能为空              |

- 响应数据

```json
{
  "data": {
    "adminId": 22223333,
    "password": 12345678
  },
  "meta": {
    "msg": "信息修改成功",
    "status": 200
  }
}


```

#### 4.3上传头像

- 请求路径: upload

- 请求方法：POST

- 请求参数

| 参数名 | 参数说明       | 备注     |
| ------ | -------------- | -------- |
| avatar | 头像图片的文件 | 不能为空 |
| userId | 用户ID         | 不能为空 |

- 响应数据

  | 参数名 | 参数说明           | 备注     |
  | ------ | ------------------ | -------- |
  | url    | 头像图片的在线地址 | 不能为空 |

```json
{
  "data": {
    "url":'xxxxxx'
  },
  "meta": {
    "msg": "信息修改成功",
    "status": 200
  }
}


```



### 5. 评论

#### 5.1 创建评论

- 请求路径：/comment

- 请求方法：POST

- 请求参数

| 参数名        | 参数说明         | 备注     |
| ------------- | ---------------- | -------- |
| commentTutoId | 评论所属的教程ID | 不能为空 |
| commentUserId | 评论所属的用户ID | 不能为空 |
| content       | 评论内容         | 不能为空 |
| replyTo       | 回复对象         |          |

响应数据

```json
{
  "data": {
    "commentId": 1,
    "commentTutoId": 1,
    "commentUserId": "username",
    "content": "评论测试内容",
    "replyTo": 1,
    "replyOrder": 7
  },
  "meta": {
    "msg": "评论创建成功",
    "status": "201"
  }
}
```

#### 5.2. 根据教程ID获取用户评论

- 请求路径：/tutorial/:tutoId/commentList/:page/:pageSize

- 请求方法：GET

- 请求参数

| 参数名   | 参数说明       | 备注                  |
| -------- | -------------- | --------------------- |
| tutoId   | 教程ID         | 不能为空，携带在url里 |
| page     | 当前页号       | 不能为空，携带在url里 |
| pageSize | 当前页数据条数 | 不能为空，携带在url里 |

- 响应参数

| 参数名      | 参数说明     | 备注 |
| ----------- | ------------ | ---- |
| commentList | 评论数据集合 |      |
| dataTotal   | 评论的总条数 |      |
| pageTotal   | 总共的页数   |      |

- 响应数据

```json
{
  "data": {
    "dataTotal":30,
    "pageTotal":15,
    "comment": [
      {
        "commentUserId": 123,
        "content": "评论测试内容",
        "replyTo": 1,
        "replyOrder": 1,
        "create_time": "2021-06-01 19:42:23"
      },
      {
        "commentUserId": 231,
        "content": "评论测试内容",
        "replyTo": 1,
        "replyOrder": 2,
        "create_time": "2021-06-01 19:44:23"
      }
    ]
  },
  "meta": {
    "msg": "获取评论成功",
    "status": "200"
  }
}


```

### 6. 发布公告

- 请求路径：/bulletin

- 请求方法：POST

- 请求参数：

| 参数名  | 参数说明 | 备注     |
| ------- | -------- | -------- |
| content | 公告内容 | 不能为空 |

- 响应数据

json

```json
{
  "data": {
    "bulletinId": 2,
    "content": "公告测试"
  },
  "meta": {
    "msg": "公告创建成功",
    "status": 201
  }
}
```

### 7.8部分已取消

### 9.管理公告

#### 9.1修改公告

- 请求路径：bulletin/modify/:bulletinId
- 请求方法：put
- 请求参数

| 参数名     | 参数说明     | 备注                                |
| ---------- | ------------ | ----------------------------------- |
| bulletinId | 公告id       | 不能为空 `参数是url参数:bulletinId` |
| content    | 新的公告内容 | 不能为空                            |

- 响应参数--data

| 参数名     | 参数说明 | 备注 |
| ---------- | -------- | ---- |
| bulletinId | 公告id   |      |
| content    | 公告内容 |      |

- 响应数据

  ```json
  {
      "data": {
          "bullentinId":1,
          "content": "xxx内容"
      },
      "meta": {
          "msg": "更新成功",
          "status": 200
      }
  }
  ```

#### 9.2删除公告

- 请求路径：bulletin/:bulletinId
- 请求方法：delete
- 请求参数：

| 参数名     | 参数说明 | 备注                                |
| ---------- | -------- | ----------------------------------- |
| bulletinId | 公告id   | 不能为空 `参数是url参数:bulletinId` |

- 响应参数--data

  无

- 响应数据

  ```json
    {
        "data":null,
        "meta": {
            "msg": "删除成功",
            "status": 200
        }
    }
  ```

### 10.查看公告

- 请求路径：bulletin/getAll
- 请求方法：get
- 请求参数：无

- 响应参数--data

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| bulletinList | 公告列表 |      |

- 响应数据

  ```json
  {
      "data": {
          "bulletinList": [
              {
                  "bulletinId": 1,
                  "content": "改了的内容"
              },
              {
                  "bulletinId": 2,
                  "content": "内容"
              }
          ]
      },
      "meta": {
          "msg": "获取成功",
          "status": 200
      }
  }
  ```

### 11.添加训练教程

- 请求路径：tutorial/add
- 请求方法：post
- 请求参数

| 参数名       | 参数说明 | 备注     |
| ------------ | -------- | -------- |
| titleContent | 教程标题 | 不能为空 |
| content      | 教程内容 | 不能为空 |
| titleNum     | 教程标号 | 不能为空 |

- 响应参数--data

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| tutoId       | 教程id   |      |
| titleContent | 教程标题 |      |
| content      | 教程内容 |      |
| titleNum     | 教程标号 |      |

- 响应数据

  ```json
  {
      "data": {
          "tutoId":1,
          "titleContent":"xxx教程",
          "titleNum":"xxx标号",
          "content": "xxx内容"
      },
      "meta": {
          "msg": "添加成功",
          "status": 200
          
      }
  }
  ```

### 12.管理训练教程

#### 12.1修改表述

- 请求路径：tutorial/modify/:tutoId
- 请求方法：put
- 请求参数

| 参数名  | 参数说明 | 备注     |
| ------- | -------- | -------- |
| tutoId  | 教程Id   | 不能为空 |
| content | 教程内容 | 不能为空 |

- 响应参数--data

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| tutoId       | 教程id   |      |
| titleContent | 教程标题 |      |
| content      | 教程内容 |      |
| titleNum     | 教程标号 |      |

- 响应数据

  ```json
  {
      "data": {
          "tutoId":1,
          "titleContent":"xxx教程",
          "titleNum":"xxx标号",
          "content": "xxx内容"
      },
      "meta": {
          "msg": "修改成功",
          "status": 200
          
      }
  }
  ```



### 13.删除训练教程

- 请求路径：tutorial/delete/:tutoId

- 请求方法：delete

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | tutoId | 教程id   | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta": {
          "msg": "删除成功",
          "status": 200
      }
  }
  ```

### 14.提交代码

- 请求路径：userCode

- 请求方法：post

- 请求参数

  | 参数名   | 参数说明 | 备注     |
  | -------- | -------- | -------- |
  | probId   | 题目Id   | 不能为空 |
  | userCode | C++代码  | 不能为空 |



- 响应数据

  | 参数名 | 参数说明                              | 备注               |
  | ------ | ------------------------------------- | ------------------ |
  | cases  | 数组类型，其中每个元素含有键id status | 编译失败时无该参数 |
  | score  | 字符串类型，格式为 "分数/总分"        | 编译失败时无该参数 |

  ```json
  {
      "data": {
          "cases":[
          {"id":0,"status":"Accept"},
          {"id":1,"status":"Accept"}
          ],
          "score":"2/2"
      },
      "meta":{
          "msg":"编译成功",
          "status":200
      }
  }
  ```

  ```json
  {
      "data": null,
      "meta":{
          "msg":"编译失败",
          "status":200
      }
  }
  ```

- 备注

  不需要传入用户名，系统会自动为每次请求分配一个临时ses


- 备注：请注意，这个请求的响应时间很长，可能会达到3~10秒，因此前端须允许用户在等待过程中做其他事情

### 15.查看题解

- 请求路径：answer

- 请求方法：get

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | proId  | 题目Id   | 不能为空 |

- 响应参数

  | 参数名 | 参数说明 | 备注      |
  | ------ | -------- | --------- |
  | text   | 题解文本 | 格式为X/X |

- 响应数据

  ```json
  {
      "data": {
          "text":"..."
      },
      "meta":{
          "msg":"响应成功",
          "status":200
      }
  }
  ```

### 16.管理用户

#### 16.1删除用户

- 请求路径：user

- 请求方法：delete

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | userId | 用户名   | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta": {
          "msg": "删除成功",
          "status": 200
      }
  }
  ```

#### 16.2封号

- 请求路径：user/ban

- 请求方法：post

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | userId | 用户名   | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta": {
          "msg": "封禁成功",
          "status": 200
      }
  }
  ```

#### 16.3解除封号

- 请求路径：user/unban

- 请求方法：post

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | userId | 用户名   | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta": {
          "msg": "封禁成功",
          "status": 200
      }
  }
  ```

### 17. 管理问题

#### 17.1 添加问题

- 请求路径：problem/add

- 请求方法：post

- 请求参数

| 参数名     | 参数说明           | 备注                           |
| ---------- | ------------------ | ------------------------------ |
| probId     | 问题编号           | 不能为空                       |
| probTutoId | 问题对应教程的编号 | 不能为空，且要与已存在教程对应 |
| content    | 问题内容           | 不能为空                       |

- 响应数据

```json
{
  "data": {
    "probId": 1,
    "probTutoId": 2,
    "content": "A+BProblem"
  },
  "meta": {
    "msg": "问题添加成功",
    "status":"200"
  }
}
```

#### 17.2 修改问题表述

- 请求路径：problem/modify

- 请求方法：put

- 请求参数

  | 参数名     | 参数说明           | 备注                           |
  | ---------- | ------------------ | ------------------------------ |
  | probId     | 问题编号           | 不能为空                       |
  | probTutoId | 问题对应的教程编号 | 不能为空，且要与已存在教程对应 |
  | content    | 问题内容           | 不能为空                       |

- 响应数据

```json
{
  "data": {
    "probId": 1,
    "ProbTutoId": 2,
    "content": "StringMatching"
  },
  "meta": {
    "msg": "问题修改成功",
    "status": "200"
  }
}
```

#### 17.3 删除问题

- 请求路径：problem/delete

- 请求方法：delete

- 请求参数

  | 参数名 | 参数说明 | 备注     |
  | ------ | -------- | -------- |
  | probId | 问题编号 | 不能为空 |

- 响应数据

```json
{
  "data": null,
  "meta": {
    "msg": "问题删除成功",
    "status": "200"
  }
}

```

### 18.教程目录

#### 18.1 获取一级教程标题

- 请求路径：tutorial/first

- 请求方法：get

- 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| 无     | 无       | 无   |

- 响应参数

| 参数名           | 参数说明 | 备注 |
| ---------------- | -------- | ---- |
| titleContentList | 标题列表 |      |

- 响应数据

```json
{
  "data": {
    "titleContentList":[
        {
            "tutoId":1,
            "titleContent":"1教程",
            "titleNum":1.00
        },
        {
            "tutoId":2,
            "titleContent":"2教程",
            "titleNum":2.00
        }
    ]
  },
  "meta": {
    "msg": "一级标题查询成功",
    "status":"200"
  }
}
```

#### 18.2 根据一级教程标题获取二级教程标题

- 请求路径：tutorial/second/:titleNum

- 请求方法：get

- 请求参数

| 参数名   | 参数说明       | 备注     |
| -------- | -------------- | -------- |
| titleNum | 一级标题的编号 | 不可为空 |

- 响应参数

| 参数名           | 参数说明 | 备注 |
| ---------------- | -------- | ---- |
| titleContentList | 标题列表 |      |

- 响应数据

```json
{
  "data": {
    "titleContentList":[
        {
            "tutoId":3,
            "titleContent":"1.01子标题",
            "titleNum":1.01
        },
        {
            "tutoId":4,
            "titleContent":"1.02子标题",
            "titleNum":1.02
        }
    ]
  },
  "meta": {
    "msg": "二级标题查询成功",
    "status":"200"
  }
}
```

### 19.代码暂存

#### 19.1 存放用户代码

- 请求路径：code/save

- 请求方法：post

- 请求参数

| 参数名 | 参数说明 | 备注     |
| ------ | -------- | -------- |
| proId  | 问题id   | 不能为空 |
| userId | 用户id   | 不能为空 |
| code   | 代码内容 | 不能为空 |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| 无     | 无       | 无   |

- 响应数据

```json
{
  "data":null,
  "meta": {
    "msg": "代码暂存成功！",
    "status":"200"
  }
}
```

#### 19.2 获取用户代码

- 请求路径：code/get/:proId/:userId

- 请求方法：get

- 请求参数

| 参数名 | 参数说明 | 备注     |
| ------ | -------- | -------- |
| probId | 问题id   | 不能为空 |
| userId | 用户id   | 不能为空 |

- 响应参数

| 参数名 | 参数说明           | 备注 |
| ------ | ------------------ | ---- |
| code   | 用户上次编辑的代码 | 无   |

- 响应数据

```json
{
  "data":{
      "code":"system.out.println(xxx)"
  },
  "meta": {
    "msg": "代码获取成功！",
    "status":"200"
  }
}
```

### 20. 管理测试数据

#### 20.1 添加测试数据（批量增加）

- 请求路径：data/add/:probId

- 请求方法：post

- 请求参数

| 参数名   | 参数说明     | 备注                                                         |
| -------- | ------------ | ------------------------------------------------------------ |
| probId   | 问题编号     | 不能为空                                                     |
| dataList | 测试数据列表 | 一个数组，其中，每个对象包含in(输入数据)，out(输出数据)字符串 |

请求参数具体如下:

```json
{
      "probId":1,
      "dataList":[
          {
              "in":"100000 5471 6562\n5.303\n5.303\n5.303\n5.303...",
              "out":"0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000..."
          },
          {
              "in":"100000 7156 8863\n1.372\n1.372\n1.372...",
              "out":"0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000..."
          }
      ]
}
```

- 响应数据

  ```json
  {
    "data":null,
    "meta": {
      "msg": "测试数据添加成功！",
      "status":"200"
    }
  }
  ```

#### 20.2 删除测试数据（批量删除）

- 请求路径：data/delete/:dataIds/:probId

- 请求方法：delete

- 请求参数

  | 参数名  | 参数说明                                                     | 备注 |
  | ------- | ------------------------------------------------------------ | ---- |
  | dataIds | 测试数据Id(多个测试数据Id组合而成)例如删除id为1，2，3的测试数据，那么dataIds是1&2&3 | 非空 |
  | probId  | 问题Id                                                       | 非空 |

  具体请求参数格式如下:

  ```json
  {
      "probId":'1',
      "dataIds":'1&2&3'
  }
  ```

- 响应数据

```json
{
  "data": null,
  "meta": {
    "msg": "测试数据删除成功",
    "status": "200"
  }
}

```

#### 20.3查看测试数据

- 请求路径：data/get/:probId

- 请求方法：get

- 请求参数

  | 参数名 | 参数说明 | 备注 |
  | ------ | -------- | ---- |
  | probId | 问题id   | 非空 |

- 响应数据

```json
{
  "data":{
      "dataList":[
          {
              "dataId":1,
              "in":"100000 5471 6562\n5.303\n5.303\n5.303\n5.303...",
              "out":"0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000\n0.000..."
          }
      ]
  },
  "meta": {
    "msg": "测试数据获取成功",
    "status": "200"
  }
}

```

#### 20.4修改测试数据

- 请求路径：data/modify/:dataId/:probId
- 请求方法：put
- 请求参数

| 参数名 | 参数说明                  | 备注     |
| ------ | ------------------------- | -------- |
| dataId | 测试数据的id              | 不能为空 |
| in     | 测试数据的输入数据 字符串 | 不能为空 |
| out    | 测试数据的输出数据 字符串 | 不能为空 |
| probId | 问题Id                    | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta": {
          "msg": "修改成功",
          "status": 200       
      }
  }
  ```

####       

### 21.管理题解(查看题解在上面已经有了)

#### 21.1增加题解

- 请求路径：answer/add

- 请求方法：post

- 请求参数

  | 参数名 | 参数说明       | 备注     |
  | ------ | -------------- | -------- |
  | probId | 题解对应题目Id | 不能为空 |
  | text   | 题解内容       | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta":{
          "msg":"添加成功",
          "status":200
      }
  }
  ```

#### 21.2删除题解

- 请求路径：answer/delete/:answerId

- 请求方法：delete

- 请求参数

  | 参数名   | 参数说明 | 备注     |
  | -------- | -------- | -------- |
  | answerId | 题解Id   | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta":{
          "msg":"删除成功",
          "status":200
      }
  }
  ```

#### 21.3更改题解

- 请求路径：answer/update/:answerId

- 请求方法：put

- 请求参数

  | 参数名   | 参数说明     | 备注     |
  | -------- | ------------ | -------- |
  | answerId | 题解Id       | 不能为空 |
  | text     | 新的题解内容 | 不能为空 |

- 响应数据

  ```json
  {
      "data": null,
      "meta":{
          "msg":"修改成功",
          "status":200
      }
  }
  ```

