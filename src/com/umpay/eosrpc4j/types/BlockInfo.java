package com.umpay.eosrpc4j.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class BlockInfo {
    public String timestamp;
    public String producer;
    public long confirmed;
    public String previous;
    public String transaction_mroot;
    public String action_mroot;
    public long schedule_version;
    public List<String> new_producers;
    public List<String> header_extensions;
    public String producer_signature;
    public List<BlockTransaction> transactions;
    public List<String> block_extensions;

    @JsonIgnore
    public String regions;

    @JsonIgnore
    public String input_transactions;
    public String id;
    public long block_num;
    public long ref_block_prefix;

    @Override
    public String toString() {
        return "BlockInfo{" +
                "timestamp='" + timestamp + '\'' +
                ", producer='" + producer + '\'' +
                ", confirmed=" + confirmed +
                ", previous='" + previous + '\'' +
                ", transaction_mroot='" + transaction_mroot + '\'' +
                ", action_mroot='" + action_mroot + '\'' +
                ", schedule_version=" + schedule_version +
                ", new_producers=" + new_producers +
                ", header_extensions=" + header_extensions +
                ", producer_signature='" + producer_signature + '\'' +
                ", transactions=" + transactions +
                ", block_extensions=" + block_extensions +
                ", regions='" + regions + '\'' +
                ", input_transactions='" + input_transactions + '\'' +
                ", id='" + id + '\'' +
                ", block_num=" + block_num +
                ", ref_block_prefix=" + ref_block_prefix +
                '}';
    }

    public static class BlockTransaction extends Transaction {
        public String status;
        public long cpu_usage_us;
        public long net_usage_words;
        public TransactionInfo trx;
    }

    public static class TransactionInfo {
        public String id;
        public List<String> signatures;
        public String compression;
        public String packed_context_free_data;
        public List<String> context_free_data;
        public String packed_trx;
        public Transaction transaction;
    }

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getTransaction_mroot() {
		return transaction_mroot;
	}

	public void setTransaction_mroot(String transaction_mroot) {
		this.transaction_mroot = transaction_mroot;
	}

	public String getAction_mroot() {
		return action_mroot;
	}

	public void setAction_mroot(String action_mroot) {
		this.action_mroot = action_mroot;
	}

	public long getSchedule_version() {
		return schedule_version;
	}

	public void setSchedule_version(long schedule_version) {
		this.schedule_version = schedule_version;
	}

	public List<String> getNew_producers() {
		return new_producers;
	}

	public void setNew_producers(List<String> new_producers) {
		this.new_producers = new_producers;
	}

	public List<String> getHeader_extensions() {
		return header_extensions;
	}

	public void setHeader_extensions(List<String> header_extensions) {
		this.header_extensions = header_extensions;
	}

	public String getProducer_signature() {
		return producer_signature;
	}

	public void setProducer_signature(String producer_signature) {
		this.producer_signature = producer_signature;
	}

	public List<BlockTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BlockTransaction> transactions) {
		this.transactions = transactions;
	}

	public List<String> getBlock_extensions() {
		return block_extensions;
	}

	public void setBlock_extensions(List<String> block_extensions) {
		this.block_extensions = block_extensions;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public String getInput_transactions() {
		return input_transactions;
	}

	public void setInput_transactions(String input_transactions) {
		this.input_transactions = input_transactions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getBlock_num() {
		return block_num;
	}

	public void setBlock_num(long block_num) {
		this.block_num = block_num;
	}

	public long getRef_block_prefix() {
		return ref_block_prefix;
	}

	public void setRef_block_prefix(long ref_block_prefix) {
		this.ref_block_prefix = ref_block_prefix;
	}
    
    
    
}
