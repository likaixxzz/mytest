import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.util.encoders.Hex;

public class test {
    private int key = 11169;

    public static void main(String[] args) {
        int a = 123456;
        test test = new test();




    /*    int encryption = test.encryption(a);
        test.decrypt(encryption);
*/

    /*    System.out.println("���� = " + a);
        System.out.println("���� = " + test.likai(a));
        System.out.println("���� = " + test.likai(test.likai(a)));
*/


     /*   System.out.println("� = " + (a + "�").hashCode());
        System.out.println("���� = " + (a + "����").hashCode());
        System.out.println("���� = " + (a + "����").hashCode());
        System.out.println("���� = " + (a + "����").hashCode());
*/

       String salt1 = "�";
        String salt2 = "����";
        String salt3 = "����";
        String salt4 = "����";
        String s1 = test.sha3224(a + salt1);
        String s2 = test.sha3224(a + salt2);
        String s3 = test.sha3224(a + salt3);
        String s4 = test.sha3224(a + salt4);
        System.out.println("������� = " + s1);
        System.out.println("���������� = " + s2);
        System.out.println("���ĵ����� = " + s3);
        System.out.println("��������� = " + s4);
        System.out.println("���¼��  " + (s1.equals(test.sha3224(123456 + salt1))?"��¼�ɹ�":"��¼ʧ��"));



        
    }

    public int encryption(int a) {
        System.out.println("ʮ�������� = " + a);
        String s = Integer.toBinaryString(a);
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(key));
        for (int i = 0; i < s.length() - s1.length(); ) {
            s1.insert(0, "0");
        }
        System.out.println("���� = " + s);
        System.out.println("��Կ = " + s1);
        int c = a ^ key;
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(c));
        for (int i = 0; i < s.length() - s2.length();) {
            s2.insert(0, "0");
        }
        System.out.println("���� = " + s2);
        System.out.println("ʮ�������� = " + c);
        return c;
    }

    public int decrypt(int a) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(a));
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(key));
        if (s.length() > s1.length()) {
            for (int i = 0; i < s.length() - s1.length(); ) {
                s1.insert(0, "0");
            }
        } else {
            for (int i = 0; i < s1.length() - s.length(); ) {
                s.insert(0, "0");
            }
        }
        System.out.println("���� = " + s);
        System.out.println("��Կ = " + s1);
        int c = a ^ key;
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(c));
        for (int i = 0; i < s.length() - s2.length(); i++) {
            s2.insert(0, "0");
        }
        System.out.println("���� = " + s2);
        System.out.println("ʮ�������� = " + c);
        return c;
    }

    public int likai(int a) {
        return a ^ key;
    }

    public int Irreversible(Object o) {
        return o.hashCode();
    }

    public String sha3224(String password) {
        byte[] bytes = password.getBytes();
        SHA3Digest digest = new SHA3Digest(224);
        digest.update(bytes, 0, bytes.length);
        byte[] rsData = new byte[digest.getDigestSize()];
        digest.doFinal(rsData, 0);
        return Hex.toHexString(rsData);

    }
}
