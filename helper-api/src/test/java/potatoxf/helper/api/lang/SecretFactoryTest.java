package potatoxf.helper.api.lang;

import org.junit.Test;
import potatoxf.helper.api.HelperOnCodec;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;

public class SecretFactoryTest {
  String str =
      "19、public final byte[] update(byte[] input)  继续多部分加密或解密操作（具体取决于此 Cipher 的初始化方式），以处理其他数据部分。 处理 input 缓冲区中的字节，并将结果存储在新的缓冲区中。 如果 input 长度为 0，则此方法返回 null。\n"
          + "\n"
          + "20、public final byte[] update(byte[] input, int inputOffset,int inputLen)  继续多部分加密或解密操作（具体取决于此 Cipher 的初始化方式），以处理其他数据部分。\n"
          + "\n"
          + "21、public final int update(byte[] input, int inputOffset, int inputLen, byte[] output)  继续多部分加密或解密操作（具体取决于此 Cipher 的初始化方式），以处理其他数据部分。 处理 input 缓冲区中从 inputOffset 开始（包含）的前 inputLen 个字节，并将结果存储在 output 缓冲区中。\n"
          + "\n"
          + "如果 output 缓冲区太小无法保存该结果，则抛出 ShortBufferException。这种情况下，使用一个稍大的缓冲区再次调用。使用 getOutputSize 确定输出缓冲区应为多大。 如果 inputLen 为 0，则此方法返回的长度为 0。\n"
          + "\n"
          + "注：此方法应该是复制安全 (copy-safe) 的，这意味着 input 和 output 缓冲区可引用相同的 byte 数组，并且在将结果复制到输出缓冲区时，不会覆盖任何未处理的输入数据。\n"
          + "\n"
          + "22、public final int update(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset)  继续多部分加密或解密操作（具体取决于此 Cipher 的初始化方式），以处理其他数据部分。\n"
          + "\n"
          + "23、public final int update(ByteBuffer input, ByteBuffer output)  继续多部分加密或解密操作（具体取决于此 Cipher 的初始化方式），以处理其他数据部分。\n"
          + "\n"
          + "24、public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException  结束多部分加密或解密操作（具体取决于此 Cipher 的初始化方式）。\n"
          + "\n"
          + "处理在上一次 update 操作中缓存的输入数据，其中应用了填充（如果请求）。结果将存储在新缓冲区中。 结束时，此方法将此 Cipher 对象重置为上一次调用 init 初始化得到的状态。即该对象被重置，并可用于加密或解密（具体取决于调用 init 时指定的操作模式）更多的数据。\n"
          + "————————————————\n"
          + "版权声明：本文为CSDN博主「许小珊」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。\n"
          + "原文链接：https://blog.csdn.net/qq_29464887/article/details/78601300";

  @Test
  public void main1() throws Exception {

    SecretFactory rsa = new SecretFactory(SecretFactory.AlgorithmType.RSA, 512, true);

    SecretService privateSecretService = rsa.getPrivateAsymmetricEncryptionService();
    SecretService publicSecretService = rsa.getPublicAsymmetricEncryptionService();

    KeyPair keyPair = rsa.generatePairKey();
    byte[] privateKey = keyPair.getPrivate().getEncoded();
    byte[] publicKey = keyPair.getPublic().getEncoded();

    System.out.println("公钥：" + HelperOnCodec.base64EncodeDataToString(publicKey));
    System.out.println("私钥：" + HelperOnCodec.base64EncodeDataToString(privateKey));

    System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");

    System.out.println("===========甲方向乙方发送加密数据==============");
    System.out.println("原文:" + str);
    // 甲方进行数据的加密
    byte[] code1 = publicSecretService.encrypt(str.getBytes(StandardCharsets.UTF_8), publicKey);
    System.out.println("甲方 使用乙方公钥加密后的数据：" + HelperOnCodec.base64EncodeDataToString(code1));
    System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
    // 乙方进行数据的解密
    // byte[] decode1=RSACoder.decryptByPublicKey(code1, publicKey);
    byte[] decode1 = privateSecretService.decrypt(code1, privateKey);
    System.out.println("乙方解密后的数据：" + new String(decode1, StandardCharsets.UTF_8) + "");
  }

  @Test
  public void main2() throws Exception {

    SecretFactory aes = new SecretFactory(SecretFactory.AlgorithmType.DES, 512, true);

    SecretService secretService = aes.getSymmetricEncryptionService();

    SecretKey secretKey = aes.generateSecretKey();
    byte[] key = secretKey.getEncoded();

    System.out.println("密钥：" + HelperOnCodec.base64EncodeDataToString(key));

    System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
    System.out.println("===========甲方向乙方发送加密数据==============");
    System.out.println("原文:" + str);
    // 甲方进行数据的加密
    byte[] code1 = secretService.encrypt(str.getBytes(StandardCharsets.UTF_8), key);
    System.out.println("甲方 使用乙方公钥加密后的数据：" + HelperOnCodec.base64EncodeDataToString(code1));
    System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
    // 乙方进行数据的解密
    byte[] decode1 = secretService.decrypt(code1, key);
    System.out.println("乙方解密后的数据：" + new String(decode1, StandardCharsets.UTF_8) + "");
  }
}
