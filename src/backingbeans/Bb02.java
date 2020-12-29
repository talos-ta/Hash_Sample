package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import entity.UserSample;
import logic.UserLogic;

@Named
@RequestScoped
public class Bb02 {

	@NotNull
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String password;

	@Inject
	private UserLogic userLogic;

	/**
	 * 登録ボタン押下時の処理
	 * @return
	 */
	public String registerButton() {
		UserSample newUser = new UserSample(id, name, password);
		if (userLogic.registerUser(newUser)) {
			return "00.xhtml";
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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
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
