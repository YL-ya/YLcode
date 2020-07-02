/**
 * @author: YL
 * @fileName:Key_RSA.java,
 * @version:1.0
 * @function: 实现RSA密钥对的生成、对数据的加密解密，密钥的获取
 */
package server;

import java.security.*;
import javax.crypto.*;

public class SKey_RSA {

    public SKey_RSA() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//指定采用的算法
        kpg.initialize(1024);//密钥为1024位
        KeyPair kp = kpg.genKeyPair();//生成密钥对
        pbkey = kp.getPublic();// 返回对此密钥对的公钥组件的引用
        prkey = kp.getPrivate();//返回对此密钥对的私钥组件的引用
    }

    public static byte[] wrapkey(Key key, PublicKey publicKey)
            throws Exception {//��publickey4��װDES,��װ�Ľ����һ��byte[]
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.WRAP_MODE, publicKey);
        return (cipher.wrap(key));
    }

    public static Key unwrapkey(
            byte[] wrapedkey,
            PrivateKey privateKey,
            String wrappedKeyAlgorithm,
            int wrappedKeyType) throws Exception {
        //��DES��˽Կ��RSA����
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, privateKey);
        return (cipher.unwrap(wrapedkey, wrappedKeyAlgorithm, wrappedKeyType));
    }

    public PublicKey getPublicKey() {
        return pbkey;
    }

    public PrivateKey getPrivateKey() {
        return prkey;
    }
    private PublicKey pbkey;
    private PrivateKey prkey;
}