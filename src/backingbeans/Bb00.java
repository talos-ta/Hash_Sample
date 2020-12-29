package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.UserSample;
import logic.UserLogic;

@Named
@RequestScoped
public class Bb00 {

	private String id;
	private String password;

	@Inject
	private UserLogic userLogic;

	/**
	 * ログインボタン押下時の処理
	 * @return
	 */
	public String loginButton() {
		if (userLogic.login(new UserSample(id, null, password))) {
			return "01.xhtml";
		}
		return null;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
