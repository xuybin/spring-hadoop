package people.data.hadoop.model;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PersonInfo {
    public static final String tableName="RHZY:PersonalInfo";
    public static final String family="PI";
    public static byte[] family(){ return Bytes.toBytes(family); }
    public static byte[] p0101() { return Bytes.toBytes("p0101"); }
    public static byte[] h0104() { return Bytes.toBytes("h0104"); }
    public static byte[] p0103() { return Bytes.toBytes("p0103"); }
    public static byte[] p0104() { return Bytes.toBytes("p0104"); }
    public static byte[] p0105() { return Bytes.toBytes("p0105"); }
    public static byte[] p0106() { return Bytes.toBytes("p0106"); }
    public static byte[] p0107() { return Bytes.toBytes("p0107"); }
    public static byte[] p0108() { return Bytes.toBytes("p0108"); }
    public static byte[] p0109() { return Bytes.toBytes("p0109"); }
    public static byte[] p0110() { return Bytes.toBytes("p0110"); }
    public static byte[] p0111() { return Bytes.toBytes("p0111"); }
    public static byte[] p0112() { return Bytes.toBytes("p0112"); }
    public static byte[] p0113() { return Bytes.toBytes("p0113"); }
    public static byte[] p0114() { return Bytes.toBytes("p0114"); }
    public static byte[] p0115() { return Bytes.toBytes("p0115"); }
    public static byte[] p0116() { return Bytes.toBytes("p0116"); }
    public static byte[] p0117() { return Bytes.toBytes("p0117"); }
    public static byte[] p0118() { return Bytes.toBytes("p0118"); }
    public static byte[] p0119() { return Bytes.toBytes("p0119"); }
    public static byte[] p0120() { return Bytes.toBytes("p0120"); }
    public static byte[] p0121() { return Bytes.toBytes("p0121"); }
    public static byte[] p0122() { return Bytes.toBytes("p0122"); }
    public static byte[] p0123() { return Bytes.toBytes("p0123"); }
    public static byte[] p0124() { return Bytes.toBytes("p0124"); }
    public static byte[] p0125() { return Bytes.toBytes("p0125"); }
    public static byte[] p0126() { return Bytes.toBytes("p0126"); }
    public static byte[] p0127() { return Bytes.toBytes("p0127"); }
    public static byte[] p0128() { return Bytes.toBytes("p0128"); }
    public static byte[] p0129() { return Bytes.toBytes("p0129"); }
    public static byte[] p0130() { return Bytes.toBytes("p0130"); }
    public static byte[] p0131() { return Bytes.toBytes("p0131"); }
    public static byte[] p0132() { return Bytes.toBytes("p0132"); }
    public static byte[] p0133() { return Bytes.toBytes("p0133"); }
    public static byte[] p0134() { return Bytes.toBytes("p0134"); }
    public static byte[] p0135() { return Bytes.toBytes("p0135"); }
    public static byte[] p0136() { return Bytes.toBytes("p0136"); }
    public static byte[] p0137() { return Bytes.toBytes("p0137"); }
    public static byte[] p0138() { return Bytes.toBytes("p0138"); }


    String rowKey;
    String p0101;
    String h0104;
    String p0103;
    String p0104;
    String p0105;
    String p0106;
    String p0107;
    String p0108;
    String p0109;
    String p0110;
    String p0111;
    String p0112;
    String p0113;
    String p0114;
    String p0115;
    String p0116;
    String p0117;
    String p0118;
    String p0119;
    String p0120;
    String p0121;
    String p0122;
    String p0123;
    String p0124;
    String p0125;
    String p0126;
    String p0127;
    String p0128;
    String p0129;
    String p0130;
    String p0131;
    String p0132;
    String p0133;
    String p0134;
    String p0135;
    String p0136;
    String p0137;
    String p0138;

    private static String key="RHZY@HBase";
    public static String encryptHmac(String key, String data){
        try {
            SecretKey secretKey = new SecretKeySpec(Bytes.toBytes(key), "HmacMD5");
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(secretKey);
            byte[] resultBytes = mac.doFinal(Bytes.toBytes(data));
            String resultString = StringUtils.byteToHexString(resultBytes);
            return resultString;
        }catch (Exception ex){
            return null;
        }
    }

    public String getRowKey() {
        if(rowKey==null && p0101!=null){
            return encryptHmac(key,p0101);
        }
        return rowKey;
    }

    public PersonInfo setRowKey(String rowKey) {
        this.rowKey = rowKey;
        return this;
    }

    public String getP0101() {
        return p0101;
    }

    public PersonInfo setP0101(String p0101) {
        this.p0101 = p0101;
        return this;
    }

    public String getH0104() {
        return h0104;
    }

    public PersonInfo setH0104(String h0104) {
        this.h0104 = h0104;
        return this;
    }

    public String getP0103() {
        return p0103;
    }

    public PersonInfo setP0103(String p0103) {
        this.p0103 = p0103;
        return this;
    }

    public String getP0104() {
        return p0104;
    }

    public PersonInfo setP0104(String p0104) {
        this.p0104 = p0104;
        return this;
    }

    public String getP0105() {
        return p0105;
    }

    public PersonInfo setP0105(String p0105) {
        this.p0105 = p0105;
        return this;
    }

    public String getP0106() {
        return p0106;
    }

    public PersonInfo setP0106(String p0106) {
        this.p0106 = p0106;
        return this;
    }

    public String getP0107() {
        return p0107;
    }

    public PersonInfo setP0107(String p0107) {
        this.p0107 = p0107;
        return this;
    }

    public String getP0108() {
        return p0108;
    }

    public PersonInfo setP0108(String p0108) {
        this.p0108 = p0108;
        return this;
    }

    public String getP0109() {
        return p0109;
    }

    public PersonInfo setP0109(String p0109) {
        this.p0109 = p0109;
        return this;
    }

    public String getP0110() {
        return p0110;
    }

    public PersonInfo setP0110(String p0110) {
        this.p0110 = p0110;
        return this;
    }

    public String getP0111() {
        return p0111;
    }

    public PersonInfo setP0111(String p0111) {
        this.p0111 = p0111;
        return this;
    }

    public String getP0112() {
        return p0112;
    }

    public PersonInfo setP0112(String p0112) {
        this.p0112 = p0112;
        return this;
    }

    public String getP0113() {
        return p0113;
    }

    public PersonInfo setP0113(String p0113) {
        this.p0113 = p0113;
        return this;
    }

    public String getP0114() {
        return p0114;
    }

    public PersonInfo setP0114(String p0114) {
        this.p0114 = p0114;
        return this;
    }

    public String getP0115() {
        return p0115;
    }

    public PersonInfo setP0115(String p0115) {
        this.p0115 = p0115;
        return this;
    }

    public String getP0116() {
        return p0116;
    }

    public PersonInfo setP0116(String p0116) {
        this.p0116 = p0116;
        return this;
    }

    public String getP0117() {
        return p0117;
    }

    public PersonInfo setP0117(String p0117) {
        this.p0117 = p0117;
        return this;
    }

    public String getP0118() {
        return p0118;
    }

    public PersonInfo setP0118(String p0118) {
        this.p0118 = p0118;
        return this;
    }

    public String getP0119() {
        return p0119;
    }

    public PersonInfo setP0119(String p0119) {
        this.p0119 = p0119;
        return this;
    }

    public String getP0120() {
        return p0120;
    }

    public PersonInfo setP0120(String p0120) {
        this.p0120 = p0120;
        return this;
    }

    public String getP0121() {
        return p0121;
    }

    public PersonInfo setP0121(String p0121) {
        this.p0121 = p0121;
        return this;
    }

    public String getP0122() {
        return p0122;
    }

    public PersonInfo setP0122(String p0122) {
        this.p0122 = p0122;
        return this;
    }

    public String getP0123() {
        return p0123;
    }

    public PersonInfo setP0123(String p0123) {
        this.p0123 = p0123;
        return this;
    }

    public String getP0124() {
        return p0124;
    }

    public PersonInfo setP0124(String p0124) {
        this.p0124 = p0124;
        return this;
    }

    public String getP0125() {
        return p0125;
    }

    public PersonInfo setP0125(String p0125) {
        this.p0125 = p0125;
        return this;
    }

    public String getP0126() {
        return p0126;
    }

    public PersonInfo setP0126(String p0126) {
        this.p0126 = p0126;
        return this;
    }

    public String getP0127() {
        return p0127;
    }

    public PersonInfo setP0127(String p0127) {
        this.p0127 = p0127;
        return this;
    }

    public String getP0128() {
        return p0128;
    }

    public PersonInfo setP0128(String p0128) {
        this.p0128 = p0128;
        return this;
    }

    public String getP0129() {
        return p0129;
    }

    public PersonInfo setP0129(String p0129) {
        this.p0129 = p0129;
        return this;
    }

    public String getP0130() {
        return p0130;
    }

    public PersonInfo setP0130(String p0130) {
        this.p0130 = p0130;
        return this;
    }

    public String getP0131() {
        return p0131;
    }

    public PersonInfo setP0131(String p0131) {
        this.p0131 = p0131;
        return this;
    }

    public String getP0132() {
        return p0132;
    }

    public PersonInfo setP0132(String p0132) {
        this.p0132 = p0132;
        return this;
    }

    public String getP0133() {
        return p0133;
    }

    public PersonInfo setP0133(String p0133) {
        this.p0133 = p0133;
        return this;
    }

    public String getP0134() {
        return p0134;
    }

    public PersonInfo setP0134(String p0134) {
        this.p0134 = p0134;
        return this;
    }

    public String getP0135() {
        return p0135;
    }

    public PersonInfo setP0135(String p0135) {
        this.p0135 = p0135;
        return this;
    }

    public String getP0136() {
        return p0136;
    }

    public PersonInfo setP0136(String p0136) {
        this.p0136 = p0136;
        return this;
    }

    public String getP0137() {
        return p0137;
    }

    public PersonInfo setP0137(String p0137) {
        this.p0137 = p0137;
        return this;
    }

    public String getP0138() {
        return p0138;
    }

    public PersonInfo setP0138(String p0138) {
        this.p0138 = p0138;
        return this;
    }
}
