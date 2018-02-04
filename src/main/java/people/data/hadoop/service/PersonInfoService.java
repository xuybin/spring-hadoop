package people.data.hadoop.service;


import io.netty.util.internal.StringUtil;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;
import people.data.hadoop.model.PersonInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInfoService {
    @Autowired
    private HbaseTemplate hbaseTemplate;
    RowMapper<PersonInfo> rowMapperAll=new RowMapper<PersonInfo>() {
        @Override
        public PersonInfo mapRow(Result result, int i) throws Exception {
            if(result.isEmpty()){
                return null;
            }else {
                return new PersonInfo()
                        .setRowKey(Bytes.toString(result.getRow()))
                        .setP0101(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0101())))
                        .setH0104(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.h0104())))
                        .setP0103(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0103())))
                        .setP0104(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0104())))
                        .setP0105(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0105())))
                        .setP0106(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0106())))
                        .setP0107(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0107())))
                        .setP0108(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0108())))
                        .setP0109(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0109())))
                        .setP0110(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0110())))
                        .setP0111(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0111())))
                        .setP0112(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0112())))
                        .setP0113(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0113())))
                        .setP0114(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0114())))
                        .setP0115(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0115())))
                        .setP0116(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0116())))
                        .setP0117(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0117())))
                        .setP0118(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0118())))
                        .setP0119(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0119())))
                        .setP0120(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0120())))
                        .setP0121(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0121())))
                        .setP0122(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0122())))
                        .setP0123(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0123())))
                        .setP0124(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0124())))
                        .setP0125(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0125())))
                        .setP0126(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0126())))
                        .setP0127(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0127())))
                        .setP0128(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0128())))
                        .setP0129(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0129())))
                        .setP0130(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0130())))
                        .setP0131(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0131())))
                        .setP0132(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0132())))
                        .setP0133(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0133())))
                        .setP0134(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0134())))
                        .setP0135(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0135())))
                        .setP0136(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0136())))
                        .setP0137(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0137())))
                        .setP0138(Bytes.toString(result.getValue(PersonInfo.family(), PersonInfo.p0138())))
                        ;
            }
        }
    };

    public List<PersonInfo> findAll() {
        return hbaseTemplate.find(PersonInfo.tableName, PersonInfo.family, rowMapperAll);
    }

    public PersonInfo findPersonInfoByRowKey(String rowKey) {
        return hbaseTemplate.get(PersonInfo.tableName, rowKey, rowMapperAll);
    }

    public void putPersonInfoy(List<PersonInfo> personInfos ) {
        hbaseTemplate.execute(PersonInfo.tableName, new TableCallback<Object>() {
            @Override
            public Object doInTable(HTableInterface htable) throws Throwable {
                List<Put> putList=new ArrayList<>();
                for (PersonInfo personInfo:personInfos) {
                   String rowKey=personInfo.getRowKey();
                   if(rowKey!=null) {
                       Put put = null;
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0101())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0101(), Bytes.toBytes(personInfo.getP0101())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getH0104())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.h0104(), Bytes.toBytes(personInfo.getH0104())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0103())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0103(), Bytes.toBytes(personInfo.getP0103())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0104())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0104(), Bytes.toBytes(personInfo.getP0104())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0105())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0105(), Bytes.toBytes(personInfo.getP0105())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0106())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0106(), Bytes.toBytes(personInfo.getP0106())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0107())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0107(), Bytes.toBytes(personInfo.getP0107())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0108())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0108(), Bytes.toBytes(personInfo.getP0108())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0109())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0109(), Bytes.toBytes(personInfo.getP0109())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0110())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0110(), Bytes.toBytes(personInfo.getP0110())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0111())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0111(), Bytes.toBytes(personInfo.getP0111())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0112())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0112(), Bytes.toBytes(personInfo.getP0112())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0113())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0113(), Bytes.toBytes(personInfo.getP0113())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0114())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0114(), Bytes.toBytes(personInfo.getP0114())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0115())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0115(), Bytes.toBytes(personInfo.getP0115())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0116())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0116(), Bytes.toBytes(personInfo.getP0116())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0117())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0117(), Bytes.toBytes(personInfo.getP0117())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0118())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0118(), Bytes.toBytes(personInfo.getP0118())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0119())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0119(), Bytes.toBytes(personInfo.getP0119())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0120())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0120(), Bytes.toBytes(personInfo.getP0120())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0121())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0121(), Bytes.toBytes(personInfo.getP0121())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0122())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0122(), Bytes.toBytes(personInfo.getP0122())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0123())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0123(), Bytes.toBytes(personInfo.getP0123())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0124())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0124(), Bytes.toBytes(personInfo.getP0124())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0125())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0125(), Bytes.toBytes(personInfo.getP0125())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0126())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0126(), Bytes.toBytes(personInfo.getP0126())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0127())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0127(), Bytes.toBytes(personInfo.getP0127())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0128())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0128(), Bytes.toBytes(personInfo.getP0128())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0129())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0129(), Bytes.toBytes(personInfo.getP0129())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0130())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0130(), Bytes.toBytes(personInfo.getP0130())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0131())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0131(), Bytes.toBytes(personInfo.getP0131())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0132())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0132(), Bytes.toBytes(personInfo.getP0132())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0133())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0133(), Bytes.toBytes(personInfo.getP0133())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0134())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0134(), Bytes.toBytes(personInfo.getP0134())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0135())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0135(), Bytes.toBytes(personInfo.getP0135())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0136())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0136(), Bytes.toBytes(personInfo.getP0136())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0137())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0137(), Bytes.toBytes(personInfo.getP0137())); }
                       if (!StringUtil.isNullOrEmpty(personInfo.getP0138())){    put = put != null ? put : new Put(Bytes.toBytes(rowKey));     put.addColumn(PersonInfo.family(), PersonInfo.p0138(), Bytes.toBytes(personInfo.getP0138())); }
                       if(put!=null) {
                           putList.add(put);
                           //每5W条提交一次
                           if(putList.size()>=50000){
                               htable.put(putList);
                               putList.clear();
                           }
                       }
                   }
                }
                if(putList.size()>0){
                    htable.put(putList);
                }
                return null;
            }
        });
    }
}
