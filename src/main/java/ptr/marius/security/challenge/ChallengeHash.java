package ptr.marius.security.challenge;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class ChallengeHash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        byte [] code = new byte[32];
        secureRandom.nextBytes(code);
        String verifier = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(code);

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte [] digested = messageDigest.digest(verifier.getBytes());
        String codeChallenge = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(digested);
    }
}
