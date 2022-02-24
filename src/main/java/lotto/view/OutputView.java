package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_COUNT_FORMAT = "개를 구매했습니다.";

    public static void displayLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTickets().size() + LOTTO_COUNT_FORMAT);
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(toIntegerNumbers(lottoTicket.getNumbers()).toString());
        }
        System.out.println();
    }

    private static List<Integer> toIntegerNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public static void displayResult(EnumMap<Rank, Integer> statistics, double calculateYield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : statistics.keySet()) {
            displayStatistics(statistics, rank);
        }
        System.out.println("총 수익률은 " + calculateYield + "입니다." + isLoss(calculateYield));
    }

    private static void displayStatistics(EnumMap<Rank, Integer> statistics, Rank rank) {
        if (rank.getMatchCount() != 0) {
            System.out.println(
                    rank.getMatchStatus() + " (" + rank.getReward() + "원) - " + statistics.get(rank) + "개");
        }
    }

    private static String isLoss(double calculateYield) {
        if (calculateYield >= 1) {
            return "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
