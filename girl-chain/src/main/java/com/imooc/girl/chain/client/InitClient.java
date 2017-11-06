package com.imooc.girl.chain.client;

import com.chain.api.Account;
import com.chain.api.Asset;
import com.chain.api.MockHsm;
import com.chain.api.Transaction;
import com.chain.exception.ChainException;
import com.chain.http.Client;
import com.chain.signing.HsmSigner;

import java.util.Arrays;

/**
 * 1 client
 * 2 key
 * 3 hsm signer
 * === asset ===
 * 4 asset 资产
 * === account ===
 * 5 account 账户
 * === transaction ===
 * 6 issue 发行
 * 7 spend 花费
 * 8 retire 收回
 * Created by hmh on 2017/9/11.
 */
public class InitClient {
    public static void main(String[] args) throws ChainException {
        // 1、Initialize the SDK
        Client client = new Client();

        // 2、Create Keys
        MockHsm.Key key = MockHsm.Key.create(client);

        // 3、Initialize the HSM Signer
        HsmSigner.addKey(key, MockHsm.getSignerClient(client));

        // 4、Create an Asset(资产)
        new Asset.Builder()
                .setAlias("gold")
                .addRootXpub(key.xpub)
                .setQuorum(1)
                .create(client);

        // 5、Create an Account
        new Account.Builder()
                .setAlias("alice")
                .setRootXpubs(Arrays.asList(key.xpub))
                .setQuorum(1)
                .create(client);
        new Account.Builder()
                .setAlias("bob")
                .addRootXpub(key.xpub)
                .setQuorum(1)
                .create(client);

        // 6、Issue Asset Units(发行 资产单位)
        // Transaction(交易) Amount(总额)
        Transaction.Action.Issue issue = new Transaction.Action.Issue()
                .setAssetAlias("gold")
                .setAmount(100);
        Transaction.Action.ControlWithAccount control = new Transaction.Action.ControlWithAccount()
                .setAccountAlias("alice")
                .setAssetAlias("gold")
                .setAmount(100);

        Transaction.Template issuance = new Transaction.Builder()
                .addAction(issue)
                .addAction(control)
                .build(client);

//        Transaction.submit(client, HsmSigner.sign(issuance));

        // 7、Spend Asset Units spend(花费)
        Transaction.Action.SpendFromAccount spendFromAccount1 = new Transaction.Action.SpendFromAccount()
                .setAccountAlias("alice")
                .setAssetAlias("gold")
                .setAmount(10);
        Transaction.Action.ControlWithAccount controlWithAccount1 = new Transaction.Action.ControlWithAccount()
                .setAccountAlias("bob")
                .setAssetAlias("gold")
                .setAmount(10);

        Transaction.Template spending = new Transaction.Builder()
                .addAction(spendFromAccount1)
                .addAction(controlWithAccount1)
                .build(client);

        Transaction.submit(client, HsmSigner.sign(spending));

        // 8、Retire Asset Units retire(收回)
        Transaction.Action.SpendFromAccount spendFromAccount2 = new Transaction.Action.SpendFromAccount()
                .setAccountAlias("bob")
                .setAssetAlias("gold")
                .setAmount(6);
        Transaction.Action.Retire retire = new Transaction.Action.Retire()
                .setAssetAlias("gold")
                .setAmount(6);

        Transaction.Template retirement = new Transaction.Builder()
                .addAction(spendFromAccount2)
                .addAction(retire)
                .build(client);

//        Transaction.submit(client, HsmSigner.sign(retirement));
    }
}
