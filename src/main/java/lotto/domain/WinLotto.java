package lotto.domain;

import lotto.utils.LottoNoUtils;

public class WinLotto {
	private static final int MIN_WIN_VALUE = 3;
	private static final int NO_WIN_VALUE = 0;

	private final Lotto lotto;
	private final BonusBall bonusBall;

	public WinLotto(String winLotto, String bonusBall) {
		this.lotto = new Lotto(LottoNoUtils.split(winLotto));
		this.bonusBall = new BonusBall(bonusBall);
	}

	public int compare(Lotto lotto) {
		int count = this.lotto.compare(lotto);
		if (count < MIN_WIN_VALUE) {
			count = NO_WIN_VALUE;
		}
		return count;
	}

	public boolean isMatchBonus(Lotto lotto) {
		return bonusBall.isContainBonusBall(lotto);
	}

}