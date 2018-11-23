package com.umpay.eosrpc4j.types;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.umpay.eosrpc4j.util.Base32;
import com.umpay.eosrpc4j.util.EOSByteWriter;

import org.bouncycastle.util.encoders.Hex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class Transaction {

    public String expiration;
    public long ref_block_num;
    public long ref_block_prefix;
    public int max_net_usage_words;
    public int max_cpu_usage_ms;
    public int delay_sec;
    public List<String> context_free_actions = new ArrayList<String>();
    public List<Action> actions = new ArrayList<Action>();
    public List<String> transaction_extensions = new ArrayList<String>();
    public List<String> signatures = new ArrayList<String>();
    public List<String> context_free_data = new ArrayList<String>();

    protected Transaction() {
    }

    public Transaction(String expiration,
                       long ref_block_num,
                       long ref_block_prefix,
                       int max_net_usage_words,
                       int max_cpu_usage_ms,
                       int delay_sec,
                       List<String> context_free_actions,
                       List<Action> actions,
                       List<String> transaction_extensions,
                       List<String> signatures,
                       List<String> context_free_data) {
        this.expiration = expiration;
        this.ref_block_num = ref_block_num;
        this.ref_block_prefix = ref_block_prefix;
        this.max_net_usage_words = max_net_usage_words;
        this.max_cpu_usage_ms = max_cpu_usage_ms;
        this.delay_sec = delay_sec;
        this.context_free_actions = (context_free_actions != null ? context_free_actions : new ArrayList<String>());
        this.actions = (actions != null ? actions : new ArrayList<Action>());
        this.transaction_extensions = (transaction_extensions != null ? transaction_extensions : new ArrayList<String>());
        this.signatures = (signatures != null ? signatures : new ArrayList<String>());
        this.context_free_data = (context_free_data != null ? context_free_data : new ArrayList<String>());
    }

    public void pack(EOSByteWriter writer) throws ParseException {
        // Pack the Transaction Header
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(tz);
        Date expirationDate = sdf.parse(expiration);
        int expSecs = (int) (expirationDate.getTime() / 1000);
        writer.putInt(expSecs);
        writer.putShort((short) (ref_block_num & 0xFFFF));
        writer.putInt((int) (ref_block_prefix & 0xFFFFFFFF));
        writer.putVariableUInt(max_net_usage_words);
        writer.putVariableUInt(max_cpu_usage_ms);
        writer.putVariableUInt(delay_sec);

        // Pack the Context Free Actions
        writer.putVariableUInt(0);

        // Pack the Actions
        writer.putVariableUInt(actions.size());
        for (Transaction.Action action : actions) {
            action.pack(writer);
        }

        // Pack the Transaction Extensions
        writer.putVariableUInt(0);

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "expiration='" + expiration + '\'' +
                ", ref_block_num='" + ref_block_num + '\'' +
                ", ref_block_prefix='" + ref_block_prefix + '\'' +
                ", max_net_usage_words=" + max_net_usage_words +
                ", max_cpu_usage_ms=" + max_cpu_usage_ms +
                ", delay_sec=" + delay_sec +
                ", context_free_actions=" + context_free_actions +
                ", actions=" + actions +
                ", transaction_extensions=" + transaction_extensions +
                ", signatures=" + signatures +
                ", context_free_data=" + context_free_data +
                '}';
    }


    public static class Action {
        public String account;
        public String name;
        public List<Authorization> authorization;
        public Object data;

        public Action() {
        }

        public Action(String account, String name, List<Authorization> authorization, String data) {
            this.account = account;
            this.name = name;
            this.authorization = authorization;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "account='" + account + '\'' +
                    ", name='" + name + '\'' +
                    ", authorization=" + authorization +
                    ", data='" + data + '\'' +
                    '}';
        }

        public void pack(EOSByteWriter writer) {
            // Base32 decode the account and name to long's.
            long accountLong = Base32.decode(account);
            long nameLong = Base32.decode(name);

            writer.putLong(accountLong);
            writer.putLong(nameLong);

            // Serialize the Authorizations
            writer.putVariableUInt(authorization.size());
            for (Transaction.Authorization auth : authorization) {
                auth.pack(writer);
            }

            byte[] decodedData = Hex.decode(data.toString());
            writer.putVariableUInt(decodedData.length);
            writer.putBytes(decodedData);
        }

    }

    public static class Authorization {
        public String actor;
        public String permission;

        public Authorization() {
        }

        public Authorization(String actor, String permission) {
            this.actor = actor;
            this.permission = permission;
        }

        public void pack(EOSByteWriter writer) {
            // Base32 decode the account and permission to long's.
            long actorLong = Base32.decode(actor);
            long permLong = Base32.decode(permission);

            writer.putLong(actorLong);
            writer.putLong(permLong);
        }

        @Override
        public String toString() {
            return "Authorization{" +
                    "actor='" + actor + '\'' +
                    ", permission='" + permission + '\'' +
                    '}';
        }
    }

    public static class Response {
        public String transaction_id;
        public Map<String, Object> processed;

        @Override
        public String toString() {
            return "Response{" +
                    "transaction_id='" + transaction_id + '\'' +
                    ", processed=" + processed +
                    '}';
        }
    }

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public long getRef_block_num() {
		return ref_block_num;
	}

	public void setRef_block_num(long ref_block_num) {
		this.ref_block_num = ref_block_num;
	}

	public long getRef_block_prefix() {
		return ref_block_prefix;
	}

	public void setRef_block_prefix(long ref_block_prefix) {
		this.ref_block_prefix = ref_block_prefix;
	}

	public int getMax_net_usage_words() {
		return max_net_usage_words;
	}

	public void setMax_net_usage_words(int max_net_usage_words) {
		this.max_net_usage_words = max_net_usage_words;
	}

	public int getMax_cpu_usage_ms() {
		return max_cpu_usage_ms;
	}

	public void setMax_cpu_usage_ms(int max_cpu_usage_ms) {
		this.max_cpu_usage_ms = max_cpu_usage_ms;
	}

	public int getDelay_sec() {
		return delay_sec;
	}

	public void setDelay_sec(int delay_sec) {
		this.delay_sec = delay_sec;
	}

	public List<String> getContext_free_actions() {
		return context_free_actions;
	}

	public void setContext_free_actions(List<String> context_free_actions) {
		this.context_free_actions = context_free_actions;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<String> getTransaction_extensions() {
		return transaction_extensions;
	}

	public void setTransaction_extensions(List<String> transaction_extensions) {
		this.transaction_extensions = transaction_extensions;
	}

	public List<String> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<String> signatures) {
		this.signatures = signatures;
	}

	public List<String> getContext_free_data() {
		return context_free_data;
	}

	public void setContext_free_data(List<String> context_free_data) {
		this.context_free_data = context_free_data;
	}

}
