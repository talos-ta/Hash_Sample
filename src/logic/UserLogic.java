package logic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import entity.UserSample;
import holder.LoginUser;
import util.AuthUtil;

@RequestScoped
public class UserLogic {

	@Inject
	private AuthUtil auth;

	@Inject
	private LoginUser loginUser;

	/**
	 * ログイン処理を行う
	 * @param user
	 * @return
	 */
	public boolean login(UserSample user) {
		if (auth.login(user)) {
			return true;
		}
		return false;
	}

	/**
	 * ログアウト処理を行う
	 */
	public void logout() {
		auth.logout();
	}

	/**
	 * ユーザーを登録する
	 * @param user
	 * @return
	 */
	public boolean registerUser(UserSample user) {
		return auth.registerUser(user);
	}

	/**
	 * ログイン中のユーザー情報を取得する
	 * @return
	 */
	public UserSample getUser() {
		return loginUser.getUser();
	}

}
