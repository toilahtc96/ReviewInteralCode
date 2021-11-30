import Entities.UserStats;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class VisitCount {
    public static void main(String[] args) {
        Map[] visits = new Map[3];
        visits[0] = new HashMap();
        visits[0].put("1", new UserStats(Optional.of(10L)));
        visits[0].put("2", new UserStats(Optional.empty()));
        visits[0].put("3", new UserStats(Optional.of(10L)));

        visits[2] = new HashMap();
        visits[2].put("1", new UserStats(Optional.of(12L)));
        visits[2].put("2", new UserStats(Optional.empty()));
        visits[2].put("3", new UserStats(Optional.of(20L)));
        System.out.println(count(visits));

    }

    private static Map count(Map<String, UserStats>... visits) {
        //B0: đưa vào stream, filter nonNull, dùng map để chuyển visits sang dạng Map<String,UserStats>
        //B1: dùng entry lấy key value (key: id, value: usesStat chứa số lần truy cập)
        //B2: filter những visitCount khác null = isPresent
        //B3: collect lại thành Map : ID, So Lan => có thể trùng => Stream<Map<Long,Object>>
        //B4: flatMap của B3 thành Map<Long,Object>
        //B5: collect lại về Map kết quả: id = user id , key = số lần cộng lại => tham số thú 3 là Long::sum -> nếu cùng key thì sẽ sử dụng hàm cộng giá trị value
       return Arrays.stream(visits).filter(Objects::nonNull).map(userStatsById
               ->userStatsById.entrySet().stream()
               .filter(it->isNumber(it.getKey()))
               .filter(it->it.getValue().getVisitCount().isPresent())
               .collect(
                       Collectors.toMap(
                                        it -> Long.parseLong(it.getKey()),
                                        it -> it.getValue().getVisitCount().get()
                                ))).flatMap(it -> it.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                p->p.getKey(),
                                p->{
                                    return Long.parseLong(p.getValue().toString());
                                },
                                Long::sum
                        )
                );
    }

    private static boolean isNumber(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
