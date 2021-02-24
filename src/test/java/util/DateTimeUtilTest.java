package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
class DateTimeUtilTest {

    @Test
    public void test() throws Exception {
        String curDatetime = DateTimeUtil.getCurDatetime();
        Date datetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(curDatetime);
        System.out.println(curDatetime);
        System.out.println(datetime);
    }

}