# EOS RPC 接口文档

### get_info：获取与节点相关的最新信息 

eg:

请求：  ` $ curl http://127.0.0.1:8888/v1/chain/get_info `

返回结果：

```json
{ "server_version": "b2eb1667", "head_block_num": 259590, "last_irreversible_block_num": 259573, "head_block_id": "0003f60677f3707f0704f16177bf5f007ebd45eb6efbb749fb1c468747f72046", "head_block_time": "2017-12-10T17:05:36", "head_block_producer": "initp", "recent_slots": "1111111111111111111111111111111111111111111111111111111111111111", "participation_rate": "1.00000000000000000" }
```

### get_block： 获取区块信息

eg:

请求：

1. 根据块号获取：

   ` $ curl  http://127.0.0.1:8888/v1/chain/get_block -X POST -d '{"block_num_or_id":5}'`

2. 根块hash获取：

   `$ curl  http://127.0.0.1:8888/v1/chain/get_block -X POST -d '{"block_num_or_id":0000000445a9f27898383fd7de32835d5d6a978cc14ce40d9f327b5329de796b}'`

返回结果：

```json
{
  "previous": "0000000445a9f27898383fd7de32835d5d6a978cc14ce40d9f327b5329de796b",
  "timestamp": "2017-07-18T20:16:36",
  "transaction_merkle_root": "0000000000000000000000000000000000000000000000000000000000000000",
  "producer": "initf",
  "producer_changes": [ ],
  "producer_signature": "204cb94b3186c3b4a7f88be4e9db9f8af2ffdb7ef0f27a065c8177a5fcfacf876f684e59c39fb009903c0c59220b147bb07f1144df1c65d26c57b534a76dd29073",
  "cycles": [ ],
  "id":"000000050c0175cbf218a70131ddc3c3fab8b6e954edef77e0bfe7c36b599b1d",
  "block_num":5,
  "ref_block_prefix":27728114
}
```

### get_account：获取账户的信息 

eg:

请求：`$ curl  http://127.0.0.1:8888/v1/chain/get_account -X POST -d '{"account_name":"inita"}' `

请求结果：

```json
{
  "name": "inita",
  "eos_balance": "999998.9574 EOS",
  "staked_balance": "0.0000 EOS",
  "unstaking_balance": "0.0000 EOS",
  "last_unstaking_time": "2106-02-07T06:28:15",
  "permissions": [
    {
      "name": "active",
      "parent": "owner",
      "required_auth": {
        "threshold": 1,
        "keys": [
          {
            "key": "EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV",
            "weight": 1
          }
        ],
        "accounts": []
      }
    },
    {
      "name": "owner",
      "parent": "owner",
      "required_auth": {
        "threshold": 1,
        "keys": [
          {
            "key": "EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV",
            "weight": 1
          }
        ],
        "accounts": []
      }
    }
  ]
}
```

### get_code：获取智能合约代码 

eg:

请求：`$ curl  http://127.0.0.1:8888/v1/chain/get_code -X POST -d '{"account_name":"currency"}' `

请求结果：

```json
{
  "name":"currency",
  "code_hash":"a1c8c84b4700c09c8edb83522237439e33cf011a4d7ace51075998bd002e04c9",
  "wast":"(module\n  (type $0 (func (param i64 i64 i32) (result i32)))\n ...truncated",
  "abi": {
  "types": [{
      "new_type_name": "account_name",
      "type": "name"
    }
  ],
  "structs": [{
      "name": "transfer",
      "base": "",
      "fields": [
        {"name":"from", "type":"account_name"},
        {"name":"to", "type":"account_name"},
        {"name":"quantity", "type":"uint64"}
      ]
    },{
      "name": "account",
      "base": "",
      "fields": [
        {"name":"key", "type":"name"},
        {"name":"balance", "type":"uint64"}
      ]
    }
  ],
  "actions": [{
      "name": "transfer",
      "type": "transfer"
    }
  ],
  "tables": [{
      "name": "account",
      "type": "account",
      "index_type": "i64",
      "key_names" : ["key"],
      "key_types" : ["name"]
    }
  ]
  }
}
```


