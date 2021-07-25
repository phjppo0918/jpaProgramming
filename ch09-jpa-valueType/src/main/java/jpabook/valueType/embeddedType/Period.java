package jpabook.valueType.embeddedType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class Period {

    @Temporal(TemporalType.DATE) Date startDate;
    @Temporal(TemporalType.DATE) Date entDate;

    public boolean isWork(Date date) {
        return false; //값 타입을 위한 메서드 정의
    }
}
