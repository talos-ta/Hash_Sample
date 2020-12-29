package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.UserSample;
import logic.UserLogic;

@Named
@RequestScoped
public class Bb01 {

	@Inject
	private UserLogic userLogic;

	/**
	 * ログアウトボタン押下後の処理
	 */
	public String logoutButton() {
		userLogic.logout();
		return "00.xhtml";
	}

	/**
	 * ログイン中のユーザーの名前を取得する
	 * @return
	 */
	public String getName() {
		UserSample user = userLogic.getUser();
		return user.getName();
	}
}
