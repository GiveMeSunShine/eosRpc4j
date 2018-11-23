import java.net.MalformedURLException;
import java.net.URL;

import com.umpay.eosrpc4j.EOSRPCAdapter;
import com.umpay.eosrpc4j.RPCChain;
import com.umpay.eosrpc4j.types.BlockInfo;


public class MyTest {
	public static void main(String[] args) throws Exception {
		URL nodeURL = new URL("http://10.10.144.10:8888");
		URL walletURL = new URL("http://10.10.144.10:8888");
		EOSRPCAdapter adapter = new EOSRPCAdapter(nodeURL, walletURL);
		RPCChain chain = new RPCChain(nodeURL, adapter);
		for(int i = 1; i<1001;i++){
			BlockInfo bi = chain.getBlock(i+"");
			System.out.println(bi);
			if(bi.getTransactions().size() > 0){
				System.out.println(bi.getTransactions());
				break;
			}
		}
		
	}
}
