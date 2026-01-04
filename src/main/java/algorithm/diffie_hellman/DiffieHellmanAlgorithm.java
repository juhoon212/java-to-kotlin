package algorithm.diffie_hellman;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellmanAlgorithm {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        // 공개 파라미터
        BigInteger p = BigInteger.probablePrime(2048, random);
        BigInteger g = BigInteger.valueOf(2);

        // Alice 비밀키
        BigInteger a = BigInteger.probablePrime(2048, random);
        BigInteger A = g.modPow(a, p); // g^a % p -> 공개파라미터 g값을 해당 공식으로 뽑아낸 결과값을 A라고 칭한다.

        // Bob 비밀키
        BigInteger b = BigInteger.probablePrime(2048, random);
        BigInteger B = g.modPow(b, p); // g^b % p -> 공개파라미터 g값을 해당 공식으로 뽑아낸 결과값을 B라고 한다.

        // 공유 비밀키
        BigInteger aliceSharedKey = B.modPow(a, p); // g^(ab) % p
        BigInteger bobSharedKey = A.modPow(b, p); // g^(ab) % p

        // A와 B는 서로 공유한다.(공개키)
        // a, b는 서로 교환하지 않는다.
        System.out.println(" Alice Key = " + aliceSharedKey);
        System.out.println(" Bob Key = " + bobSharedKey);
        System.out.println("Same? = " + aliceSharedKey.equals(bobSharedKey));
    }
}
