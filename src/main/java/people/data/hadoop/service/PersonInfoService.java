package people.data.hadoop.service;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Service;
import people.data.hadoop.model.PersonInfo;

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


}
