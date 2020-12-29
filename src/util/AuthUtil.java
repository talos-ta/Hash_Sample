package util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import db.UserSampleLogic;
import entity.UserSample;
import holder.LoginUser;

@RequestScoped
public class AuthUtil {

	@Inject
	UserSampleLogic userLogic;

	@Inject
	private LoginUser loginUser;

	/**
	 * ログイン処理を行う
	 * @param user
	 * @return
	 */
	public boolean login(UserSample user) {
		// IDをキーにユーザー情報を取得
		UserSample compUser = userLogic.getUserById(user.getId());
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// 入力されたパスワードとDBのパスワード(ハッシュ化済み)を比較
		if (bcpe.matches(user.getPassword(), compUser.getPassword())) {
			loginUser.setUser(compUser);
			return true;
		}
		return false;
	}

	/**
	 * ログアウト処理を行う
	 */
	public void logout() {
		loginUser.setUser(null);
	}

	/**
	 * ユーザーを登録する
	 * @param user
	 * @return
	 */
	public boolean registerUser(UserSample user) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// ハッシュ化
		String encodeedPassword = bcpe.encode(user.getPassword());
		user.setPassword(encodeedPassword);

		int result = userLogic.insertUser(user);
		if (result > 0) {
			return true;
		}
		return false;
	}

}
