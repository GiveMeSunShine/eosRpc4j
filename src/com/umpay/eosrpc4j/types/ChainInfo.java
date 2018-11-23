package com.umpay.eosrpc4j.types;

public class ChainInfo {
    public String server_version;
    public String chain_id;
    public long head_block_num;
    public long last_irreversible_block_num;
    public String last_irreversible_block_id;
    public String head_block_id;
    public String head_block_time;
    public String head_block_producer;
    public long virtual_block_cpu_limit;
    public long virtual_block_net_limit;
    public long block_cpu_limit;
    public long block_net_limit;

    @Override
    public String toString() {
        return "ChainInfo{" +
                "server_version='" + server_version + '\'' +
                ", chain_id='" + chain_id + '\'' +
                ", head_block_num=" + head_block_num +
                ", last_irreversible_block_num=" + last_irreversible_block_num +
                ", last_irreversible_block_id=" + last_irreversible_block_id +
                ", head_block_id='" + head_block_id + '\'' +
                ", head_block_time='" + head_block_time + '\'' +
                ", head_block_producer='" + head_block_producer + '\'' +
                ", virtual_block_cpu_limit=" + virtual_block_cpu_limit +
                ", virtual_block_net_limit=" + virtual_block_net_limit +
                ", block_cpu_limit=" + block_cpu_limit +
                ", block_net_limit=" + block_net_limit +
                '}';
    }
}
